import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paymongo.common.BasePage;
import com.paymongo.common.BaseTest;
import com.paymongo.mongopage.PayMongoPage;
import com.paymongo.mongopage.PayMongoPagePath;
import com.utils.ExtentReportsManager;
import com.utils.Launch_Configuration;

import org.openqa.selenium.WebDriver;

public class ValidateActivateAccount extends BaseTest {
    ExtentReportsManager extentManager;

    @BeforeTest
    public void setUP() {
        setupLaunch();
        extentManager = new ExtentReportsManager();
    }

    @SuppressWarnings("static-access")
    @Test
    public void validateLoginElements() throws Exception {
        extentManager.startExtentReport("\\extent-reports\\activate_account_report.html");
        PayMongoPage PayMongo = new PayMongoPage(driver);
        
        extentManager.logstep("Validate Log in Page");
        PayMongo.validateLoginElements();
        PayMongo.waitLoading();
        PayMongo.LoginPayMongoAccount(testdata.valid_email, testdata.valid_password);
        PayMongo.validatePasswordIsMasked();
                
        PayMongo.clickPasswordMaskIcon();
        PayMongo.validatePasswordIsNotMasked();
        

        PayMongo.clickPasswordMaskIcon();
        PayMongo.validatePasswordIsMasked();
        
        PayMongo.clickLogInButton();
        PayMongo.waitLoading();
        PayMongo.waitForLoadingSpinner();

        extentManager.logstep("Validate Activate Account");
        PayMongo.validateWelcomePage();
        PayMongo.captureWelcomePageData();
        PayMongo.validateActivationSteps();
        PayMongo.validateSideBarShorcuts();

        extentManager.endExtentReport();

       
    }
    
}
