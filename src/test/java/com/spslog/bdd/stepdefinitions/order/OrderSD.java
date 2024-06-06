package com.spslog.bdd.stepdefinitions.order;

import com.spslog.bdd.contants.EndPoint;
import com.spslog.bdd.domain.Address;
import com.spslog.bdd.domain.Product;
import com.spslog.bdd.factory.DriverFactory;
import com.spslog.bdd.pages.CartPage;
import com.spslog.bdd.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// import org.junit.Assert;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class OrderSD {
    private WebDriver driver;

    @Given("a guest user")
    public void aGuestUser() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPoint.STORE.path);
    }

    @And("user has multiple products in cart")
    public void userHasMultipleInCart(List<Product> products) {
        StorePage storePage = new StorePage(driver);
        storePage.addProductListToCart(products);
        storePage.viewCart();
    }

    @And("navigates to checkout page")
    public void navigatesToCheckoutPage() {
        new CartPage(driver).proceedToCheckout();
    }

    @When("user provide the billing address")
    public void userProvideTheBillingAddress(Address address) {
        new CartPage(driver).enterBillingDetails(address);
    }

    @And("place an order")
    public void placeAnOrder() {
        new CartPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", new CartPage(driver).getNotice());
    }
}
