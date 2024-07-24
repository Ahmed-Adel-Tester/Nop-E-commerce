package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class InvalidUsername extends BaseTests {
    ReadDataFromJson readDataFromJson;
    @Test
    public void InvalidEmail() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        LoginPage loginPage = homePage.ClickOnLoginButton();
        loginPage.InsertEmail(readDataFromJson.readJsonFile().Login.InValidCredintails.InvalidEmail.Email);
        loginPage.InsertPassword(readDataFromJson.readJsonFile().Login.InValidCredintails.InvalidEmail.password);
        loginPage.ClickOnLoginButton();
        String actualresult = loginPage.GetValidationInvalidUsername();
        String expectedresult = "Please enter a valid email address.";
    }




}
