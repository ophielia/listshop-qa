@mobile
Feature: Do my tests work?
  Everybody wants it to work

  Scenario: We can or can't see what's loaded
    Given user is on choice page
    Then I should be see the skip button
    And I should see the signin button
    And I should see the signup button

  Scenario: Can move to sign up page
    Given user is on choice page
    When User clicks on the signup button
    Then User sees the signup page

  Scenario: Can move to sign in page
    Given user is on choice page
    When User clicks on the signin button
    Then User sees the signin page

  Scenario: Can move to skip login page
    Given user is on choice page
    When User clicks on the skip login button
    Then User sees the list screen page