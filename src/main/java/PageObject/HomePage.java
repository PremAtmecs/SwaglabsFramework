package PageObject;

import ActionEvent.Click;
import ActionEvent.InputTextField;
import Base.WebTestBase;
import Constant.FilePathConstant;
import Message.InfoMessage;
import PageObjectKeys.HomePageKey;
import Utils.PropertyParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends WebTestBase {
    WebDriver driver;
    public Click click;
    public InputTextField inputTextField;
    PropertyParser homePageLocators;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        click = new Click(driver);
        inputTextField = new InputTextField(driver);
        homePageLocators = new PropertyParser(FilePathConstant.HOMEPAGE_LOCATOR_FILE_PATH);
    }
    public void clickAddToCart() {
        test.log(LogStatus.INFO, InfoMessage.CLICKADDTOCART);
        String addToCartLocator = homePageLocators.getPropertyValue(HomePageKey.ADDTOCARTKEY);
        click.clickElement(LocatorType.XPATH, addToCartLocator);
    }

    public void clickCartLink(){
        test.log(LogStatus.INFO, InfoMessage.CLICKCARTLINK);
        String cartLinkLocator = homePageLocators.getPropertyValue(HomePageKey.CARTLINKKEY);
        click.clickElement(LocatorType.CSS, cartLinkLocator);
    }
}
