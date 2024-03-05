package org.example.pages;

import org.example.utils.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WildberriesMainPage extends BasePage {

    @FindBy(xpath = "//article[@data-target-url='MI']")
    private List<WebElement> allProducts;
    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    private WebElement bucketButton;
    @FindBy(xpath = "//div[@class='popup__content']")
    private WebElement sizesPopUp;
    @FindBy(xpath = "//div[@class='popup__content']//li[@class='sizes-list__item']")
    private WebElement sizesButton;


    private final List<Product> addedProductToBucket = new ArrayList<>();

    public WildberriesMainPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> addProductsToBucket(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            Thread.sleep(1000);
            if(isDisplayedSizesPopup())
                clickSizesButton();

            productAddToBucket(i);

            addedProductToBucket.add(new Product((Double.parseDouble(getPriceOfProduct(getId(i)))), getBrandOfProduct(getId(i)), getNameOfProduct(getId(i))));
        }
        Collections.sort(addedProductToBucket);
        Thread.sleep(2000);
        clickOpenBucketButton();
        return addedProductToBucket;
    }

    public Integer getCountOfAddedProducts() {
        return addedProductToBucket.size();
    }

    private String buildProductXPath(String id) {
        return String.format("//article[@data-target-url='MI' and @data-nm-id='%s']//a[@class='product-card__add-basket j-add-to-basket btn-main']", id);
    }

    private String buildProductDetailXPath(String id, String detailXPath) {
        return String.format("//article[@data-target-url='MI' and @data-nm-id='%s']%s", id, detailXPath);
    }

    private void clickOpenBucketButton() {
        bucketButton.click();
    }

    private void clickSizesButton(){
        sizesButton.click();
    }

    private boolean isDisplayedSizesPopup() {
        return sizesPopUp.isDisplayed();
    }

    private void productAddToBucket(int num) {
        bucketButtonWait();
        String productXPath = buildProductXPath(getId(num));
        getDriver().findElement(By.xpath(productXPath)).click();
    }

    private void bucketButtonWait() {
        List<WebElement> bucketButtonElements = getDriver().findElements(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']"));
        while (bucketButtonElements.isEmpty()) {
            try {
                getDriver().navigate().refresh();
                bucketButtonElements = getDriver().findElements(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']"));
            } catch (StaleElementReferenceException e) {
                     e.getStackTrace();
            }
        }
    }
    private String getId(int num) {
        return allProducts.get(num).getAttribute("data-nm-id");
    }

    private String getPriceOfProduct(String id) {
        String priceXPath = buildProductDetailXPath(id, "//ins[@class='price__lower-price wallet-price']");
        return getDriver().findElement(By.xpath(priceXPath)).getText().replace(" ₽", "").replace(" ", "");
    }

    private String getBrandOfProduct(String id) {
        String brandXPath = buildProductDetailXPath(id, "//span[@class='product-card__brand-container']");
        return getDriver().findElement(By.xpath(brandXPath)).getText();
    }

    private String getNameOfProduct(String id) {
        String nameXPath = buildProductDetailXPath(id, "//span[@class='product-card__name']");
        return getDriver().findElement(By.xpath(nameXPath)).getText().replace("/ ", "").replace(".", "");
    }

}
