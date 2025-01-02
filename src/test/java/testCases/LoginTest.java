package testCases;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v129.page.model.WebAppManifest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

import java.io.IOException;

public class LoginTest extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;


    @Test(groups = {"Sanity", "Regression", "Smoke"}, priority = 0)
    public void verifyValidLogin() throws IOException, ParseException {

        homePage = new HomePage(getDriver());
        homePage.clickMyAccountDropDownText().clickLoginDropDownLink();
        loginPage = new LoginPage(getDriver());
        loginPage.enterEmailId(readJsonData().get("emailId").toString())
                .enterPassword(readJsonData().get("password").toString()).clickLoginButton();
        myAccountPage = new MyAccountPage(getDriver());
        Assert.assertTrue(myAccountPage.isMyAccountTextDisplayed());
    }

}
