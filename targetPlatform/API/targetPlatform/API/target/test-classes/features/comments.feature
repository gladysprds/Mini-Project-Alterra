Feature: Comments
  As user
  I want to put comment for a product
  So that another user can see the product's comment

  @postCommentsById
  Scenario: POST - As a user i have to be able to create a comment on a product
    Given I set an endpoint comments
    When I request POST rating comments
    Then I validate the status code is 200
    And validate data detail after create comment

  @getCommentsById
  Scenario: GET - As a user I have to be able to get the comment
    Given I set an endpoint comments
    When I request GET product comments
    Then I validate the status code is 200
    And validate data detail of product comments

    @postNullComments
    Scenario: POST - As a user I cannot input null comments on product
      Given I set an endpoint comments
      When I request POST null comments on product
      Then I validate the status code 500
      And validate error message




