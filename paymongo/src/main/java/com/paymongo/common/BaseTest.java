package com.paymongo.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.Configuration;
import com.utils.Launch_Configuration;

public class BaseTest {

    protected WebDriver driver;
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeClass
    public void setupExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void setupLaunch() {
        switch (Launch_Configuration.BROWSER) {
            case "chrome":
                System.out.println("Chrome Browser is being launched");
                System.setProperty(Configuration.CHROME, Configuration.ROOTHPATH + "/driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.out.println("Microsoft Edge is being launched");
                System.setProperty(Configuration.EDGE, Configuration.ROOTHPATH + "/driver/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.out.println("Firefox is being launched");
                System.setProperty(Configuration.FIREFOX, Configuration.ROOTHPATH + "/driver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.get(Launch_Configuration.URL());
        driver.manage().timeouts().implicitlyWait(Configuration.DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void getExtentResult(ITestResult result) throws Exception {
        String screenshotPath = getScreenShot(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Entry Failed = " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            System.out.println("Method Failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Entry Skipped: " + result.getName());
            System.out.println("Method Skipped: " + result.getName());
        } else {
            test.pass("Entry Passed: " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            System.out.println("Method Passed: " + result.getName());
        }
        extent.flush();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    public String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
