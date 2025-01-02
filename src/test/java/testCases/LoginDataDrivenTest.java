package testCases;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

import java.io.IOException;

public class LoginDataDrivenTest extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyValidAndInvalidLoginForMultipleData(String email, String password, String expectedValue) throws IOException, ParseException {

        homePage = new HomePage(getDriver());
        homePage.clickMyAccountDropDownText().clickLoginDropDownLink();
        loginPage = new LoginPage(getDriver());
        loginPage.enterEmailId(email).enterPassword(password).clickLoginButton();
        myAccountPage = new MyAccountPage(getDriver());
        boolean myAccountTextFlag = myAccountPage.isMyAccountTextDisplayed();
        if (expectedValue.equalsIgnoreCase("Valid")) {
            if (myAccountTextFlag == true) {
                myAccountPage.clickLogoutDropDownLink();
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }

        if (expectedValue.equalsIgnoreCase("Invalid")) {
            if (myAccountTextFlag == true) {
                myAccountPage.clickLogoutDropDownLink();
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        }
    }

}
