package com.spslog.bdd.hooks;

import com.spslog.bdd.contants.Browser;
import com.spslog.bdd.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    private WebDriver driver;

    @Before
    public void before(Scenario s) {
        System.out.printf("BEFORE: Scenario: %s, Thread = %s%n", s.getName(), Thread.currentThread().threadId());
        String browser = System.getProperty("browser", Browser.CHROME.toString()).toUpperCase();
        driver = DriverFactory.initializeDriver(browser);
    }

    @After(order = 1)
    public void takeScreenShot(Scenario scenario) {
        byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());
    }

    @After(order = 0)
    public void after(Scenario s) {
        System.out.printf("AFTER: Scenario: %s, THREAD = %s%n", s.getName(), Thread.currentThread().threadId());
        driver.quit();
    }

}
