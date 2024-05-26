package com.paymongo.mongopage;

import com.paymongo.common.BasePage;
import org.openqa.selenium.WebDriver;

public class PayMongoPage extends BasePage {

    public PayMongoPage(WebDriver driver) {
        super(driver);
    }

    public void validateElementIsPresent(String[] locator) {
        verifyElementIsPresent(locator);
    }
}
