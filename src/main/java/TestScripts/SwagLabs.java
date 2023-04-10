package TestScripts;

import Base.WebTestBase;
import PageObject.*;
import org.testng.annotations.Test;


public class SwagLabs extends WebTestBase {

    @Test(priority = 1)
    public void openBrowser(){
        LaunchApplicationPage openUrl = new LaunchApplicationPage(driver);
        openUrl.openSauceDemoBrowser();
    }

    @Test (priority = 2)
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Test (priority = 3)
    public void homePage()  {
        HomePage homePage = new HomePage(driver);
        homePage.clickAddToCart();
        homePage.clickCartLink();
    }
    @Test (priority = 4)
    public void yourcartPage() throws InterruptedException {
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.validateYourCartTitle();
        //yourCartPage.validateProductName();
        yourCartPage.clickCheckoutButton();
    }

    @Test(priority = 5)
    public void yourInformationPage(){
        YourInformationPage yourInformationPage = new YourInformationPage(driver);
        yourInformationPage.validateTitle();
        yourInformationPage.enterFirstName();
        yourInformationPage.enterLastName();
        yourInformationPage.enterZIPcode();
        yourInformationPage.clickContinue();
    }

    @Test (priority = 6)
    public void checkoutOVerviewPage(){
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.validateTitle();
        checkoutOverviewPage.clickFinishButton();
    }

    @Test (priority = 7)
    public void checkoutCompletePage(){
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.validateTitle();
    }

    @Test (priority = 8)
    public void logout() throws InterruptedException {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickBurgerMenu();
        logoutPage.clickLogout();
    }

}
