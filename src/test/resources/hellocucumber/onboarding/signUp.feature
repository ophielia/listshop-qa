@anonymoususer
Feature: Sign Up Tests
  User can create new account

  Background:
    Given User navigates to sign up page

  Scenario: SignUp possible with valid email and password
    Given User enters random username
    And User enters default password and verification
    And User submits signup
    Then User is logged in


  Scenario: User signs up and remains logged in when reopening app
    Given User enters random username
    And User enters default password and verification
    And User submits signup
    Then User is logged in
    And User reopens app
    And User is logged in

  Scenario: User can logout and login after signing up
    Given User enters random username
    And User enters default password and verification
    And User submits signup
    Then User is logged in
    And User logs out
    And User logs in with random user
    And User is logged in

  Scenario: Signup doesn't work with invalid username
    Given User enters invalid username
    And User enters default password and verification
    And User submits signup
    Then User sees the signup page
    And User sees error message


