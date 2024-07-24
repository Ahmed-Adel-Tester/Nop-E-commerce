package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class InvalidPassword extends BaseTests {
    ReadDataFromJson readDataFromJson ;
    @Test
    public void InvalidPassword() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        LoginPage loginPage = homePage.ClickOnLoginButton();
        loginPage.InsertEmail(readDataFromJson.readJsonFile().Login.InValidCredintails.InvalidPassword.Email);
        loginPage.InsertPassword(readDataFromJson.readJsonFile().Login.InValidCredintails.InvalidPassword.password);
        loginPage.ClickOnLoginButton();
        String actualresult = loginPage.GetValidationInvalidPassword();
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        assertTrue(actualresult.contains(expectedResult));
    }
}
