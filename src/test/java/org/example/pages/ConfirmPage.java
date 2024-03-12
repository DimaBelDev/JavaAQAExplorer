package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class ConfirmPage extends BasePage {

    @FindBy(xpath = "//div[@class= 'header__payment-amount']")
    private WebElement amountOfMoneyHeader;
    @FindBy(xpath = "//p[contains(@class,'header__payment-info')]")
    private WebElement phoneNumberTest;
    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c47-1')]")
    private WebElement cardNumberInput;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-4')]")
    private WebElement validityInput;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-5')]")
    private WebElement cvcInput;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-3')]")
    private WebElement cardNameInput;
    @FindBy(xpath = "//button[@class='colored disabled ng-star-inserted']")
    private WebElement amountOfMoneyButton;
    @FindBy(xpath = "//img[contains(@src,'mastercard-system')]")
    private WebElement mastercardIcon;
    @FindBy(xpath = "//img[contains(@src,'visa-system')]")
    private WebElement visaIcon;
    @FindBy(xpath = "//img[contains(@src,'belkart-system')]")
    private WebElement belIcon;
    @FindBy(xpath = "//img[contains(@src,'mir-system')]")
    private WebElement mirIcon;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneNumberTest() {
        return phoneNumberTest.getText();
    }

    public String getAmountOfMoneyHeader() {
        return amountOfMoneyHeader.getText();
    }

    public String getAmountOfMoneyButton() {
        return amountOfMoneyButton.getText();
    }

    public String getCardNumberInput() {
        return cardNumberInput.getText();
    }

    public String getValidityInput() {
        return validityInput.getText();
    }

    public String getCvcInput() {
        return cvcInput.getText();
    }

    public String getCardNameInput() {
        return cardNameInput.getText();
    }

    public WebElement ConfirmWindowIsDisplayed() {
        WebElement iframe = getWait10().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        getDriver().switchTo().frame(iframe);
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='app-wrapper__content']")));
    }

    public boolean IconsIsDisplayed() {
        List<WebElement> icons = Arrays.asList(mastercardIcon, visaIcon, belIcon, mirIcon);
        for (WebElement icon : icons) {
            if (icon.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
