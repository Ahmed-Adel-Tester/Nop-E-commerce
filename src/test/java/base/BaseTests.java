package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTest;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class BaseTests {
    ReadDataFromJson readDataFromJson;
    protected HomePage homePage;
   private WebDriver driver;
   UtilsTest utilsTest;
   @Parameters ("browser")
   public void SetUpBrowser (String browser){
       if (browser.equalsIgnoreCase("chrome")){
           driver = new ChromeDriver();
       } else if (browser.equalsIgnoreCase("headlesschrome")) {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless");
           driver = new ChromeDriver(options);
       } else if (browser.equalsIgnoreCase("edge")) {
           driver = new EdgeDriver();
       } else if (browser.equalsIgnoreCase("headlessedge")) {
           EdgeOptions options = new EdgeOptions();
           options.addArguments("--headless");
           driver = new EdgeDriver(options);
       }
   }

    @BeforeClass
    @Parameters ("browser")
    public void SetUp(String browser) throws FileNotFoundException {
       SetUpBrowser(browser);
       driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
public void goHome(Method method) throws Exception {
        readDataFromJson = new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().Url);
        ScreenRecorderUtil.startRecord(method.getName());
    }
@AfterMethod
public void SetStatus(Method method , ITestResult result) throws Exception {
    utilsTest = new UtilsTest(driver);
ScreenRecorderUtil.stopRecord();
utilsTest.setTestcaseStatus(method, result);
utilsTest.TakeScreenShot(method.getName());

}
@AfterClass
public void TearDown(){
driver.quit();
}
@BeforeSuite
    public void StartSuite(){
utilsTest = new UtilsTest(driver);
utilsTest.CreateReport();
}
@AfterSuite
public void EndReport(){
utilsTest = new UtilsTest(driver);
utilsTest.flushReport();
}
}