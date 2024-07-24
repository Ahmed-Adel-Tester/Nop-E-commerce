package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodsHandles;

public class RegisterPage extends MethodsHandles {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By FirstNameFiled = By.xpath("//input[@name='FirstName']");
    private By SecondNameFiled = By.xpath("//input[@name='LastName']");
    private By EmailFiled = By.xpath("//input[@name='Email']");
    private By PasswordFiled = By.xpath("//input[@id='Password']");
    private By ConfirmPasswordFiled = By.xpath("//input[@name='ConfirmPassword']");
    private By RegisterButton = By.xpath("//button[@name='register-button']");
    private By ValidationMessage = By.xpath("//div[@class=\"result\"]");

    public void InsertFirstName(String FirstName){
        SendKeys(FirstNameFiled , FirstName);
    }
    public void InsertSecondName (String LastName){
        SendKeys(SecondNameFiled , LastName);
    }
    public void InsertEmail(String Email){
        SendKeys(EmailFiled , Email);
    }
    public void InsertPassword(String Password){
        SendKeys(PasswordFiled , Password);
    }
    public void  InsertConfirmPassword(String ConfirmPassword ){
        SendKeys( ConfirmPasswordFiled,ConfirmPassword);
    }
    public void ClickOnLoginButton(){
        Click(RegisterButton);
    }
    public String GetValidationMessage(){
    return GetText(ValidationMessage);
    }
}