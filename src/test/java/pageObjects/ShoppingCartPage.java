package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By shoppingCartTitle = By.xpath("//a[@title='Shopping Cart']");
    By productNameHeader = By.xpath("//td[text()='Product Name']");
    By checkoutButton = By.xpath("//a[text()='Checkout']");


    public Boolean isShoppingCartTitleDisplayed() {
        return isDisplayed(shoppingCartTitle);
    }

    public String getProductText() {
        String product = find(RelativeLocator.with(By.tagName("a")).below(find(productNameHeader))).getText();
        return product;

    }

    public void clickCheckoutButton() {
        click(checkoutButton);
    }


}
