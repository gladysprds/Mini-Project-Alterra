Feature: Ratings
  As a user
  I want to give ratings on product
  So that another user know how good the product is

  @getRatings
  Scenario: As a user i want to see ratings of product
    Given I set an endpoint for ratings
    When I request GET ratings of a product
    Then I validate the status code is 200
    And I get the rating of a product

    @postRatings
    Scenario: POST - As a user i want to give ratings on a product
      Given I set an endpoint for ratings
      When I request POST rating products
      Then I validate the status code is 200
      And I validate the data detail with rating that just added

      @postRatingwithNull
      Scenario: POST-As a user i can put nothing on product rating
        Given I set an endpoint for ratings
        When I request POST without give rating on products
        Then I validate the status code is 200
        And I validate the rating is not changes

      @postRatingwithNonNumber
        Scenario: POST - As a user i can give any character except number for product rating
          Given I set an endpoint for ratings
          When I request POST with give any character except number
          Then I validate the status code is 200
          And I validate the rating is not changes

        @postRatingWithNumberOver5
        Scenario: POST - As a user i cant give rating over 5
          Given I set an endpoint for ratings
          When I request POST with number over five
          Then I validate the status code is 500
          And I validate the rating error message will displayed


