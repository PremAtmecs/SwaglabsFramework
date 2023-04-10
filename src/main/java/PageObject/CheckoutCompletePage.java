package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.VerifyMessage;
import PageObjectKeys.CheckoutCompletePageKey;
import Utils.PropertyParser;
import Verification.VerifyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser checkoutCompleteLocators;
    VerifyPage verifyPage;
    public CheckoutCompletePage(WebDriver driver){
        this.driver=driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        checkoutCompleteLocators = new PropertyParser(FilePathConstant.CHECKOUTCOMPLETE_LOCATOR_FILE_PATH);
        verifyPage = new VerifyPage();
    }

    public void validateTitle(){
        String completeTitleLocator = checkoutCompleteLocators.getPropertyValue(CheckoutCompletePageKey.CHECKOUT_COMPLETE_LOCATOR);
        String expectedText = driver.findElement(By.xpath(completeTitleLocator)).getText();
        verifyPage.verifyString("Checkout: Complete!",expectedText, VerifyMessage.VERIFY_CHECKOUTCOMPLETE_PAGE,test);
    }
}
