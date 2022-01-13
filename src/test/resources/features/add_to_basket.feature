@basket
Feature: add a product to the basket
  As a end user
  I want to search and add a product to basket
  So that I can buy the product later

  Scenario: adding a product to basket
    Given I am on homepage
    When I search for a product "fridge"
    And select any product from the list
    And I add product to basket
    And I go to basket
    Then I should see the selected product in the basket



