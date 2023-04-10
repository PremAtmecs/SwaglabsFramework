package TestScripts;

import Base.WebTestBase;
import PageObject.LaunchApplicationPage;
import org.testng.annotations.Test;

public class ECommerce extends WebTestBase {
    @Test(priority = 1)
    public void openBrowser(){
        LaunchApplicationPage openurl = new LaunchApplicationPage(driver);
        openurl.openECommerceBrowser();
    }
}
