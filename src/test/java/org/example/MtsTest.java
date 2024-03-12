package org.example;

import org.example.base.BaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MtsTest extends BaseTest {

    private String email;
    private String phoneNumber;
    private String amountOfMoney;


    @BeforeClass
    public void setUpTestData() {
        email = "test@gmail.com";
        phoneNumber = "297777777";
        amountOfMoney = "100";
    }

    @Test
    public void testCommunicationServices() {
        CommunicationServicesPage communicationServicesPage = new CommunicationServicesPage(getDriver());

        Assert.assertEquals(communicationServicesPage.getNumberPlaceholderText(), "Номер телефона");
        Assert.assertEquals(communicationServicesPage.getPricePlaceholderText(), "Сумма");
        Assert.assertEquals(communicationServicesPage.getEmailPlaceHolderText(), "E-mail для отправки чека");
    }

    @Test
    public void testHomeInternet() {
        HomeInternetPage homeInternetPage = new HomeInternetPage(getDriver());
        MtsMainPage mtsMainPage = new MtsMainPage(getDriver());
        mtsMainPage.homeInternetSelect();
        Assert.assertEquals(homeInternetPage.getSubscriberNumber(), "Номер абонента");
        Assert.assertEquals(homeInternetPage.getPricePlaceholderText(), "Сумма");
        Assert.assertEquals(homeInternetPage.getEmailPlaceHolderText(), "E-mail для отправки чека");
    }

    @Test
    public void testPaymentInstalments() {
        PaymentInstalmentsPage paymentInstalmentsPage = new PaymentInstalmentsPage(getDriver());
        MtsMainPage mtsMainPage = new MtsMainPage(getDriver());
        mtsMainPage.instalmentSelect();

        Assert.assertEquals(paymentInstalmentsPage.getNumberOfAccount(), "Номер счета на 44");
        Assert.assertEquals(paymentInstalmentsPage.getPricePlaceholderText(), "Сумма");
        Assert.assertEquals(paymentInstalmentsPage.getEmailPlaceHolderText(), "E-mail для отправки чека");
    }

    @Test
    public void testArrears() {
        ArrearsPage arrearsPage = new ArrearsPage(getDriver());
        MtsMainPage mtsMainPage = new MtsMainPage(getDriver());
        mtsMainPage.arrearsSelect();

        Assert.assertEquals(arrearsPage.getNumberOfAccount(), "Номер счета на 2073");
        Assert.assertEquals(arrearsPage.getPricePlaceholderText(), "Сумма");
        Assert.assertEquals(arrearsPage.getEmailPlaceHolderText(), "E-mail для отправки чека");
    }

    @Test
    public void testСonfirmForm() {
        CommunicationServicesPage communicationServicesPage = new CommunicationServicesPage(getDriver());
        communicationServicesPage.fillOutForm(phoneNumber, amountOfMoney, email);
        Assert.assertTrue(communicationServicesPage.continueButtonIsDisplayed(), "Кнопка 'Продолжить' не отображается");
        communicationServicesPage.clickContinueButton();

        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        confirmPage.ConfirmWindowIsDisplayed();

        Assert.assertTrue(confirmPage.getPhoneNumberTest().contains(phoneNumber));
        Assert.assertTrue(confirmPage.IconsIsDisplayed());
        Assert.assertTrue(confirmPage.getAmountOfMoneyHeader().contains(amountOfMoney));
        Assert.assertTrue(confirmPage.getCardNumberInput().contains("Номер карты"));
        Assert.assertTrue(confirmPage.getCvcInput().contains("CVC"));
        Assert.assertTrue(confirmPage.getValidityInput().contains("Срок действия"));
        Assert.assertTrue(confirmPage.getCardNameInput().contains("Имя держателя (как на карте)"));
        Assert.assertTrue(confirmPage.getAmountOfMoneyButton().contains(amountOfMoney));
    }


}
