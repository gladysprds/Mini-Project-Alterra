Feature: Login
  As a user
  i want to login
  so that i can access my homepage

  Background:
    Given i am on login page

  @DDT
  Scenario Outline: Login scenario
    When i input "<username>" username
    And i input "<password>" password
    And click login button
    Then i get the "<result>"
    Examples:
      |username|password|result|
      |gladys@gmail.com|gladys|home page|
      |gladys@gmail.com|    |Login Page|
      |   |realgladz1511|Login Page|
      |   |             |Login Page|
      |gladys@gmail.com|gladz1511#|Login Page|
      |glad@gmail.com|realgladz1511|Login Page|
      |glad@gmail.com|gladz1511#|Login Page|