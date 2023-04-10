package ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Enum.LocatorType;

public class WaitElement {
    WebDriver driver;

    public WaitElement(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is used to implement the explicit wait to wait for element in the
     * given timeout.
     */
    public void waitForElement(LocatorType locatorType, String locatorValue, int timeout) {
        WebDriverWait wait;
        try {
            switch (locatorType) {
                case XPATH:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                    break;
                case ID:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                    break;
                case NAME:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                    break;
                case CLASS:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                    break;
                case TAG:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
                    break;
                case CSS:
                    wait = new WebDriverWait(driver, 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
    }

}
