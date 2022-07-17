package com.test.n26.base;

import com.test.n26.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;

public class BaseTest {
    private static AppiumDriver driver;
    URL url;
    TestUtils utils;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        utils = new TestUtils();
        DesiredCapabilities capabilities = utils.getDesiredCapabilities();
        url = new URL(TestUtils.CONNECTION_URL);
        driver = new AndroidDriver<>(url, capabilities);
    }

    @AfterSuite
    public void afterSuite() {
        if (null != driver) {
            getDriver().resetApp();
            driver.quit();
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}