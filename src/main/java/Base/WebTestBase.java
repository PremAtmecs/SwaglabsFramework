package Base;

import Constant.ConfigPropertiesKey;
import Constant.FilePathConstant;
import Utils.PropertyParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class WebTestBase {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    PropertyParser configPropertyParser = new PropertyParser(FilePathConstant.CONFIG_FILE_PATH);
    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstant.SWAG_EXTENT_REPORT_PATH);
    }
    @BeforeMethod
    public void beforeMethod(Method method){
        test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @Parameters("browser")
    @BeforeClass
    public void launchApplication(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
           // driver.get(configPropertyParser.getPropertyValue(ConfigPropertiesKey.SWAGLAB_URL));

        }
        else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(configPropertyParser.getPropertyValue(ConfigPropertiesKey.SWAGLAB_URL));
        }
        else {
            System.out.println("Browser is not found");
        }
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        extent.close();
    }

}
