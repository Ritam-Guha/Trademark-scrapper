package com.probe.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;

public abstract class BaseScraper {
    protected Properties properties = new Properties();
    protected WebDriver webDriver;
    public BaseScraper()  {
        try {
            InputStream configInputStream = new FileInputStream(getConfigFile());
            properties.load(configInputStream);
        } catch (IOException e) {
            //throw runtime exception
        }
        System.setProperty("webdriver.chrome.driver", new File(properties.getProperty("chrome.driver.path")).getAbsolutePath());
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);
        } catch (Exception exception) {
            if (webDriver != null) {
                browserShutDown();
            }
//            throw new RuntimeException("Unable to launch browser : " + StringUtil.getStackTraceAsString(e));
        }
    }


    protected abstract File getConfigFile();

    protected void browserShutDown() {
        webDriver.quit();
    }
}