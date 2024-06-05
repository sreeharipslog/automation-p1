package com.spslog.bdd.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory to manage Selenium WebDriver
 */
public class DriverFactory {

    private static final String chromePath = "D:\\tsoftwares\\chrome-for-testing\\chrome-125.0.6422.141\\chrome.exe";
    private static final String chromeDriverPath = "D:\\tsoftwares\\chrome-for-testing\\driver\\chromedriver-125.0.6422.141\\chromedriver.exe";
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromePath);
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
