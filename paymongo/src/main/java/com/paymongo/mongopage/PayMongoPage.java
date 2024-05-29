package com.paymongo.mongopage;

import com.paymongo.common.BasePage;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    public void capturePageData() throws InterruptedException {
        // Find all elements with the class '-shade900'
        List<WebElement> shadeElements = driver.findElements(By.className("-shade900"));

        // Iterate over the shade elements
        for (WebElement shadeElement : shadeElements) {
            // Get the text content of the shade element
            String textContent = shadeElement.getText();
            System.out.println(textContent + "\r\n");
        }
    }

    public void validatePrimaryIDs() throws InterruptedException {
        List <WebElement> pidelements = driver.findElements(By.id("valid-ids-modal__primary-ids"));
        // Iterate over the shade elements
        for (WebElement pidelement : pidelements) {
            // Get the text content of the shade element
            String textContent = pidelement.getText().trim();
            System.out.println("List of Primary IDs Accepted:\r\n" + textContent + "\r\n");
        }
    }

    public void validateSecondaryIDs () throws InterruptedException {
        
        List <WebElement> pidelements = driver.findElements(By.xpath("valid-ids-modal__id-list"));
        // Iterate over the shade elements
        for (WebElement pidelement : pidelements) {
            // Get the text content of the shade element
            String textContent = pidelement.getText().trim();
            System.out.println("List of Secondary IDs Accepted:\r\n" + textContent + "\r\n");
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
    
    public void clickNextButton() throws InterruptedException {
        verifyElementIsPresent(PayMongoPagePath.KYC_FORM_NEXT_BUTTON);
        delay(1);
        click(PayMongoPagePath.KYC_FORM_NEXT_BUTTON);
        delay(1);
    }


    //VALID ID GUIDELINES
    public void captureIDValidationGuidelines() throws InterruptedException {
        // Find the container element for the guidelines
        WebElement guidelinesContainer = driver.findElement(By.className("guidelines-content"));
    
        // Find all list items within the guidelines container
        List<WebElement> guidelineItems = guidelinesContainer.findElements(By.xpath(".//ul[@class='guidelines-content__list']/li"));
    
        // Iterate over the guideline items
        for (WebElement guidelineItem : guidelineItems) {
            // Get the text content of the guideline item
            String guidelineText = guidelineItem.getText();
            System.out.println(guidelineText + "\r\n");
        }

    }

    public void  clickSeefullListhere () throws InterruptedException {
        delay(1);
        click(PayMongoPagePath.SEE_FULL_LIST_HERE_LINK);
    }

    public void ValidateListOfValidIDs () throws InterruptedException {
        delay(1);
        verifyElementIsPresent(PayMongoPagePath.LIST_OF_VALID_ID_POPUP);
        click(PayMongoPagePath.LIST_OF_PRIMARY_BUTTON);
        validatePrimaryIDs();
        delay(1);
        click(PayMongoPagePath.LIST_OF_SECONDARY_BUTTON);
        validateSecondaryIDs();
        click(PayMongoPagePath.CLOSE_POPUP);
    }

    public void clickVerifyIdentity () throws InterruptedException {
        delay(1);
        click(PayMongoPagePath.VERIFY_MY_IDENTITY_BUTTON);
    }
    
    public void validateVerificationPage() throws InterruptedException {
        switchToNewTab();
        Thread.sleep(2000);
        verifyElementIsPresent(PayMongoPagePath.VERIFICATION_PAGE);
    
        // Wait for MuiFormGroup-root elements to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> idelements;
    
        try {
            idelements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("MuiFormGroup-root")));
    
            // Iterate over the MuiFormGroup-root elements
            for (WebElement idelement : idelements) {
                // Get the text content of the element
                String textContent = idelement.getText().trim();
                System.out.println("Valid ID Options:\r\n" + textContent + "\r\n");
            }
        } catch (TimeoutException e) {
            System.out.println("Failed: MuiFormGroup-root elements not found");
        }
    }

    public void selectPrimaryID() throws InterruptedException {
        WebElement pid = driver.findElement(By.xpath(PayMongoPagePath.SELECT_PRIMARY_ID[0]));
        // Check if the element is displayed and selected
        if (pid.isDisplayed() && pid.isSelected()) {
            System.out.println("Passed: Primary ID is selected");
        } else {
            // If not selected, try clicking on it
            click(PayMongoPagePath.SELECT_PRIMARY_ID);
            // Verify if it's now selected
            if (pid.isSelected()) {
                System.out.println("Passed: Primary ID is selected");
            } else {
                System.out.println("Failed: Element not found or could not be selected");
            }
        }
        delay(1);
    }
    
    public void clickContinue() throws InterruptedException {
        delay(1);
        click(PayMongoPagePath.CONTINUE_BUTTON);
    }
    
    public void validatePrimaryIDList() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the presence of elements
            List<WebElement> pidelements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("MuiFormControl-root")));

            // Iterate over the elements
            for (WebElement pidelement : pidelements) {
                // Fetch Text Contents
                String textContent = pidelement.getText().trim();
                System.out.println("Select ID:\r\n" + textContent + "\r\n");
            }
        } catch (Exception e) {
            System.out.println("Failed: Elements not found");
        }
        delay(1);
    } 
    
    public void selectPrimaryIDType(String value) throws InterruptedException {
        delay(1);
        click(PayMongoPagePath.SELECT_PRIMARYID_TYPE(value));
    }
    


    public void validateCaptureOfID() throws InterruptedException {
        // Validate the presence of capture elements
        verifyElementIsPresent(PayMongoPagePath.CAPTURE_ID);
        verifyElementIsPresent(PayMongoPagePath.CAPTURE_SELFIE);
        
        // Click the capture button for ID
        click(PayMongoPagePath.CAPTURE_ID);
        
        // Wait for the page to load
        waitForPageToLoad();
        
        // Pause until the save and continue button is displayed
        boolean shouldPause = true;
        while (shouldPause) {
            try {
                // Check if the save and continue button is displayed
                WebElement saveAndContinueButton = driver.findElement(By.xpath(PayMongoPagePath.SAVE_AND_CONTINUE_BUTTON[0]));
                if (saveAndContinueButton.isDisplayed()) {
                    // If the button is displayed, exit the loop
                    shouldPause = false;
                } else {
                    // If not displayed, continue pausing
                    System.out.println("Automation paused at validateCaptureOfID() method. Waiting for Save and Continue button...");
                    Thread.sleep(1000); // Sleep for 1 second before checking again
                }
            } catch (NoSuchElementException e) {
                // If the button is not found, continue pausing
                System.out.println("Save and Continue button not found. Waiting...");
                Thread.sleep(1000); // Sleep for 1 second before checking again
            }
        }
        
        // After pausing, click the save and continue button
        click(PayMongoPagePath.SAVE_AND_CONTINUE_BUTTON);
    }
    

    

    
    public void validateCaptureOfSelfie() throws InterruptedException {
        // Validate the presence of capture elements
        verifyElementIsPresent(PayMongoPagePath.CAPTURE_ID);
        click(PayMongoPagePath.CAPTURE_ID);
        waitForPageToLoad();
        Thread.sleep(5000);
    
        // Pause until the save and continue button is displayed
        boolean shouldPause = true;
        while (shouldPause) {
            try {
                // Check if the save and continue button is displayed
                WebElement saveAndContinueButton = driver.findElement(By.xpath(PayMongoPagePath.SAVE_AND_CONTINUE_BUTTON[0]));
                if (saveAndContinueButton.isDisplayed()) {
                    // If the button is displayed, exit the loop
                    shouldPause = false;
                } else {
                    // If not displayed, continue pausing
                    System.out.println("Automation paused at validateCaptureOfSelfie() method. Waiting for Save and Continue button...");
                    Thread.sleep(1000); // Sleep for 1 second before checking again
                }
            } catch (NoSuchElementException e) {
                // If the button is not found, continue pausing
                System.out.println("Save and Continue button not found. Waiting...");
                Thread.sleep(1000); // Sleep for 1 second before checking again
            }
        }
    
        Thread.sleep(2000);
        click(PayMongoPagePath.SAVE_AND_CONTINUE_BUTTON);
    }

    public void validateResultHasBeenProcessed() throws InterruptedException {
        boolean elementPresent = false;
        
        while (!elementPresent) {
            try {
                // Check if the element is present
                verifyElementIsPresent(PayMongoPagePath.RESULT_PROCESSED);
                elementPresent = true; // If the element is found, exit the loop
            } catch (NoSuchElementException e) {
                // If the element is not found, refresh the browser and continue the loop
                System.out.println("Element not found. Refreshing the browser...");
                driver.navigate().refresh();
                Thread.sleep(5000); // Wait for the page to load after refresh
            }
        }
    }
    
    
    

    
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    

    public void clickSubmitButton() throws InterruptedException {
        delay(1);
        WebElement submitButton = driver.findElement(By.xpath(PayMongoPagePath.SUBMIT_BUTTON[0]));
        submitButton.click(); // Click the button
    }



    public void UploadFile() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//label[@class ='upload__button']"));
        element.click();

        // Locate the file input element using XPath
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='dti_registration']"));

        // Specify the file path to be uploaded
        String filePath = "C:\\Users\\DREAM PC Build\\Downloads\2a028aa20e85ee895cbfbfc9c735fc60.jpg";

        // Upload the file by sending the file path to the file input element
        fileInput.sendKeys(filePath);
    }


    public void Sign() throws InterruptedException {
        // Locate the canvas element
        WebElement canvas = driver.findElement(By.className("signature-pad__canvas"));
        
        // Create Actions instance
        Actions builder = new Actions(driver);
        
        // Move to the starting point of the signature (top-left corner of the canvas)
        builder.moveToElement(canvas).moveByOffset(0, 0).clickAndHold().build().perform();
        
        // Simulate drawing a line (e.g., move to various points on the canvas)
        // Adjust the coordinates according to your signature requirements
        builder.moveByOffset(100, 50).build().perform();
        builder.moveByOffset(50, 100).build().perform();
        builder.moveByOffset(-150, -50).build().perform();
        
        // Release the mouse button to finish the signature
        builder.release().build().perform();
        
        // Optionally, wait for the signature to be processed or for the next action to occur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("signature-pad__canvas")));
    }

    public boolean isConfirmationDisplayed() {
        try {
            // Find the confirmation message element
            WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(@class, 'confirmation__copy')]"));
            
            // Check if the confirmation message is displayed
            boolean isDisplayed = confirmationMessage.isDisplayed();
            
            // Log the result
            if (isDisplayed) {
                System.out.println("Confirmation message is displayed.");
            } else {
                System.out.println("Confirmation message is not displayed.");
            }
            
            return isDisplayed;
        } catch (Exception e) {
            // Log any exception that occurs
            System.out.println("Exception occurred while checking confirmation message: " + e.getMessage());
            return false;
        }
    }

    

}
