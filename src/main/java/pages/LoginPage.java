package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodsHandles;

public class LoginPage extends MethodsHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By EmailFiled = By.xpath("//input[@class='email']");
    private By PasswordFiled = By.xpath("//input[@class='password']");
    private By LoginButton = By.xpath("//button[@class='button-1 login-button']");
    private By ValidationSuccessfulLogin = By.xpath("//a[@class='ico-logout']");
    private By ValidationInvalidUsername = By.xpath("//span[@class='field-validation-error']");
    private By ValidationInvalidPassword = By.xpath("//div[@class=\"message-error validation-summary-errors\"]");
    public void InsertEmail(String Email){
SendKeys(EmailFiled , Email);
    }
    public void InsertPassword(String password){
SendKeys(PasswordFiled ,password );
    }
    public void ClickOnLoginButton(){
Click(LoginButton);
    }
    public String GetValidationSuccessfulLogin(){
return GetText(ValidationSuccessfulLogin);
    }
public String GetValidationInvalidUsername(){
        return  GetText(ValidationInvalidUsername);
}
public String GetValidationInvalidPassword(){
        return GetText(ValidationInvalidPassword);
}
}
