package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private By myAccountText = By.xpath("//div[@id='content']//child::h2[text()='My Account']");
    private By logoutDropDownLink = By.linkText("Logout");

    public String getMyAccountTextValue() {
        return getTextValue(myAccountText);
    }

    public Boolean isMyAccountTextDisplayed() {
        try {
            return isDisplayed(myAccountText);
        } catch (Exception e) {
            return false;
        }
    }

    public MyAccountPage clickLogoutDropDownLink() {
        click(logoutDropDownLink);
        return this;
    }

}
