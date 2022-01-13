@sort
Feature: sorting the products
  As a end user 
  I want to search a product and choose a sort option
  So that I should be able to get see items relevant to the sort option

    Scenario Outline: sorting the products
    Given  I am on homepage
    When I search for a product "<product>"
    And I choose a sort option "<sort>"
    Then I should see only the relevant product according to the sort "<sort>"
Examples: 
    |product       |    sort                |
    |pampers       |  Price - Low to High   |
    |pampers       |  Price - High to Low   |
    |pampers       |   Name - A-Z           |
    |pampers       |   Name - Z-A           |



  