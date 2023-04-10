package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import Message.VerifyMessage;
import PageObjectKeys.YourCartPageKey;
import Utils.PropertyParser;
import Verification.VerifyPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class YourCartPage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser yourcartLocators;
    PropertyParser yourcartTestData;
    VerifyPage verifyPage;
    public YourCartPage(WebDriver driver){
        this.driver=driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        yourcartLocators = new PropertyParser(FilePathConstant.YOURCARTPAGE_LOCATOR_FILE_PATH);
        yourcartTestData = new PropertyParser(FilePathConstant.YOURCART_TESTDATA_FILE_PATH);
        verifyPage=new VerifyPage();
    }
    public void validateYourCartTitle() {
        test.log(LogStatus.INFO, InfoMessage.YOURCART_TITLE);
        String yourcartTitleLocator = yourcartLocators.getPropertyValue(YourCartPageKey.YOUR_CART_TITLE);
        String actualText = driver.findElement(By.cssSelector(yourcartTitleLocator)).getText();
        System.out.println(actualText);
        String expectedText = yourcartTestData.getPropertyValue(YourCartPageKey.YOUR_CART_TEXT);
        verifyPage.verifyString(actualText, expectedText, VerifyMessage.VERIFY_YOURCART_PAGE, test);
    }
    public void clickCheckoutButton(){
        test.log(LogStatus.INFO, InfoMessage.CLICKCHECKOUTBUTTON);
        String checkoutButtonLocator = yourcartLocators.getPropertyValue(YourCartPageKey.CHECK_OUT_BUTTON);
        click.clickElement(LocatorType.XPATH, checkoutButtonLocator);
    }
    public void validateProductName() throws InterruptedException {
        test.log(LogStatus.INFO, InfoMessage.PRODUCT_DETAILS);
        Thread.sleep(3000);
        String productText = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='Sauce Labs Bolt T-Shirt']")).getText();
        System.out.println(productText);
        verifyPage.verifyString("Sauce Labs Bolt T-Shirt", productText, VerifyMessage.VERIFY_PRODUCT_NAME, test);
    }
}
