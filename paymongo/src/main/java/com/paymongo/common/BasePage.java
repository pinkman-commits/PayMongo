package com.paymongo.common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.Configuration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_WAIT));
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    public void verifyElementIsPresent(String[] locator) {
        try {
            driver.findElement(By.xpath(locator[0]));
            System.out.println("Passed: " + locator[1] + " is present");
        } catch (NoSuchElementException e) {
            System.out.println("Failed: " + locator[1] + " is not present");
        }
    }

    public void delay(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
}
