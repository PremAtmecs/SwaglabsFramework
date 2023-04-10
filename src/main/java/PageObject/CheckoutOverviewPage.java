package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import Message.VerifyMessage;
import PageObjectKeys.CheckoutOverviewPageKey;
import Utils.PropertyParser;
import Verification.VerifyPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class CheckoutOverviewPage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser checkoutOverviewLocators;
    VerifyPage verifyPage;
    public CheckoutOverviewPage(WebDriver driver){
        this.driver=driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        checkoutOverviewLocators = new PropertyParser(FilePathConstant.CHECKOUTOVERVIEW_LOCATOR_FILE_PATH);
        verifyPage = new VerifyPage();
    }

    public void validateTitle(){
        String checkoutOverviewTitle = checkoutOverviewLocators.getPropertyValue(CheckoutOverviewPageKey.CHECKOUT_OVERVIEW_TITLE);
        String expectedText = driver.findElement(By.xpath(checkoutOverviewTitle)).getText();
        verifyPage.verifyString("Checkout: Overview",expectedText, VerifyMessage.VERIFY_CHECKOUTOVERVIEW_PAGE,test);
    }

    public void clickFinishButton(){
        test.log(LogStatus.INFO, InfoMessage.CLICK_FINISH_BUTTON);
        String clickFinishButtonLocator = checkoutOverviewLocators.getPropertyValue(CheckoutOverviewPageKey.FINISH_BUTTON);
        click.clickElement(LocatorType.XPATH,clickFinishButtonLocator);
    }
}
