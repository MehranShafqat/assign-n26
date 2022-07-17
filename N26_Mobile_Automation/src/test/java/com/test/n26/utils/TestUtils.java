package com.test.n26.utils;

import com.test.n26.base.BaseTest;
import com.pages.n26.pages.AppLanding;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;

import static com.test.n26.listeners.TestListener.info;

public class TestUtils extends BaseTest {

    public static String APP_PACKAGE = "";
    public static String APP_ACTIVITY = "";
    public static String PLATFORM_NAME = "";
    public static String DEVICE_NAME = "";
    public static String CONNECTION_URL = "";
    public static String PLATFORM_VERSION = "";
    public static String AUTOMATION_TYPE = "";

    ConfigurationFile configurationFile;

    public void closeStartingDialogs(AppLanding onBoardingPage) {

        onBoardingPage.clickGetStartedBtn();
        info("Get Started button clicked.");

        onBoardingPage.clickGetStartedBtn();
        info("Amazing button clicked.");

        onBoardingPage.clickGetStartedBtn();
        info("I'M Ready button clicked.");

        onBoardingPage.closeSubscriptionDialog();
        info("Close Subscription dialog button clicked.");
    }

    public JSONObject readJSONFileData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/test_data.json"));
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
    }

    public DesiredCapabilities getDesiredCapabilities() throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();

        //Read configuration file
        configurationFile = new ConfigurationFile();
        configurationFile.readConfigData();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_TYPE);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);
        cap.setCapability("autoAcceptAlerts", true);

        return cap;
    }
}