package org.example.base;

import org.example.pages.BasePage;
import org.example.pages.MtsMainPage;
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
        mtsMainPage = new MtsMainPage(driver);
    }

    private static final long IMPLICITLY_WAIT = 10;
    private static final long PAGE_LOAD_TIMEOUT = 10;
    private static final long SET_SCRIPT_TIMEOUT = 10;

    private WebDriver driver;
    protected MtsMainPage mtsMainPage;
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


    @AfterMethod
    protected void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
