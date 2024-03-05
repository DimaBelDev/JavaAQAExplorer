package org.example.test;

import org.example.BaseTest;
import org.example.pages.WildberriesBucketPage;
import org.example.pages.WildberriesMainPage;
import org.example.utils.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WildberriesBucketTest extends BaseTest {
    private static final int COUNT = 3;

      private WildberriesMainPage wildberriesMainPage;
      private WildberriesBucketPage wildberriesBucketPage;



    @Test
    public void validateProductEqualityTest() throws InterruptedException {
        wildberriesMainPage = new WildberriesMainPage(getDriver());
        wildberriesBucketPage = new WildberriesBucketPage(getDriver());
        List<Product> productsOnMainPage = wildberriesMainPage.addProductsToBucket(COUNT);
        Thread.sleep(4000);
        List<Product> productsInCart = wildberriesBucketPage.getAllProductsFromBucket(COUNT);
        Assert.assertEquals(productsOnMainPage, productsInCart);
    }

    @Test(dependsOnMethods = "validateProductEqualityTest")
    public void priceSumTest() {
        Assert.assertEquals(wildberriesBucketPage.getPriceOfEachProduct(), wildberriesBucketPage.getCommonPrice());
    }

    @Test(dependsOnMethods = "validateProductEqualityTest")
    public void quantityTest() {
        Assert.assertEquals(wildberriesMainPage.getCountOfAddedProducts(), wildberriesBucketPage.getQuantity());
    }
}
