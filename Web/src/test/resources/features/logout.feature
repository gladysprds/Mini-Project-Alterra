Feature: transaction
  As a user
  i want to logged out from my account
  so that i can get out from the website


  @Logout
  Scenario: Logout
    Given i have to login first
    When i click icon account
    Then i get my login page