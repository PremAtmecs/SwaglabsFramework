package ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.LocatorType;

public class Click {
    WebDriver driver;
    public Click(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(LocatorType locatorType, String locatorValue){
        try {
            switch (locatorType){
                case XPATH:
                    driver.findElement(By.xpath(locatorValue)).click();
                    break;

                case ID:
                    driver.findElement(By.id(locatorValue)).click();
                    break;
                    
                case CSS:
                    driver.findElement(By.cssSelector(locatorValue)).click();
                    break;
                    
                case TAG:
                    driver.findElement(By.tagName(locatorValue)).click();
                    break;

                case CLASS:
                    driver.findElement(By.className(locatorValue)).click();
                    break;

                case NAME:
                    driver.findElement(By.name(locatorValue)).click();
                    break;
            }

        }
        catch (Exception exception){
            System.out.println("Exception occured \n" + exception.getMessage());
        }
    }
}
