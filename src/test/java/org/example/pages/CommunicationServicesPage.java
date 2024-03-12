package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommunicationServicesPage extends BasePage {
    @FindBy(id ="connection-phone")
     WebElement numberPlaceholderText;
    @FindBy(id = "connection-sum")
     WebElement pricePlaceholderText;
    @FindBy(id = "connection-email")
     WebElement emailPlaceHolderText;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    WebElement continueButton;

    public CommunicationServicesPage(WebDriver driver) {
        super(driver);
    }

    public String getNumberPlaceholderText() {
        return numberPlaceholderText.getAttribute("placeholder");
    }

    public String getPricePlaceholderText() {
        return pricePlaceholderText.getAttribute("placeholder");
    }

    public String getEmailPlaceHolderText() {
        return emailPlaceHolderText.getAttribute("placeholder");
    }

    public boolean continueButtonIsDisplayed() {
       return continueButton.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void fillOutForm(String numberOfPhone, String amountOfMoney, String email) {
        numberPlaceholderText.click();
        numberPlaceholderText.sendKeys(numberOfPhone);
        pricePlaceholderText.click();
        pricePlaceholderText.sendKeys(amountOfMoney);
        emailPlaceHolderText.click();
        emailPlaceHolderText.sendKeys(email);
    }

}
