Feature: Products
  As an admin
  I want to choose product
  So that I get my product

  @getallproduct
  Scenario: GET - As an user I have to be able to get all products

    Given I set an endpoint products
    When I request GET all products
    Then I validate the status code is 200
    And validate data detail all products

  @postproduct
  Scenario: POST - As an admin i have to be able to create products

    Given I set an endpoint products
    When I request POST products
    Then I validate the status code is 200
    And  I validate the products that just added is displayed

  @getByIdProduct
    Scenario: GET - As a user i have to be able to search product by id
      Given I set an endpoint products
      When I request GET products by ID
      Then I validate the status code is 200
      And i validate data of a product

    @getProductWithIdMoreThan10000
    Scenario: GET - As a user i cannot get product which is the ID is not created
      Given I set an endpoint products with ID more than total
      When I request GET products by ID more than the total
      Then I validate the status code is 404
      And i validate the error messages of product

      @getProductWithString
      Scenario: GET - As a user i cannot GET product with string input
        Given I set an endpoint products
        When I request GET products with string
        Then I validate the status code 400
        And i validate another error message of product

        @postproductNameWithNumber
        Scenario: POST - As a user i cannot POST product Name with Number
          Given I set an endpoint products
          When I request POST products name with number
          Then I validate the status code 400
          And I validate the error message post product name with number

       @postProductNameNull
        Scenario: POST - As a user i cannot POST product Name with Null
          Given I set an endpoint products
          When I request POST products name with Null
          Then I validate the status code 500
          And I validate the error message post product name with Null

         @postProductPriceWithString
         Scenario: POST - As a user i cannot input price With String
           Given I set an endpoint products
           When I request POST products price with String
           Then I validate the status code 400
           And I validate the error message product price with string



