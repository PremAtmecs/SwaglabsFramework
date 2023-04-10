package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import Message.VerifyMessage;
import PageObjectKeys.YourInformationPageKey;
import Utils.PropertyParser;
import Verification.VerifyPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class YourInformationPage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser yourInformationLocators;
    PropertyParser yourInformationTestData;
    VerifyPage verifyPage;
    public YourInformationPage(WebDriver driver){
        this.driver=driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        yourInformationLocators = new PropertyParser(FilePathConstant.YOURINFORMATION_LOCATOR_FILE_PATH);
        yourInformationTestData = new PropertyParser(FilePathConstant.YOURINFORMATION_TESTDATA_FILE_PATH);
        verifyPage = new VerifyPage();
    }

    public void validateTitle(){
        test.log(LogStatus.INFO, InfoMessage.YOURINFORMATION_TITLE);
        String yourInformationTitleLocator = yourInformationLocators.getPropertyValue(YourInformationPageKey.YOUR_INFORMATION_LOCATOR);
        String expectedText = driver.findElement(By.xpath(yourInformationTitleLocator)).getText();
        verifyPage.verifyString("Checkout: Your Information",expectedText, VerifyMessage.VERIFY_YOURINFORMATION_PAGE, test);
    }

    public void enterFirstName(){
        test.log(LogStatus.INFO, InfoMessage.ENTER_FIRSTNAME);
        String firstnameLocator = yourInformationLocators.getPropertyValue(YourInformationPageKey.FIRST_NAME_LOCATOR);
        String firstnameData = yourInformationTestData.getPropertyValue(YourInformationPageKey.FIRST_NAME_DATA);
        inputTextField.enterText(LocatorType.XPATH, firstnameLocator,firstnameData);
    }

    public void enterLastName(){
        test.log(LogStatus.INFO, InfoMessage.ENTER_LASTNAME);
        String lastnameLocator = yourInformationLocators.getPropertyValue(YourInformationPageKey.LAST_NAME_LOCATOR);
        String lastnameData = yourInformationTestData.getPropertyValue(YourInformationPageKey.LAST_NAME_DATA);
        inputTextField.enterText(LocatorType.ID,lastnameLocator,lastnameData);
    }

    public void enterZIPcode(){
        test.log(LogStatus.INFO, InfoMessage.ENTER_ZIPCODE);
        String ZIPcodeLocator = yourInformationLocators.getPropertyValue(YourInformationPageKey.ZIP_CODE_LOCATOR);
        String ZIPcodeData = yourInformationTestData.getPropertyValue(YourInformationPageKey.ZIP_CODE_DATA);
        inputTextField.enterText(LocatorType.ID, ZIPcodeLocator, ZIPcodeData);
    }

    public void clickContinue(){
        test.log(LogStatus.INFO,InfoMessage.CLICKCONTINUE);
        String continueButtonLocator = yourInformationLocators.getPropertyValue(YourInformationPageKey.CONTINUE_BUTTON_LOCATOR);
        click.clickElement(LocatorType.ID, continueButtonLocator);
    }
}
