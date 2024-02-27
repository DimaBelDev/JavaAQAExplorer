package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    protected void beforeMethod() {
        driver = setUp();
        configureDriver();
        maximizeWindow();
        navigateToURL("https://www.mts.by/");
        clickCookieAgreeButton();
    }

    private static final long IMPLICITLY_WAIT = 10;
    private static final long PAGE_LOAD_TIMEOUT = 10;
    private static final long SET_SCRIPT_TIMEOUT = 10;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver setUp() {
        driver = new ChromeDriver();
        configureDriver();
        return driver;
    }

    private void configureDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIMEOUT, TimeUnit.SECONDS);
    }

    protected void maximizeWindow() {
        driver.manage().window().maximize();
    }

    protected void navigateToURL(String url) {
        driver.get(url);
    }

    protected void clickCookieAgreeButton() {
        WebElement cookieButton = driver.findElement(By.id("cookie-agree"));
        cookieButton.click();
    }

    protected WebElement findElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void sendKeysToElement(By locator, String keys) {
        findElement(locator).sendKeys(keys);
    }

    protected void clickElement(By locator) {
        findElement(locator).click();
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    protected void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
