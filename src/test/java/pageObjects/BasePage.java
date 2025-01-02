package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    protected String getTextValue(By locator) {
        return find(locator).getText();
    }

    protected void selectDropDown(By locator, String text) {
        Select select = new Select(find(locator));
        select.selectByContainsVisibleText(text);
    }

    protected void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", find(locator));
    }

    public static void delay(int milliseconds) {
        // Demo Purpose
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

}
