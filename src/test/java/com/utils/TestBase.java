package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static String fileName;
    public static Properties prop;

    TestBase() {
        {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//com//resources//config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            prop = new Properties();
            try {
                prop.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String url = prop.getProperty("QAUrl");
            //String browser_properties = prop.getProperty("browser");
            //String browser_maven=System.getProperty("browser");

            //String browser = browser_maven!=null ? browser_maven : browser_properties;
            String browser = prop.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome"))
                driver.set(new ChromeDriver());

        }
    }

    public static WebDriver WebDriverManager() {
        return driver.get();
    }
}
