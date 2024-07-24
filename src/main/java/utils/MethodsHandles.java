package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MethodsHandles {
    protected WebDriver driver ;
    WebDriverWait wait ;
public MethodsHandles (WebDriver driver){
    this.driver=driver ;
}
private WebElement webElement(By locator){
return driver.findElement(locator);
}
protected void Waiting(By locator){
    wait = new WebDriverWait(driver , Duration.ofSeconds(10)) ;
    wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
            ExpectedConditions.elementToBeClickable(locator),
            ExpectedConditions.visibilityOfElementLocated(locator)));
}
protected void Click(By locator) {
    for (int i = 0; i < 10; i++)
        try {
            Waiting(locator);
            webElement(locator).click();
            break;
        } catch (StaleElementReferenceException e) {
    }
}
    protected void SendKeys(By locator , String text) {
        for (int i =0; i < 10; i++)
            try {
                Waiting(locator);
                webElement(locator).sendKeys(text);
                break;
            } catch (StaleElementReferenceException e){
        }
}
        protected String GetText (By locator){
            Waiting(locator);
            return webElement(locator).getText();
        }
    }