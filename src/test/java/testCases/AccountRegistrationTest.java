package testCases;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

import java.io.IOException;


public class AccountRegistrationTest extends BaseTest {


    @Test(groups = {"Sanity", "Regression"})
    public void verifyAccountRegistration() throws IOException, ParseException {
        HomePage homePage = new HomePage(getDriver());
        writeJsonData();
        homePage.clickMyAccountDropDownText().clickRegisterDropDownLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.enterFirstName(readJsonData().get("firstName").toString())
                .enterLastName(readJsonData().get("lastName").toString())
                .enterEmailId(readJsonData().get("emailId").toString())
                .enterTelephoneNumber(readJsonData().get("phoneNumber").toString())
                .enterPassword(readJsonData().get("password").toString())
                .enterConfirmPasswordText(readJsonData().get("password").toString())
                .clickSubscribeYesRadioButton().clickAgreeCheckbox().clickContinueButton();
        Assert.assertEquals(registrationPage.getAccountCreatedConfirmationTextValue()
                , "Your Account Has Been Created!", "Account creation failed");

    }


}
