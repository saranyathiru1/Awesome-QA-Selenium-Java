package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    By checkOutTitle = By.xpath("//h1[text()='Checkout']");
    By firstNameText = By.cssSelector("#input-payment-firstname");
    By lastNameText = By.cssSelector("#input-payment-lastname");
    By address1Text = By.name("address_1");
    By cityText = By.cssSelector("#input-payment-city");
    By postalCodeText = By.cssSelector("#input-payment-postcode");
    By countryDropDown = By.cssSelector("#input-payment-country");
    By stateDropDown = By.cssSelector("#input-payment-zone");
    By continueBillingDetailsButton = By.xpath("//input[@id='button-payment-address']");
    By continueDeliveryDetailsButton = By.xpath("//input[@id='button-shipping-address']");
    By continueDeliveryMethodButton = By.xpath("//input[@id='button-shipping-method']");
    By deliveryMethodCommentsTextBox = By.xpath("//textarea[@name='comment']");
    By continuePaymentMethodButton = By.xpath("//input[@id='button-payment-method']");
    By paymentMethodAgreeCheckBox = By.xpath("//input[@name='agree']");
    By confirmOrderButton = By.xpath("//input[@id='button-confirm']");
    By returningCustomerText = By.xpath("//h2[text()='Returning Customer']");
    By customerEmailText = By.cssSelector("#input-email");
    By customerPasswordText = By.cssSelector("#input-password");
    By customerLoginButton = By.xpath("//input[@id='button-login']");


    public String getCheckoutTitleText() {
        return getTextValue(checkOutTitle);
    }

    public CheckoutPage enterFirstName(String firstName) {
        set(firstNameText, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        set(lastNameText, lastName);
        return this;
    }

    public CheckoutPage enterAddress1Text(String address1) {
        set(address1Text, address1);
        return this;
    }

    public CheckoutPage enterCityText(String city) {
        set(cityText, city);
        return this;
    }

    public CheckoutPage enterPostalCodeText(String postalCode) {
        set(postalCodeText, postalCode);
        return this;
    }

    public CheckoutPage selectCountry(String country) {
        selectDropDown(countryDropDown, country);
        return this;
    }

    public CheckoutPage selectState(String state) {
        selectDropDown(stateDropDown, state);
        return this;
    }

    public CheckoutPage clickContinueBillingDetailsButton() {
        click(continueBillingDetailsButton);
        return this;
    }

    public CheckoutPage clickContinueDeliveryDetailsButton() {
        click(continueDeliveryDetailsButton);
        return this;
    }

    public CheckoutPage clickContinueDeliveryMethodsButton() {
        click(continueDeliveryMethodButton);
        return this;
    }

    public CheckoutPage clickContinuePaymentMethodsButton() {
        click(continuePaymentMethodButton);
        return this;
    }

    public CheckoutPage clickConfirmOrderButton() {
        click(confirmOrderButton);
        return this;
    }

    public CheckoutPage enterDeliveryMethodsCommentsText(String comments) {
        set(deliveryMethodCommentsTextBox, comments);
        return this;
    }

    public CheckoutPage checkPaymentAgreeCheckBox() {
        click(paymentMethodAgreeCheckBox);
        return this;
    }

    public CheckoutPage enterBillingDetails(String firstName, String lastName, String address1, String city, String postalCode, String country, String state) {
        enterFirstName(firstName).enterLastName(lastName).enterAddress1Text(address1)
                .enterCityText(city).enterPostalCodeText(postalCode)
                .selectCountry(country).selectState(state);
        return this;
    }

    public Boolean isReturningCustomerTextDisplayed() {
        return isDisplayed(returningCustomerText);
    }

    public CheckoutPage enterLoginDetails(String emailId, String password) {
        if (isReturningCustomerTextDisplayed() == true) {
            set(customerEmailText, emailId);
            set(customerPasswordText, password);
            click(customerLoginButton);
        }
        return this;
    }

}
