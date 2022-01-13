@search
Feature: searching a product
  As a end user
  I want to search for a product
  So that I should be able to see relevant products

  Scenario Outline: searching for a product
    Given I am on homepage
    When I search for a product "<product>"
    Then I should see only the relevant product "<product>"

    Examples:
    |product   |
    |television|
    |Christmas String Lights |
    |christmas cards|
    |cooling fans        |
    |kitchen bins        |

