Feature: Autentikasi
  As a user
  I want to get in to website
  So that i must have an account

  @registration
  Scenario Outline: POST - As a user i have to be able to register
    Given I set an endpoint for new user
    When I request POST user with "<fullname>" and "<email>" and "<password>"
    Then I validate the status code <status_code>
    And I validate the "<message>" detail after register
    And I get the data for another request

    Examples:
     |fullname | email | password | status_code | message |
     |selamat|detektifastr@gmail.com|selamat123 |200|success|
     |       |detektifastr@gmail.com|anom123 |400 |fullname required|
     |threeanom||anom123 |400|email required|
     |threeanom|detektifastr@gmail.com|        |400   |password required|
     |         |                |        |400        |null|
     |threeanom| same |anom123 |400         |duplicate|

    @login
    Scenario Outline: POST - As a user i have to be able to login
      Given I set an endpoint for login
      When I request POST for login with "<email>" and "<password>"
      Then I validate the status code <status_code>
      And I validate the "<result>" detail after login


      Examples:
        |email|password|status_code|result|
        |gladys@gmail.com|gladys|200|login|
        |gladys@gmail.com|    |400|password null|
        |   |realgladz1511|400 |email null|
        |   |             |400|null|
        |gladys@gmail.com|gladz1511#|400|invalid password|
        |glad@gmail.com|realgladz1511|400|invalid email|
        |glad@gmail.com|gladz1511# |400|invalid password and email|

