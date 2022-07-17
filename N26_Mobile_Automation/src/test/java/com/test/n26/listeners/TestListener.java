package com.test.n26.listeners;

import com.pages.n26.utills.ExtentReportManager;
import com.pages.n26.utills.ExtentReporter;
import com.test.n26.base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class TestListener extends BaseTest implements ITestListener {

    private static final Logger Log = LogManager.getLogger(TestListener.class.getName());

    public void onTestFailure(ITestResult result) {

        Log.error(result.getName() + " has failed.\n\n");

        try {
            ExtentReportManager.getTest().fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenShotOnFailure(result.getName())).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }
    }

    public static void info(String message) {
        Log.info(message);
        try {
            ExtentReportManager.getTest().log(Status.INFO, message);
        } catch (Exception ignored) {

        }
    }

    public static void takeScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String base64Encoded = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
        LocalDateTime now = LocalDateTime.now();
        String userDir = System.getProperty("user.dir");
        String filePath = "";
        if (System.getProperty("os.name").startsWith("Windows")) {
            filePath = userDir + "\\screenshots\\" + now.toString().replace(":", "-") + ".png";
        } else {
            filePath = userDir + "/screenshots/" + now.toString().replace(":", "-") + ".png";
        }
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExtentReportManager.getTest().log(Status.INFO, "Take screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Encoded).build());
    }

    public static void warn(String message) {
        Log.warn(message);
        ExtentReportManager.getTest().log(Status.WARNING, message);
    }

    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite Started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite Ended ***"));
        ExtentReportManager.endTest();
        ExtentReporter.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        Log.info(result.getName() + " is running.");
        ExtentReportManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " has passed.\n\n");
        ExtentReportManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestSkipped(ITestResult result) {
        Log.info(result.getName() + " has skipped.");
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    private static String captureScreenShotOnFailure(String methodName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String base64Encoded = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
        LocalDateTime now = LocalDateTime.now();
        String userDir = System.getProperty("user.dir");

        String filePath = "";
        if (System.getProperty("os.name").startsWith("Windows")) {
            filePath = userDir + "\\screenshots\\" + now.toString().replace(":", "-") + "_" + methodName + ".png";
        } else {
            filePath = userDir + "/screenshots/" + now.toString().replace(":", "-") + "_" + methodName + ".png";
        }

        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Encoded;
    }
}