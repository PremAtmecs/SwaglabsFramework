package Constant;

import java.io.File;

public class FilePathConstant {
    public static final String USER_PATH_DIR = System.getProperty("user.dir");
    public static final String RESOURCE_PATH = USER_PATH_DIR + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    public static final String CONFIG_FILE_PATH = RESOURCE_PATH + File.separator + "TestData" + File.separator + "config.properties";
    public static final String SWAG_EXTENT_REPORT_PATH = USER_PATH_DIR + File.separator + "test-output" + File.separator + "SwagLab.html";
    public static final String LOG4J_PATH = RESOURCE_PATH + File.separator + "TestData" + File.separator + "log4j.properties";
    public static final String LOGIN_TESTDATA_FILE_PATH = RESOURCE_PATH + File.separator + "TestData" + File.separator + "loginData.properties";
    public static final String LOGIN_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "loginLocators.properties";
    public static final String LOGOUT_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "logoutLocators.properties";
    public static final String HOMEPAGE_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "homePageLocators.properties";
    public static final String YOURCARTPAGE_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "yourCartPageLocators.properties";
    public static final String YOURCART_TESTDATA_FILE_PATH = RESOURCE_PATH + File.separator + "TestData" + File.separator + "yourCartData.properties";
    public static final String YOURINFORMATION_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "yourInformationLocator.properties";
    public static final String YOURINFORMATION_TESTDATA_FILE_PATH = RESOURCE_PATH + File.separator + "TestData" + File.separator + "yourInformationData.properties";
    public static final String CHECKOUTOVERVIEW_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "checkoutOverviewLocator.properties";
    public static final String CHECKOUTCOMPLETE_LOCATOR_FILE_PATH = RESOURCE_PATH + File.separator + "Locators" + File.separator + "checkoutCompleteLocator.properties";
}
