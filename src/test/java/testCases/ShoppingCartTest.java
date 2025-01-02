package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductSearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseTest;

public class ShoppingCartTest extends BaseTest {

    public HomePage homePage;
    public ProductSearchPage productSearchPage;
    public ShoppingCartPage shoppingCartPage;


    @Test(groups = "Regression", priority = 2)
    public void validateShoppingCart() {
        homePage = new HomePage(getDriver());
        productSearchPage = new ProductSearchPage(getDriver());
        productSearchPage.clickAddToCartButton();
        homePage.clickShoppingCartLink();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        Assert.assertTrue(shoppingCartPage.isShoppingCartTitleDisplayed());
        Assert.assertEquals(shoppingCartPage.getProductText(), ProductSearchTest.productText);

    }
}