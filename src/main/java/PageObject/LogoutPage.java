package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import PageObjectKeys.LogoutPageKey;
import Utils.PropertyParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class LogoutPage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser logoutLocators;
    public LogoutPage(WebDriver driver){
        this.driver = driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        logoutLocators = new PropertyParser(FilePathConstant.LOGOUT_LOCATOR_FILE_PATH);
    }

    public void clickBurgerMenu(){
        test.log(LogStatus.INFO, InfoMessage.CLICKBURGERMENU);
        String burgerMenuLocator = logoutLocators.getPropertyValue(LogoutPageKey.BURGER_MENU_KEY);
        click.clickElement(LocatorType.ID,burgerMenuLocator);
    }
    public void clickLogout() throws InterruptedException {
        test.log(LogStatus.INFO, InfoMessage.CLICKLOGOUTOPTION);
        String logoutLocator = logoutLocators.getPropertyValue(LogoutPageKey.LOGOUT_BUTTON_KEY);
        Thread.sleep(3000);
        click.clickElement(LocatorType.ID, logoutLocator);
    }
}
