package com.spslog.bdd.pages;

import com.spslog.bdd.domain.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {

    // Page UI/Web Elements
    @FindBy(css = "td[class='product-name']")
    WebElement productNameFld;
    @FindBy(css = "input[type=\"number\"]")
    WebElement productQuantityFld;
    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;
    @FindBy(id = "place_order")
    WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice")
    WebElement noticeText;

    // Billing address fields
    @FindBy(id = "billing_first_name")
    WebElement firstNameFld;
    @FindBy(id = "billing_last_name")
    WebElement lastNameFld;
    @FindBy(id = "billing_address_1")
    WebElement addressFld;
    @FindBy(id = "billing_city")
    WebElement cityFld;
    @FindBy(id = "billing_state")
    WebElement stateDropDown;
    @FindBy(id = "billing_postcode")
    WebElement pinOrZipFld;
    @FindBy(id = "billing_email")
    WebElement emailFld;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityFld)).getAttribute("value"));
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public CartPage enterBillingFirstName(String firstName) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(firstNameFld));
        we.clear();
        we.sendKeys(firstName);
        return this;
    }

    public CartPage enterBillingLastName(String lastName) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(lastNameFld));
        we.clear();
        we.sendKeys(lastName);
        return this;
    }

    public CartPage enterBillingAddress(String address) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(addressFld));
        we.clear();
        we.sendKeys(address);
        return this;
    }

    public CartPage enterBillingCity(String city) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(cityFld));
        we.clear();
        we.sendKeys(city);
        return this;
    }

    public CartPage enterBillingState(String state) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(stateDropDown)));
        select.selectByVisibleText(state);
        return this;
    }

    public CartPage enterBillingPinOrZipCode(String pinOrZip) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(pinOrZipFld));
        we.clear();
        we.sendKeys(pinOrZip);
        return this;
    }

    public CartPage enterBillingEmail(String email) {
        WebElement we = wait.until(ExpectedConditions.visibilityOf(emailFld));
        we.clear();
        we.sendKeys(email);
        return this;
    }

    // using builder pattern
    public void enterBillingDetails(Address address) {
        enterBillingFirstName(address.firstName()).
                enterBillingLastName(address.lastName()).
                enterBillingAddress(address.street()).
                enterBillingCity(address.city()).
                enterBillingState(address.state()).
                enterBillingPinOrZipCode(address.pinCode()).
                enterBillingEmail(address.email());
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }
}
