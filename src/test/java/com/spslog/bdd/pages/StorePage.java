package com.spslog.bdd.pages;

import com.spslog.bdd.domain.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StorePage extends BasePage {

    @FindBy(css = "a[title='View cart']")
    private WebElement viewCartBtn;
    @FindBy(xpath = "//h1[normalize-space()='Store']")
    private WebElement titleText;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String product) {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + product + "” to your cart']");
        // Either manually implement wait if needed or follow always wait strategy.
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void addProductQuantityToCart(int quantity, Product product) {
        for (int x = 0; x < quantity; x++) addToCart(product.name());
    }

    public void addProductListToCart(List<Product> products) {
        products.forEach(pdt -> addToCart(pdt.name()));
    }

    public void viewCart() {
        // Replaced manual Thread.sleep with implicit wait.
        wait.until(ExpectedConditions.visibilityOf(titleText));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }
}
