package com.test.n26.utils;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.*;

public class ConfigurationFile {

    static InputStream inputStream;
    static PropertiesConfiguration propValues;

    public PropertiesConfiguration getConfigurationData() throws IOException {
        PropertiesConfiguration propConfig = null;
        try {
            propConfig = new PropertiesConfiguration();
            String userDir = System.getProperty("user.dir");
            String filePath = "";
            if (System.getProperty("os.name").startsWith("Windows")) {
                filePath = userDir + "\\src\\test\\resources\\config.properties";
            } else {
                filePath = userDir + "/src/test/resources/config.properties";
            }

            inputStream = new FileInputStream(filePath);

            if (inputStream != null) {
                propConfig.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + filePath + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propConfig;
    }

    public void readConfigData() throws IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = "";
        if (System.getProperty("os.name").startsWith("Windows")) {
            filePath = userDir + "\\src\\test\\resources\\config.properties";
        } else {
            filePath = userDir + "/src/test/resources/config.properties";
        }
        File tmpDir = new File(filePath);
        if (tmpDir.exists()) {
            System.out.println("Configuration File exists...");
            propValues = getConfigurationData();

            TestUtils.APP_PACKAGE = propValues.getProperty("appPackage").toString();
            TestUtils.APP_ACTIVITY = propValues.getProperty("appActivity").toString();
            TestUtils.PLATFORM_NAME = propValues.getProperty("platform").toString();
            TestUtils.PLATFORM_VERSION = propValues.getProperty("version").toString();
            TestUtils.DEVICE_NAME = propValues.getProperty("deviceName").toString();
            TestUtils.CONNECTION_URL = propValues.getProperty("connectionUrl").toString();
            TestUtils.AUTOMATION_TYPE = propValues.getProperty("automationType").toString();

        }
    }
}