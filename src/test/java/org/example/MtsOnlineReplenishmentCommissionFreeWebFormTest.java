package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class MtsOnlineReplenishmentCommissionFreeWebFormTest extends BaseTest {

    @DataProvider(name = "typeOfCart")
    public String[][] paySystems() {
        return new String[][] {
                { "Visa" },
                { "Verified By Visa" },
                { "MasterCard" },
                { "MasterCard Secure Code" },
                { "Белкарт" },
                { "МИР" }
        };
    }


    @Test
    public void testBlockTitle() {
        WebElement onlinePayFormText = findElement(By.xpath("//h2[text()='Онлайн пополнение ' and text()='без комиссии']"));
        Assert.assertTrue(onlinePayFormText.isDisplayed(), "Название не отображается");
        Assert.assertEquals(onlinePayFormText.getText(), "Онлайн пополнение\nбез комиссии", "Название некорректно");
    }

    @Test(dataProvider = "typeOfCart")
    public void testPaySystemLogos (String paySystem) {
        WebElement paySystemLogo = findElement(By.xpath(String.format("//img[@alt = '%s']", paySystem)));
        Assert.assertTrue(paySystemLogo.isDisplayed());
    }

    @Test
    public void testMoreDetailsServiceLink() {
        WebElement moreDetailsButton = findElement(By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        moreDetailsButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", "Ссылка не работает");
    }

    @Test
    public void testOnlinePayForm() {
        String phone = "297777777";
        String paySum = "100.00";
        String email = "test@gmail.com";

        sendKeysToElement(By.xpath("//div[@class='pay__forms']/form/div/input[@class='phone']"), phone);
        sendKeysToElement(By.xpath("//div[@class='pay__forms']/form/div/input[@class='total_rub']"), paySum);
        sendKeysToElement(By.xpath("//div[@class='pay__forms']/form/div/input[@class='email']"), email);

        boolean continueButtonIsDisplayed = findElement(By.xpath("//div[@class='pay__forms']/form/button")).isDisplayed();

        Assert.assertTrue(continueButtonIsDisplayed, "Кнопка 'Продолжить' не отображается");

        clickElement(By.xpath("//div[@class='pay__forms']/form/button"));

        WebElement frame = findElement(By.xpath("//iframe[@class='bepaid-iframe']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='app-wrapper__content']"))).isDisplayed();
        switchToDefaultContent();
        Assert.assertTrue(isDisplayed, "Окно платежа не отображается");
    }
}
