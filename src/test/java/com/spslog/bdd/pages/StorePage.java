package com.spslog.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StorePage extends BasePage {

    @FindBy(css = "a[title='View cart']")
    private WebElement viewCartBtn;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String product) {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + product + "” to your cart']");
        // Either manually implement wait if needed or follow always wait strategy.
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void addProductQuantityToCart(int quantity, String productName) {
        for (int x = 0; x < quantity; x++) addToCart(productName);
    }

    public void addProductListToCart(List<String> products) {
        products.forEach(this::addToCart);
    }

    public void viewCart() {
        // Replaced manual Thread.sleep with implicit wait.
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }
}
