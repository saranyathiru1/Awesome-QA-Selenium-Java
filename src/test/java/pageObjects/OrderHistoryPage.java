package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BasePage {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    By orderIdText = By.xpath("//table[@class='table table-bordered table-hover']//child::tbody//tr//td[1]");
    By customerNameText = By.xpath("//table[@class='table table-bordered table-hover']//child::tbody//tr//td[2]");
    By numberOfProductsText = By.xpath("//table[@class='table table-bordered table-hover']//child::tbody//tr//td[3]");

    public Boolean isOrderIdDisplayed() {
        return isDisplayed(orderIdText);
    }

    public Boolean isCustomerNameDisplayed() {
        return isDisplayed(customerNameText);
    }

    public Boolean isNumberOfProductsDisplayed() {
        return isDisplayed(numberOfProductsText);
    }


}
