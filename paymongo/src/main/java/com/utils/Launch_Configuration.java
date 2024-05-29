package com.utils;

import com.paymongo.common.BaseTest;

public class Launch_Configuration extends BaseTest {

    public static final String BROWSER = "chrome";
    public static final String PAGE = "Login";

    public static String USER;
    public static String PASSWORD = "";

    public static final String URL() {
        switch (PAGE) {
            case "Login":
                return "https://dashboard.paymongo.com/login";
            case "Signup":
                return "https://dashboard.paymongo.com/signup";
            default:
                return "";
        }
    }
    
    public static final void NavigateToPayMongo() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.setupLaunch();
    }
}
