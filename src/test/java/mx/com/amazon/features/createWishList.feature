Feature: Create a wish list

  Scenario: Create a wish list in the Amazon page
    Given I navigate to Home Page
    And I login to the Amazon site
    When I click the link to create a wish list
    Then I will create a wish list
    And Verify it was created

#resumir en un solo paso la creacion del wishlist