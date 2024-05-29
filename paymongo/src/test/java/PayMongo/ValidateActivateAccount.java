package PayMongo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.paymongo.common.BaseTest;
import com.paymongo.mongopage.PayMongoPage;

import com.utils.ExtentReportsManager;

public class ValidateActivateAccount extends BaseTest {
    ExtentReportsManager extentManager;

    public ValidateActivateAccount() {
        extentManager = new ExtentReportsManager();
        extentManager.startExtentReport("\\extent-reports\\activate_account_report2.html");
    }

    @BeforeTest
    public void setUP() {
        setupLaunch();
   
    }

   
    @Test(priority = 1)
    public void validateLoginElements() throws Exception {
        
        PayMongoPage PayMongo = new PayMongoPage(driver);
        extentManager.logStep("Validate Log in Page");
        PayMongo.validateLoginElements();
        PayMongo.waitLoading();
        PayMongo.LoginPayMongoAccount(testdata.valid_email1, testdata.valid_password);
        PayMongo.validatePasswordIsMasked();
        
        PayMongo.clickLogInButton();
        PayMongo.waitLoading();
        PayMongo.waitForLoadingSpinner();
        
        //Step 1
        extentManager.logStep("Validate Activate Account - Step 1: Know Your Customer");
        PayMongo.validateWelcomePage();
        PayMongo.capturePageData();
        PayMongo.validateActivationSteps();
        PayMongo.validateSideBarShorcuts();
        PayMongo.clickNextButton();


        extentManager.logStep("Validate Activate Account - Step 2: Identity Verification");
        PayMongo.captureIDValidationGuidelines();
        PayMongo.clickSeefullListhere();
        PayMongo.ValidateListOfValidIDs();
        PayMongo.clickVerifyIdentity();
        
        extentManager.logStep("Validate Activate Account - Step 2: Capture of Documents");
        PayMongo.validateVerificationPage();
        PayMongo.selectPrimaryID();
        PayMongo.clickContinue();
        PayMongo.selectPrimaryIDType(testdata.UMID);
        PayMongo.clickContinue();

        PayMongo.validateCaptureOfID();
        PayMongo.validateCaptureOfSelfie();
        PayMongo.clickSubmitButton();

        extentManager.logStep("Validate Activate Account - Step 2: Result Processed");
        PayMongo.validateResultHasBeenProcessed();
        PayMongo.clickNextButton();
        



       
    }
        
}
