package testCases;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductSearchPage;
import testBase.BaseTest;

import java.io.IOException;


public class ProductSearchTest extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;
    public ProductSearchPage productSearchPage;
    public static String productText = "";


    @Test(groups = "Regression", priority = 1)

    public void verifySearchWithExistingProduct() throws IOException, ParseException {
        homePage = new HomePage(getDriver());
        homePage.enterProductNameInSearchBox("imac").clickProductSearchIcon();
        productSearchPage = new ProductSearchPage(getDriver());
        productText = productSearchPage.getProductText();
        Assert.assertEquals(productText, "iMac", "Search Product found!");

    }

}
