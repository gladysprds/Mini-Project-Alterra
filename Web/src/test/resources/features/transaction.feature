Feature: transaction
  As a user
  i want to pay my product
  so that i get my product


  @transwithLogin
  Scenario: buy product with login first
    Given i have to login first
    When i click beli on my product
    And i click cart
    And i click bayar button
    Then i get my product that i pay

 @transwithoutLogin
 Scenario: buy product without login first
   Given i am on home page
   When i click beli on my product
   And i click my cart
   And i click bayar button
   Then i am on login page

   @transwithoutRegister
   Scenario: buy product without register first
     Given i am on home page
     When i click beli on my product
     And i click my cart
     And i click bayar button
     And i am on login page
     And i click register link
     Then i am on register page