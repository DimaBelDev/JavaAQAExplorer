package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeInternetPage extends BasePage {

    @FindBy(id = "internet-phone")
    WebElement subscriberNumber;
    @FindBy(id = "internet-sum")
    WebElement pricePlaceholderText;
    @FindBy(id = "internet-email")
    WebElement emailPlaceHolderText;

    public HomeInternetPage(WebDriver driver) {
        super(driver);
    }

    public String getSubscriberNumber() {
        return subscriberNumber.getAttribute("placeholder");
    }

    public String getPricePlaceholderText() {
        return pricePlaceholderText.getAttribute("placeholder");
    }

    public String getEmailPlaceHolderText() {
        return emailPlaceHolderText.getAttribute("placeholder");
    }
}
