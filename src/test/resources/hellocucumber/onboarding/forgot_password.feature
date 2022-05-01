@anonymoususer
Feature: Forget Password Tests
  Test functions around resetting password during onboarding.

  Background:
    Given User navigates to forgot password page

  Scenario: Forget password with known user is successful
    Given User resets password with username "uitest@the-list-shop.com"
    Then User sees password reset success page

  Scenario: Forget password with unknown user doesn't work
    Given User resets password with username "garbage@the-list-shop.com"
    Then User remains on forgot password page
    And User sees forgot password error message


