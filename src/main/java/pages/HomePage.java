package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodsHandles;

public class HomePage extends MethodsHandles{

    public HomePage (WebDriver driver){
        super(driver);
    }
private By RegisterButton =By.cssSelector(".ico-register");
    private By LoginButton = By.cssSelector(".ico-login");
public RegisterPage ClickONRegisterButton(){
    Click(RegisterButton);
    return new RegisterPage (driver);
}
public LoginPage ClickOnLoginButton(){
    Click(LoginButton);
    return new LoginPage(driver);
}
}