package login;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {
    ReadDataFromJson readDataFromJson;

    @Test
    public void SuccessfulLogin() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        LoginPage loginPage = homePage.ClickOnLoginButton();
        loginPage.InsertEmail(readDataFromJson.readJsonFile().Login.ValidCredintails.Email);
        loginPage.InsertPassword(readDataFromJson.readJsonFile().Login.ValidCredintails.password);
        loginPage.ClickOnLoginButton();
        String actualresult = loginPage.GetValidationSuccessfulLogin();
        String expectedresult = "Log out";
    assertTrue(actualresult.contains(expectedresult));
    }
}