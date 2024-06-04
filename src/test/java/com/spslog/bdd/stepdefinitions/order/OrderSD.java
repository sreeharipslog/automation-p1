package com.spslog.bdd.stepdefinitions.order;

import com.spslog.bdd.domain.Address;
import com.spslog.bdd.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderSD {
    private WebDriver driver;


    @Given("a guest user")
    public void aGuestUser() {
        driver = DriverFactory.getDriver();
        driver.get("https://askomdch.com");
    }

    @And("user has multiple products in cart")
    public void userHasMultipleInCart(List<String> products) throws InterruptedException {
        products.forEach(pdt -> {
            String xpath = "//a[@aria-label='Add “" + pdt + "” to your cart']";
            By addToCartBtn = By.xpath(xpath);

            driver.findElement(addToCartBtn).click();
        });
        Thread.sleep(5000);
        By viewCartBtn = By.xpath("(//a[@title='View cart'][normalize-space()='View cart'])[1]");
        driver.findElement(viewCartBtn).click();
    }

    @And("navigates to checkout page")
    public void navigatesToCheckoutPage() {
        By proceedToCheckoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");
        driver.findElement(proceedToCheckoutBtn).click();
    }

    @When("user provide the billing address")
    public void userProvideTheBillingAddress(Address address) {
        By firstNameFld = By.id("billing_first_name");
        By lastNameFld = By.id("billing_last_name");
        By addressFld = By.id("billing_address_1");
        By cityFld = By.id("billing_city");
        By stateDropDown = By.id("billing_state");
        By pinOrZipFld = By.id("billing_postcode");
        By emailFld = By.id("billing_email");

        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(address.firstName());
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(address.lastName());
        driver.findElement(addressFld).clear();
        driver.findElement(addressFld).sendKeys(address.street());
        driver.findElement(cityFld).clear();
        driver.findElement(cityFld).sendKeys(address.city());
        Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(address.state());
        driver.findElement(pinOrZipFld).clear();
        driver.findElement(pinOrZipFld).sendKeys(address.pinCode());
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(address.email());
    }

    @And("place an order")
    public void placeAnOrder() throws InterruptedException {
        By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();
        Thread.sleep(5000);
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        By noticeText = By.cssSelector(".woocommerce-notice");
        String actualNoticeMsg = driver.findElement(noticeText).getText();
        Assert.assertEquals("Thank you. Your order has been received.", actualNoticeMsg);
    }
}
