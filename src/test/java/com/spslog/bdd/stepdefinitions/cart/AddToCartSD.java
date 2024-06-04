
package com.spslog.bdd.stepdefinitions.cart;

import com.spslog.bdd.factory.DriverFactory;
import com.spslog.bdd.pages.CartPage;
import com.spslog.bdd.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddToCartSD {
    private WebDriver driver;

    @Given("User is on the Store page")
    public void userIsOnTheStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("/store");
    }

    @When("user adds {int} {string} to the cart")
    public void userAddsToTheCart(int quantity, String productName) {
        StorePage storePage = new StorePage(driver);
        storePage.addProductQuantityToCart(quantity, productName);
        storePage.viewCart();
    }

    @Then("user should see {int} {string} in the cart")
    public void userShouldSeeInTheCart(int quantity, String pdtName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(pdtName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
