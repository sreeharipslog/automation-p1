package com.spslog.bdd.stepdefinitions.cart;

import com.spslog.bdd.contants.EndPoint;
import com.spslog.bdd.domain.Product;
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
        new StorePage(driver).load(EndPoint.STORE.path);
    }

    @When("user adds {int} {product} to the cart")
    public void userAddsToTheCart(int quantity, Product product) {
        StorePage storePage = new StorePage(driver);
        storePage.addProductQuantityToCart(quantity, product);
        storePage.viewCart();
    }

    @Then("user should see {int} {product} in the cart")
    public void userShouldSeeInTheCart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(product.name(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
