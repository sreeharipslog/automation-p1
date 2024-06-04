package com.spslog.bdd.pages;

import com.spslog.bdd.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    // Accessible from child pages
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize driver, wait and UI elements
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // initialize wait
        PageFactory.initElements(driver, this); // initialize PageUI elements using PageFactory
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
}

