package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class ExtentReportsManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    public void startExtentReport(String path) {
        sparkReporter = new ExtentSparkReporter(Configuration.ROOTHPATH + path);
        System.out.println("Creating: " + path);

        // Initialize ExtentReports and attach the Spark Reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("PayMongo Automation Report");
        sparkReporter.config().setReportName("PayMongo Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("mm//dd//yyyy hh:mm:ss a");

        extent.createTest("Test Name"); // Replace "Test Name" with your actual test name
    }

   public void getExtentResult(WebDriver driver, ITestResult result) throws Exception {
        String screenshotPath = getScreenShot(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test = extent.createTest("Entry Failed: " + result.getName());
            test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            System.out.println("Method Failed: " + result.getName());
        } else if(result.getStatus() == ITestResult.SKIP) {
            test = extent.createTest("Entry Skipped: " + result.getName());
            test.skip("Test skipped");
            System.out.println("Method Skipped: " + result.getName());
        } else {
            test = extent.createTest("Entry Passed: " + result.getName());
            test.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            System.out.println("Method Passed: " + result.getName()); 
        }
        extent.flush();
    }

    public void logStep(String details) {
        test = extent.createTest(details);
        System.out.println("\n=============================================\n" + details + 
                           "\n==========================================\n");
    }

    public void pass(String details) {
        if (test != null) {
            test.pass(details);
        }
    }

    public void fail(String details) {
        if (test != null) {
            test.fail(details);
        }
    }

    public void info(String details) {
        if (test != null) {
            test.info(details);
        }
    }

    public static void endExtentReport () {
        if (extent != null) {
            extent.flush();
            System.out.println("ExtentReports is closed");
        }
    }

    public String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String destination = Configuration.ROOTHPATH + "/screenshot/" + screenshotName + ".jpg";
            File finalDest = new File(destination);
            FileUtils.copyFile(source, finalDest);
            return destination;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
