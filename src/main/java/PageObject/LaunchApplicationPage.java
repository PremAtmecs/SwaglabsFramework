package PageObject;

import Base.WebTestBase;
import Constant.ConfigPropertiesKey;
import Constant.FilePathConstant;
import Message.InfoMessage;
import Utils.PropertyParser;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class LaunchApplicationPage extends WebTestBase {
    WebDriver driver;
    PropertyParser configPropertyParser = new PropertyParser(FilePathConstant.CONFIG_FILE_PATH);
    public LaunchApplicationPage(WebDriver driver){
       this.driver = driver;
    }
    public void openSauceDemoBrowser(){
        test.log(LogStatus.INFO, InfoMessage.OPENBROWSER);
        driver.get(configPropertyParser.getPropertyValue(ConfigPropertiesKey.SWAGLAB_URL));
    }
    public void openECommerceBrowser(){
        test.log(LogStatus.INFO, InfoMessage.OPENBROWSER);
        driver.get(configPropertyParser.getPropertyValue(ConfigPropertiesKey.ECOMMERCE_URL));
    }
}
