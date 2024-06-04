@regression
Feature: Place an order

  Scenario: Place an order as guest using default payment option
    Given a guest user
    And user has multiple products in cart
      | Blue Shoes       |
      | Basic Blue Jeans |
    And navigates to checkout page
    When user provide the billing address
      | first_name | last_name | country       | street_address | city    | state   | pin_code | email      |
      | Bill       | B         | United States | Arkham Street  | Atlanta | Georgia | 30033    | bill@b.com |
    And place an order
    Then the order should be placed successfully