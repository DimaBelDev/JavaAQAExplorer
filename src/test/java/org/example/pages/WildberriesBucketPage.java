package org.example.pages;

import org.example.utils.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WildberriesBucketPage extends BasePage {

    @FindBy(xpath = "//div[@class='accordion__list-item list-item j-b-basket-item']//span[@class='good-info__good-name']")
    private List<WebElement> nameOfProductInBucket;

    @FindBy(xpath = "//div[@class='accordion__list-item list-item j-b-basket-item']//span[@class='good-info__good-brand ']")
    private List<WebElement> brandOfProductInBucket;

    @FindBy(xpath = "//div[@class='accordion__list-item list-item j-b-basket-item']//div[@class='list-item__price-wallet']")
    private List<WebElement> priceOfProductInBucket;

    @FindBy(xpath = "//div[@class='accordion__list-item list-item j-b-basket-item']//div[@class='list-item__price-new wallet']")
    private List<WebElement> priceOfProductInBucketWithWbWallet;

    @FindBy(xpath = "//div[@class='basket-form__basket-section basket-section']//h1[@class='basket-section__header active']")
    private WebElement quantityAndSum;

    @FindBy(xpath = "//div[@class='basket-order__b-top b-top']//span[@class='b-right']")
    private WebElement priceSum;

    private final List<Product> productsInBucket = new ArrayList<>();

    public WildberriesBucketPage(WebDriver driver) {
        super(driver);
    }

    public Double getPriceOfEachProduct() {
       return priceOfProductInBucketWithWbWallet.stream()
               .map(WebElement::getText).map(p -> p.replace(" ₽", "").replace(" ", ""))
               .mapToDouble(Double::parseDouble)
               .sum();
    }

    public Double getCommonPrice() {
       return Double.parseDouble(priceSum.getText().replace(" ₽", "").replace(" ", ""));
    }

    public Integer getQuantity(){
        return Integer.parseInt(quantityAndSum.getAttribute("data-count"));
    }

    public List<Product> getAllProductsFromBucket(int count) {
        for (int i = 0; i < count; i++) {
            String price = getPriceOfProductInBucket().get(i);
            String brand = getBrandOfProduct().get(i).getText().replace(", ", "");
            String productName = getNameOfProducts().get(i).getText().replace(".", "");
            productsInBucket.add(new Product(Integer.parseInt(price), brand, productName));
        }
        Collections.sort(productsInBucket);
        return productsInBucket;
    }

    private List<WebElement> getNameOfProducts(){
        return nameOfProductInBucket;
    }

    private List<WebElement> getBrandOfProduct(){
        return brandOfProductInBucket;
    }

    private List<String> getPriceOfProductInBucket() {

        return priceOfProductInBucket.stream()
                .map(p -> p.getText().replace(" ₽", "").replace(" ", ""))
                .collect(Collectors.toList());
    }

}
