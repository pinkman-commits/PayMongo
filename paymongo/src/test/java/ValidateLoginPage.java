import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paymongo.common.BasePage;
import com.paymongo.common.BaseTest;
import com.paymongo.mongopage.PayMongoPage;
import com.paymongo.mongopage.PayMongoPagePath;
import com.utils.Login_Configuration;

import org.openqa.selenium.WebDriver;

public class ValidateLoginPage extends BaseTest {

    @BeforeTest
    public void setUP() {
        setupLaunch();
    }

    @Test
    public void validateLoginElements() throws Exception {
        PayMongoPage paymongopage = new PayMongoPage(driver);
        paymongopage.validateElementIsPresent(PayMongoPagePath.LOGIN_TITLE);
       
    }
    
}
