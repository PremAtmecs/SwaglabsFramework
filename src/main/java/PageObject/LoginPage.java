package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import PageObjectKeys.LoginPageKey;
import Utils.PropertyParser;
import Enum.LocatorType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class LoginPage extends WebTestBase{
    PropertyParser loginLocators;
    PropertyParser loginTestData;
    Click click;
    InputTextField inputTextField;
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginLocators = new PropertyParser(FilePathConstant.LOGIN_LOCATOR_FILE_PATH);
        loginTestData = new PropertyParser(FilePathConstant.LOGIN_TESTDATA_FILE_PATH);
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
    }

    public void enterUsername() {
        test.log(LogStatus.INFO,InfoMessage.ENTERUSERNAME);
        String usernameLocator = loginLocators.getPropertyValue(LoginPageKey.USER_NAME_KEY);
        String usernameData = loginTestData.getPropertyValue(LoginPageKey.USER_NAME_DATA);
        inputTextField.enterText(LocatorType.ID, usernameLocator, usernameData);
    }

    public void enterPassword() {
        test.log(LogStatus.INFO, InfoMessage.ENTERPASSWORD);
        String passwordLocator = loginLocators.getPropertyValue(LoginPageKey.PASSWORD_KEY);
        String passwordData = loginTestData.getPropertyValue(LoginPageKey.PASSWORD_DATA);
        inputTextField.enterText(LocatorType.ID, passwordLocator, passwordData);
    }

    public void clickLoginButton() {
        test.log(LogStatus.INFO, InfoMessage.CLICKLOGIN);
        String loginButtonLocator = loginLocators.getPropertyValue(LoginPageKey.LOGIN_BUTTON_KEY);
        click.clickElement(LocatorType.ID, loginButtonLocator);
    }
}
