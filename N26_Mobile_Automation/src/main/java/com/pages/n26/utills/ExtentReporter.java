package com.pages.n26.utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentReporter {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        String fileName = "";
        if (System.getProperty("os.name").startsWith("Windows")) {
            fileName = getReportPath(System.getProperty("user.dir") + "\\extent_reports");
        } else {
            fileName = getReportPath(System.getProperty("user.dir") + "/extent_reports");
        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setDocumentTitle("N26-Automaton-Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("N26-Automaton-Report");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        String filePath = "";

        if (System.getProperty("os.name").startsWith("Windows")) {
            filePath = System.getProperty("user.dir") + "\\extent_reports\\Mobile-Automaton-Report.html";
        } else {
            filePath = System.getProperty("user.dir") + "/extent_reports/Mobile-Automaton-Report.html";
        }

        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
                return filePath;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return filePath;
    }
}