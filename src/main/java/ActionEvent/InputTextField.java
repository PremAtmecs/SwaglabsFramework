package ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class InputTextField {
    WebDriver driver;
    public InputTextField(WebDriver driver){
        this.driver = driver;
    }
    public void enterText(LocatorType locatorType, String locatorValue, String text){
        try {
            switch (locatorType){
                case XPATH:
                    driver.findElement(By.xpath(locatorValue)).sendKeys(text);
                    break;

                case NAME:
                    driver.findElement(By.name(locatorValue)).sendKeys(text);
                    break;

                case TAG:
                    driver.findElement(By.tagName(locatorValue)).sendKeys(text);
                    break;

                case ID:
                    driver.findElement(By.id(locatorValue)).sendKeys(text);
                    break;

                case CSS:
                    driver.findElement(By.cssSelector(locatorValue)).sendKeys(text);
                    break;

                case CLASS:
                    driver.findElement(By.className(locatorValue)).sendKeys(text);
                    break;
            }

        }
        catch (Exception exception){
            System.out.println("Exception occured \n" + exception.getMessage());
        }
    }
}
