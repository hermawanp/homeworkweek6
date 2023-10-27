Feature: Login

  Scenario: Login as invalid username
    Given user should open saucedemo
    When user input invalid username
    And user input invalid password
    And user click login button
    Then dashboard should not be displayed