package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentInstalmentsPage extends BasePage {
    @FindBy(id = "score-instalment")
    WebElement numberOfAccount;
    @FindBy(id = "instalment-sum")
    WebElement pricePlaceholderText;
    @FindBy(id = "instalment-email")
    WebElement emailPlaceHolderText;


    public PaymentInstalmentsPage(WebDriver driver) {
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
