Feature: Categories
  As an admin
  I want to get product by categories
  So that I can choose my product easier
  @getAllCategories
  Scenario: GET - As an user I have to be able to get all categories

    Given I set an endpoint
    When I request GET all categories
    Then I validate the status code is 200
    And validate data detail all categories

  @postCategories
  Scenario: POST - As an admin i have to be able to create categories

    Given I set an endpoint
    When I request POST Categories
    Then I validate the status code is 200
    And I validate the categories that just added is displayed


    @postCategoriesWithNameNull
    Scenario: POST - AS an admin i cannot input Null categories Name 
      
      Given I set an endpoint
      When I request POST categories with null name
      Then I validate the status code 500
      And I validate the error message with null name is displayed

      @postCategoriesWithNameNumber
      Scenario: POST - AS an admin i cannot input categories Name with number

        Given I set an endpoint
        When I request POST categories name with number
        Then I validate the status code 400
        And I validate error message with Name number
      


