package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameTextBox = By.id("input-firstname");
    private By lastNameTextBox = By.id("input-lastname");
    private By emailTextBox = By.id("input-email");
    private By telephoneTextBox = By.id("input-telephone");
    private By passwordTextBox = By.id("input-password");
    private By passwordConfirmTextBox = By.id("input-confirm");
    private By subscribeYesRadioButton = By.xpath("//input[@name='newsletter' and @value=1]");
    private By agreeCheckBox = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By accountCreatedTextValue = By.xpath("//h1[contains(text(),'Your Account')]");


    public RegistrationPage enterFirstName(String firstName) {
        set(firstNameTextBox, firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        set(lastNameTextBox, lastName);
        return this;
    }

    public RegistrationPage enterEmailId(String email) {
        set(emailTextBox, email);
        return this;
    }

    public RegistrationPage enterTelephoneNumber(String telephoneNumber) {
        set(telephoneTextBox, telephoneNumber);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        set(passwordTextBox, password);
        return this;
    }


    public RegistrationPage enterConfirmPasswordText(String password) {
        set(passwordConfirmTextBox, password);
        return this;
    }

    public RegistrationPage clickSubscribeYesRadioButton() {
        click(subscribeYesRadioButton);
        return this;
    }

    public RegistrationPage clickAgreeCheckbox() {
        click(agreeCheckBox);
        return this;
    }

    public RegistrationPage clickContinueButton() {
        click(continueButton);
        return this;
    }

    public String getAccountCreatedConfirmationTextValue() {
        try {
            return getTextValue(accountCreatedTextValue);
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

}
