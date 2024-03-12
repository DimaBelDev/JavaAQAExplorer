package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArrearsPage extends BasePage {

    @FindBy(id = "score-arrears")
    WebElement numberOfAccount;
    @FindBy(id = "arrears-sum")
    WebElement pricePlaceholderText;
    @FindBy(id = "arrears-email")
    WebElement emailPlaceHolderText;


    public ArrearsPage(WebDriver driver) {
        super(driver);
    }

    public String getNumberOfAccount() {
        return numberOfAccount.getAttribute("placeholder");
    }

    public String getPricePlaceholderText() {
        return pricePlaceholderText.getAttribute("placeholder");
    }

    public String getEmailPlaceHolderText() {
        return emailPlaceHolderText.getAttribute("placeholder");
    }
}
