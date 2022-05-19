Feature: Registration
  As a user
  i want to register
  so that i have an account to login into website

  Background:
    Given i access the web

  @register
  Scenario Outline: Registration scenario
    When i click icon account and register
    And  i input "<name>" my name
    And  i input "<email>" my email
    And  i input "<password>" my password
    And  i click register button
    Then i get my "<result>"

    Examples:
     |name |email|password|result|
     |sonyaprds|sonya@gmail.com|sonya|new user|
     |sonyaprds|sonya@gmail.com|     |Register Page|
     |sonyaprds|               |sonya|Register Page|
     |         |sonya@gmail.com|sonya|Register Page|
     |         |               |sonya|Register Page|
     |         |sonya@gmail.com|     |Register Page|
     |sonyaprds|               |     |Register Page|
     |         |               |     |Register Page|
     |same     |same           |same |Register Page|
     |gopal    |same           |same |Register Page|
     |same     |gopal@gmail.com|same |new user     |
     |same     |same           |gopalos|Register Page|

