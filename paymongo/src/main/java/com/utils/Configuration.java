package com.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Configuration {

    public static int DEFAULT_WAIT = 15;

    public static final String CHROME   = "webdriver.chrome.driver";
    public static final String EDGE     = "webdriver.edge.driver";
    public static final String FIREFOX  = "webdriver.gecko.driver";
    
    public static final String ROOTHPATH = System.getProperty("user.dir").replace("/", "\\");
}
