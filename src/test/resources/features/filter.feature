@filter
Feature: filter
  As a end user
  I want to search a product and apply filter
  So that I should see the relevant results

  Background:
    Given I am on homepage

  Scenario Outline: Filter By Price
    When I search for a product "<product>"
    And I apply a filter by price "<price>"
    Then I should see only the relevant product by price "<price>"

    Examples:
      |   product          |        price                |
      | pampers            |    £500 - £749.99           |
      |cooling fans        |    £200 - £299.99           |


    Scenario Outline: Filter By Category
      When I search for a product "<product>"
      And I apply a filter by price "<category>"
      Then I should see only the relevant product by "<product>"

      Examples:
    |product      |     category            |
    |television   |     Televisions         |
    |keyboard     |     Keyboard            |
    |heater       |     Heaters             |

