@regression
Feature: Add to cart

  Scenario Outline: Add a product to cart as a guest user
    Given User is on the Store page
    When user adds 1 "<product_name>" to the cart
    Then user should see 1 "<product_name>" in the cart
    Examples:
      | product_name    |
      | Blue Shoes      |
      | Anchor Bracelet |