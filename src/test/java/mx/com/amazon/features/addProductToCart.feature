Feature: Add a product to cart

  Scenario: Add a product to cart in the Amazon page
    Given I navigate to Home Page
    And I login to the Amazon site
    When I search for an product
    And I select the product
    Then I will add the product to the cart