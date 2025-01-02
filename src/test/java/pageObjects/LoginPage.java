package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailIdTextBox = By.id("input-email");
    private By passwordTextBox = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");

    public LoginPage enterEmailId(String emailId) {
        set(emailIdTextBox, emailId);
        return this;
    }

    public LoginPage enterPassword(String password) {
        set(passwordTextBox, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public HomePage validLogin(String emailId, String password) {
        set(emailIdTextBox, emailId);
        set(passwordTextBox, password);
        return new HomePage(driver);
    }


}


