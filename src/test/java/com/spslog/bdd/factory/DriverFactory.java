package com.spslog.bdd.factory;

import com.spslog.bdd.contants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.spslog.bdd.contants.Browser.*;

/**
 * Factory to manage Selenium WebDriver
 */
public class DriverFactory {

     /* There are 2 approaches to parallel execution
     * 1. Make driver a ThreadLocal variable to use independently among parallel threads
     * 2. Injects driver to StepDefinitions using Dependency Injection
     */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browserString) {
        Browser browser = Browser.valueOf(browserString);
        WebDriver driver = switch (browser) {
            case CHROME, HEADLESS_CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.setBinary(CHROME.path);
                //if (browser == HEADLESS_CHROME) chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--headless");
                yield new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Browser is not valid");
        };
        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
