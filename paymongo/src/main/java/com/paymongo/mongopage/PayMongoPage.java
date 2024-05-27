package com.paymongo.mongopage;

import com.paymongo.common.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayMongoPage extends BasePage {

    public PayMongoPage(WebDriver driver) {
        super(driver);
    }

    //Login Methods
    public void validateLoginElements () throws InterruptedException {
        verifyElementIsPresent(PayMongoPagePath.LOGIN_TITLE);
        verifyElementIsPresent(PayMongoPagePath.EMAIL_ADDRESS_TITLE);
        verifyElementIsPresent(PayMongoPagePath.EMAIL_ADDRESS_FIELD);
        verifyElementIsPresent(PayMongoPagePath.PASSWORD_TITLE);
        verifyElementIsPresent(PayMongoPagePath.PASSWORD_FIELD);
        verifyElementIsPresent(PayMongoPagePath.FORGOT_YOUR_PASSWORD_LINK);
        verifyElementIsPresent(PayMongoPagePath.LOGIN_BUTTON);
        verifyElementIsPresent(PayMongoPagePath.SIGNUP_LINK);
        delay(1);
    }
 
    public void LoginPayMongoAccount (String email, String password) throws InterruptedException {
        verifyElementIsPresent(PayMongoPagePath.EMAIL_ADDRESS_TITLE);
        verifyElementIsPresent(PayMongoPagePath.EMAIL_ADDRESS_FIELD);
        click(PayMongoPagePath.EMAIL_ADDRESS_FIELD);
        delay(1);
        enterText(PayMongoPagePath.EMAIL_ADDRESS_FIELD, email);
        verifyElementIsPresent(PayMongoPagePath.PASSWORD_TITLE);
        verifyElementIsPresent(PayMongoPagePath.PASSWORD_FIELD);
        click(PayMongoPagePath.PASSWORD_FIELD);
        enterText(PayMongoPagePath.PASSWORD_FIELD, password);
        delay(1);

        clickAnywhere();
    }

    public void validatePasswordIsMasked() {
        try {
            WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
            String typeAttribute = passwordElement.getAttribute("type");
    
            if ("password".equals(typeAttribute)) {
                System.out.println("Passed: The Password Field is masked.");
            } else if ("text".equals(typeAttribute)) {
                System.out.println("Failed: The Password Field is not masked.");
            } else {
                System.out.println("Failed: Unable to determine the masking state of the Password Field.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Failed to locate the password field: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to check if the password field is masked: " + e.getMessage());
        }
    }

    public void validatePasswordIsNotMasked () throws InterruptedException {
        delay(1);
        try {
            WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
            String fieldValue = passwordElement.getAttribute("value");
            //Checker if the password is masked
            boolean isMasked = fieldValue.contains("•");

            if(!isMasked) {
                System.out.println("Passed: The Password Field is unmasked.");
                System.out.println(fieldValue);
            } else {
                System.out.println("Failed: The Password Field is masked");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Failed to locate or check if the password field is masked: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed to locate or check if the password field is masked: " + e.getMessage());
        }
    }
         
    public void clickPasswordMaskIcon() throws InterruptedException{
        delay(1);
        click(PayMongoPagePath.PASSWORD_EYE_ICON);
    }
    
    public void clickLogInButton() throws InterruptedException {
        delay(1);
        click(PayMongoPagePath.LOGIN_BUTTON);
    }
    

    //Dashboard (Activate) Methods
    public void captureWelcomePageData() throws InterruptedException {
        // Find all elements with the class '-shade900'
        List<WebElement> shadeElements = driver.findElements(By.className("-shade900"));

        // Iterate over the shade elements
        for (WebElement shadeElement : shadeElements) {
            // Get the text content of the shade element
            String textContent = shadeElement.getText();
            System.out.println(textContent + "\r\n");
        }
    }

    public void validateWelcomePage() throws InterruptedException {
        verifyElementIsPresent(PayMongoPagePath.KYC_FORM);
        delay(1);
    }

    public void validateActivationSteps() throws InterruptedException {
        delay(1);
        verifyElementIsPresent(PayMongoPagePath.KYC_STEP_1);
        verifyElementIsPresent(PayMongoPagePath.KYC_STEP_2);
        verifyElementIsPresent(PayMongoPagePath.KYC_STEP_3);
        verifyElementIsPresent(PayMongoPagePath.KYC_STEP_4);
        verifyElementIsPresent(PayMongoPagePath.KYC_STEP_5);
        
    }

    public void validateSideBarShorcuts() throws InterruptedException {
        delay(1);
        verifyElementIsPresent(PayMongoPagePath.ACTIVATE_ACCOUNT);
        verifyElementIsPresent(PayMongoPagePath.HOME);
        verifyElementIsPresent(PayMongoPagePath.LINKS);
        verifyElementIsPresent(PayMongoPagePath.PAGES);
        verifyElementIsPresent(PayMongoPagePath.PAYMENTS);
        verifyElementIsPresent(PayMongoPagePath.PAYOUTS);
        verifyElementIsPresent(PayMongoPagePath.DEVELOPERS);
        verifyElementIsPresent(PayMongoPagePath.SECURITY_LOGS);
        verifyElementIsPresent(PayMongoPagePath.SETTINGS);
        verifyElementIsPresent(PayMongoPagePath.LIVE_DATA);
    }
    

}
