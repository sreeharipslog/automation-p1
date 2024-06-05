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

    /* There are 2 approaches to parallel execution
     * 1. Make driver a ThreadLocal variable to use independently among parallel threads
     * 2. Injects driver to StepDefinitions using Dependency Injection
     */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromePath);
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
