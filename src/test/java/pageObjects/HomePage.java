package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By yourCartTitleText = By.xpath("//img[@title='Your Store']");
    private By myAccountDropDownText = By.xpath("//span[normalize-space()='My Account']");
    private By registerDropDownLink = By.xpath("//a[text()='Register']");
    private By loginDropDownLink = By.linkText("Login");
    private By logoutDropDownLink = By.linkText("Logout");
    private By shoppingCartLink = By.xpath("//a[@title='Shopping Cart']");
    private By orderHistoryDropDownLink = By.linkText("Order History");
    private By homeIcon = By.xpath("//i[@class='fa fa-home']");
    private By searchProductBox = By.xpath("//input[@placeholder='Search']");
    private By searchIcon = By.xpath("//i[@class='fa fa-search']//parent::button");


    public void clickYourCartTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(yourCartTitleText));
        click(yourCartTitleText);
    }

    public void isAccountDropDownTextVisible() {
        System.out.println(isDisplayed(myAccountDropDownText));
    }

    public HomePage clickMyAccountDropDownText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropDownText));
        click(myAccountDropDownText);
        return this;
    }

    public HomePage clickRegisterDropDownLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(registerDropDownLink));
        click(registerDropDownLink);
        return this;
    }

    public HomePage clickLoginDropDownLink() {
        click(loginDropDownLink);
        return this;
    }

    public HomePage clickLogoutDropDownLink() {
        click(logoutDropDownLink);
        return this;
    }

    public HomePage enterProductNameInSearchBox(String product) {
        set(searchProductBox, product);
        return this;
    }

    public HomePage clickProductSearchIcon() {
        click(searchIcon);
        return this;
    }

    public HomePage clickShoppingCartLink() {
        jsClick(shoppingCartLink);
        return this;
    }

    public HomePage clickHomeIcon() {
        click(homeIcon);
        return this;
    }

    public HomePage clickOrderHistoryDropDownLink() {
        click(orderHistoryDropDownLink);
        return this;
    }

}
