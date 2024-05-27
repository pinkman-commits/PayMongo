package com.paymongo.common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.Configuration;
import com.utils.ExtentReportsManager;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    protected ExtentReportsManager extentManager;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Configuration.DEFAULT_WAIT));
        this.extentManager = new ExtentReportsManager();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }
    public void verifyElementIsPresent(String[] locator) {
        try {
            driver.findElement(By.xpath(locator[0]));
            System.out.println("Passed: " + locator[1] + " is present");
            extentManager.pass(locator[1] + " is present"); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Failed: " + locator[1] + " is not present");
            extentManager.fail(locator[1] + " is not present"); // Log fail status
        }
    }

    public void delay(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void click(String[] locator) {
        try {
            driver.findElement(By.xpath(locator[0])).click();
            System.out.println("Passed: " + locator[1] + " is clicked");
            extentManager.logstep("Clicked on " + locator[1]); // Log step description
            extentManager.pass(locator[1] + " is clicked"); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Failed to click: " + locator[1] + " - Element not found");
            extentManager.logstep("Failed to click on " + locator[1] + " - Element not found"); // Log step description
            extentManager.fail("Failed to click on " + locator[1] + " - Element not found"); // Log fail status
        } catch (Exception e) {
            System.out.println("Failed to click: " + locator[1] + " - " + e.getMessage());
            extentManager.logstep("Failed to click on " + locator[1] + " - " + e.getMessage()); // Log step description
            extentManager.fail("Failed to click on " + locator[1] + " - " + e.getMessage()); // Log fail status
        }
    }

    public void clickAnywhere() {
        try {
            // Find an element that represents white space (e.g., body or any empty div)
            WebElement whiteSpace = driver.findElement(By.tagName("body"));
            // Perform a click action on the white space element
            Actions actions = new Actions(driver);
            actions.moveToElement(whiteSpace).click().perform();
            System.out.println("Clicked on white space.");
            extentManager.pass("Clicked on white space"); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Failed to find white space element.");
            extentManager.fail("Failed to find white space element"); // Log fail status
        } catch (Exception e) {
            System.out.println("Failed to click on white space: " + e.getMessage());
            extentManager.fail("Failed to click on white space: " + e.getMessage()); // Log fail status
        }
    }


    public void enterText(String[] locator, String text) {
        try {
            WebElement element = driver.findElement(By.xpath(locator[0]));
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered text '" + text + "' into: " + locator[1]);
            extentManager.logstep("Entered text '" + text + "' into: " + locator[1]); // Log step description
            extentManager.pass("Entered text '" + text + "' into: " + locator[1]); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Failed to enter text into: " + locator[1] + " - Element not found");
            extentManager.fail("Failed to enter text into: " + locator[1] + " - Element not found"); // Log fail status
        } catch (Exception e) {
            System.out.println("Failed to enter text into: " + locator[1] + " - " + e.getMessage());
            extentManager.fail("Failed to enter text into: " + locator[1] + " - " + e.getMessage()); // Log fail status
        }
    }

    public void waitLoading() {
        try {
            // Wait until the loading spinner is present
            WebElement loadingSpinner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-busy='true' and @aria-label='loading app']")));
    
            // Wait until the loading spinner disappears
            wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
            
            System.out.println("Loading spinner disappeared.");
            extentManager.pass("Loading spinner disappeared"); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Loading spinner not found.");
            extentManager.fail("Loading spinner not found"); // Log fail status
        } catch (Exception e) {
            System.out.println("Error occurred while waiting for loading spinner to disappear: " + e.getMessage());
            extentManager.pass("Error occurred while waiting for loading spinner to disappear: " + e.getMessage()); // Log fail status
        }
    }

    public void waitForLoadingSpinner() {
        try {
            // Wait until the loading spinner is present
            WebElement loadingSpinner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='authenticated-frame__content-container']//*[contains(@class,'fa-spinner')]")));
    
            // Log loading spinner visibility
            System.out.println("Loading spinner is visible.");
            extentManager.logstep("Loading spinner is visible"); // Log info status
    
            // Wait until the loading spinner disappears
            wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
    
            // Log loading spinner disappearance
            System.out.println("Loading spinner disappeared.");
            extentManager.pass("Loading spinner disappeared"); // Log pass status
        } catch (NoSuchElementException e) {
            System.out.println("Loading spinner not found.");
            extentManager.fail("Loading spinner not found"); // Log fail status
        } catch (Exception e) {
            System.out.println("Error occurred while waiting for loading spinner: " + e.getMessage());
            extentManager.fail("Error occurred while waiting for loading spinner: " + e.getMessage()); // Log fail status
        }
    }



}
