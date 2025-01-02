package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.OrderConfirmationPage;
import pageObjects.OrderHistoryPage;
import testBase.BaseTest;

public class OrderHistoryTest extends BaseTest {

    public OrderConfirmationPage orderConfirmationPage;
    public OrderHistoryPage orderHistoryPage;
    public HomePage homePage;


    @Test(groups = "Regression", priority = 5)
    public void verifyOrderPresentInOrderHistoryPage() {

        orderConfirmationPage = new OrderConfirmationPage(getDriver());
        homePage = new HomePage(getDriver());
        orderHistoryPage = new OrderHistoryPage(getDriver());
        orderConfirmationPage.clickHomeIcon();
        homePage.clickOrderHistoryDropDownLink();
        Assert.assertTrue(orderHistoryPage.isOrderIdDisplayed());
        Assert.assertTrue(orderHistoryPage.isCustomerNameDisplayed());
        Assert.assertTrue(orderHistoryPage.isNumberOfProductsDisplayed());

    }
}
