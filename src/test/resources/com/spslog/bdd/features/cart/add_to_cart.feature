@regression
Feature: Add to cart

  Scenario: Add a product to cart as a guest user
    Given User is on the Store page
    When user adds 1 "Blue Shoes" to the cart
    Then user should see 1 "Blue Shoes" in the cart