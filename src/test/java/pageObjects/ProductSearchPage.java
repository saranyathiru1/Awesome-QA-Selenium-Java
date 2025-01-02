package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductSearchPage extends BasePage {

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    private By productsText = By.xpath("//div[@class='caption']//h4");
    private By addToCartButton = By.xpath("//span[text()='Add to Cart']");
    private By sortProductDropDown = By.cssSelector("#input-sort");
    private By addToWishListIcon = By.xpath("//button[@data-original-title='Add to Wish List']");
    private By cartTotalButton = By.id("cart-total");
    private By checkOutLink = By.xpath("//strong[text()=' Checkout']");
    private By viewCartLink = By.xpath("//strong[text()=' View Cart']");

    public String getProductText() {
        return getTextValue(productsText);
    }

    public ProductSearchPage clickAddToCartButton() {
        click(addToCartButton);
        return this;
    }

    public ProductSearchPage sortProduct(String value) {
//        Select select = new Select(find(sortProductDropDown));
//        select.selectByValue(value);
        selectDropDown(sortProductDropDown, value);
        return this;
    }

    public ProductSearchPage clickAddToWishListIcon() {
        click(addToWishListIcon);
        return this;
    }

    public ProductSearchPage clickCartTotalButton() {
        click(cartTotalButton);
        return this;
    }

    public ProductSearchPage clickCheckOutLink() {
        click(checkOutLink);
        return this;
    }

    public ProductSearchPage clickViewCartLink() {
        click(viewCartLink);
        return this;
    }


}
