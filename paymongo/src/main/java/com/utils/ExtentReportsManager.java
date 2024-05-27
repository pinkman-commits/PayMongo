package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.paymongo.common.BasePage;

public class ExtentReportsManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;

    public void startExtentReport(String path) {
        htmlReporter = new ExtentHtmlReporter(Configuration.ROOTHPATH + path);
        System.out.println("Creating: " + path);

        //Initialize ExtentReports and attach the Html Reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("PayMongo Automation Report");
        htmlReporter.config().setReportName("PayMongo Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("mm//dd//yyyy hh:mm:ss a");

        htmlReporter.start();
        
        // Initialize the test instance
        test = extent.createTest("Test Name"); // Replace "Test Name" with your actual test name
    }

    public void getExtentResult(WebDriver driver, ITestResult result) throws Exception {
        
        
        String screenshotpath = getScreenShot(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Entry Failed = " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
            System.out.println("Method Failed: " + result.getName());
        } else if(result.getStatus() == ITestResult.SKIP) {
            test.skip("Entry Skipped: " + result.getName());
            System.out.println("Method Skipped: " + result.getName());
        } else {
            test.pass("Entry Passed: " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
            System.out.println("Method Passed: " + result.getName()); 
        }
        htmlReporter.stop();
    }

    public void logstep(String details) {
        test = extent.createTest(details);
        System.out.println("\n=============================================\n" + details + 
                           "\n==========================================\n");
        test.log(Status.INFO, MarkupHelper.createLabel(details, ExtentColor.BROWN));
    }

    public void pass( String details) {
        if (test != null) {
            test.log(Status.PASS, details);
        }
    }

    public void fail(String details) {
        if (test != null) {
            test.log(Status.FAIL, MarkupHelper.createLabel(details, ExtentColor.RED));
        }
    }

    public void info(String details) {
        if (test != null) {
            test.log(Status.INFO, MarkupHelper.createLabel(details, ExtentColor.AMBER));
        }
    }

    public static void endExtentReport () {
        if (extent != null) {
            extent.flush();
            System.out.println("ExtentReports isclosed");
        }
    }

    public String getScreenShot(WebDriver driver, String screenshotname) throws IOException {
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String destination = Configuration.ROOTHPATH + "/screenshot/" + screenshotname + ".jpg";
            File finalDest = new File(destination);
            FileUtils.copyFile(source, finalDest);
            return destination;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
