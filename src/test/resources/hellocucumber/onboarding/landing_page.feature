@mobile
Feature: Basic Landing Page Tests
  The links on the landing page lead where they should

  Scenario: We can or can't see what's loaded
    Given User is on choice page
    Then User should see the skip button
    And User should see the signin button
    And User should see the signup button

  Scenario: Can move to sign up page
    Given User is on choice page
    When User clicks on the signup button
    Then User sees the signup page

  Scenario: Can move to sign in page
    Given User is on choice page
    When User clicks on the signin button
    Then User sees the signin page

  Scenario: Can move to skip login page
    Given User is on choice page
    When User clicks on the skip login button
    Then User sees the list screen page