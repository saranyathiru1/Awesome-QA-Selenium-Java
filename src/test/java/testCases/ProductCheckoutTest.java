package testCases;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.ProductSearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseTest;

import java.io.IOException;

public class ProductCheckoutTest extends BaseTest {

    public ProductSearchPage productSearchPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutPage checkoutPage;
    public OrderConfirmationPage orderConfirmationPage;


    @Test(groups = "Regression", priority = 3)
    public void verifyProductCheckOutTitleDisplayed() {

        shoppingCartPage = new ShoppingCartPage(getDriver());
        shoppingCartPage.clickCheckoutButton();
        checkoutPage = new CheckoutPage(getDriver());
        Assert.assertEquals(checkoutPage.getCheckoutTitleText(), "Checkout");

    }

    @Test(groups = "Regression", priority = 4)
    public void verifyProductCheckOutAndOrderPlacing() throws IOException, ParseException, InterruptedException {

        orderConfirmationPage = new OrderConfirmationPage(getDriver());
        String firstName = readJsonData().get("firstName").toString();
        String lastName = readJsonData().get("lastName").toString();
        String emailId = readJsonData().get("emailId").toString();
        String password = readJsonData().get("password").toString();
        String address1 = readJsonData().get("address1").toString();
        String city = readJsonData().get("city").toString();
        String country = readJsonData().get("country").toString();
        String postalCode = readJsonData().get("postalCode").toString();
        String state = readJsonData().get("state").toString();

        verifyProductCheckOutTitleDisplayed();
        checkoutPage.enterBillingDetails(firstName, lastName, address1, city, postalCode, "United States", "Florida")
                .clickContinueBillingDetailsButton().clickContinueDeliveryDetailsButton()
                .enterDeliveryMethodsCommentsText("Please drop the shipment in address provided!")
                .clickContinueDeliveryMethodsButton().checkPaymentAgreeCheckBox()
                .clickContinuePaymentMethodsButton().clickConfirmOrderButton();
        Thread.sleep(5000);
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationText(), "Your order has been placed!", "Verify order confirmation text displayed");
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationDescText(), "Your order has been successfully processed!", "Verify order confirmation description text displayed");

    }
}
