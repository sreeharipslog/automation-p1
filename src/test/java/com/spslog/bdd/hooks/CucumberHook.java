package com.spslog.bdd.hooks;

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
    public void before() {
        driver = DriverFactory.initializeDriver();
    }

    @After(order = 1)
    public void takeScreenShot(Scenario scenario) {
        byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(image, "image/png", scenario.getName());
    }

    @After(order = 0)
    public void after() {
        driver.quit();
    }

}
