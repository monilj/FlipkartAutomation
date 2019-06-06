@flip
Feature: Test Search functionality

  Scenario Outline: search some product
    Given User opens flipkart in chrome
    When User search for a "<product>"
    Then User applies a "<filter>" to sort the products
    And User selects first product
    And User redirects to product page
    And User selects "<Size>"
    Then User enters pin code
    Examples:
      | product      | filter               | Size |
      | Polo T-shirt | Price -- Low to High | S    |





