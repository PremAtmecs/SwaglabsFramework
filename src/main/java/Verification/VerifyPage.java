package Verification;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class VerifyPage {
    public void verifyString(String actualText, String expectedText, String verificationStepMessage, ExtentTest test){
        test.log(LogStatus.INFO,verificationStepMessage);
        try{
            Assert.assertEquals(actualText, expectedText);
            test.log(LogStatus.PASS, "Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
        }
        catch (AssertionError assertionError){
            test.log(LogStatus.FAIL, "Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
        }

    }
}
