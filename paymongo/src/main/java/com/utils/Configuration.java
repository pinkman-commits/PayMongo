package com.utils;

public class Configuration {

    public static int DEFAULT_WAIT = 15;

    public static final String CHROME   = "webdriver.chrome.driver";
    public static final String EDGE     = "webdriver.edge.driver";
    public static final String FIREFOX  = "webdriver.gecko.driver";
    
    public static final String ROOTHPATH = System.getProperty("user.dir").replace("/", "\\");
}
