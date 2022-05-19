Feature: Login

  Scenario Outline: Login scenario
    Given i am on login page
    When i input "<email>" username
    And i input "<password>" password
    And click login button
    Then i get the "<result>"
    Examples:
      |email|password|result|
      |gladys@gmail.com|gladys|home page|