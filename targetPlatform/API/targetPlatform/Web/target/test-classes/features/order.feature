Feature: Order
  As a user
  i want to order product
  so that i can see my product on cart

  @order
  Scenario: enter new product to cart
    Given i am on home page
    When i click beli on product
    And i click my cart
    Then i get the my product based on what i choose

  @add
  Scenario: add product to cart
    Given i am on home page
    When i click beli on product
    And i click my cart
    And i click add button
    Then i get the product as much as i add


  @reduce
  Scenario: reduce product on cart
    Given i am on home page
    When i click beli more than once
    And i click my cart
    And i click minus button
    Then i get the product as much as i reduce

    @empty
  Scenario: empty cart
    Given i am on home page
    When i click my cart
    Then i get empty cart alert
