Feature: Login

  Scenario: Login as valid user
    Given user should open saucedemo
    When user input valid username
    And user click login button
    Then dashboard should be displayed