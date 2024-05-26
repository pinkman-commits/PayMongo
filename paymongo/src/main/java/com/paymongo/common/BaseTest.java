package com.paymongo.common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.utils.Configuration;
import com.utils.Login_Configuration;

public class BaseTest {

    public static WebDriver driver;

    public void setupLaunch() {
        switch (Login_Configuration.BROWSER) {
            case "chrome":
                System.out.println("Chrome Browser is being launched");
                System.setProperty(Configuration.CHROME, Configuration.ROOTHPATH + "/driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.out.println("Microsoft Edge is being launched");
                System.setProperty(Configuration.EDGE, Configuration.ROOTHPATH + "/driver/msedgedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Firefox is being launched");
                System.setProperty(Configuration.FIREFOX, Configuration.ROOTHPATH + "/driver/geckodriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.get(Login_Configuration.URL());
        driver.manage().timeouts().implicitlyWait(Configuration.DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    
    public WebDriver getDriver() {
        return driver;
    }
}
