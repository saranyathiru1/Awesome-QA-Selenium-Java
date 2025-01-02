package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    By orderConfirmationText = By.xpath("//div[@id='content']//h1");
    By orderConfirmationDescText = By.xpath("//div[@id='content']//child::p[1]");
    By homeIcon = By.xpath("//i[@class='fa fa-home']");

    public String getOrderConfirmationText() {
        return getTextValue(orderConfirmationText);
    }

    public String getOrderConfirmationDescText() {
        return getTextValue(orderConfirmationDescText);
    }

    public OrderConfirmationPage clickHomeIcon() {
        click(homeIcon);
        return this;
    }


}
