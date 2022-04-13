@anonymoususer
Feature: Logging In Tests
  Good credentials work.  Bad credentials don't.

  Background:
    Given User navigates to sign in page

  Scenario: Login works with correct credentials
    Given User enters username "uitest@the-list-shop.com"
    And User enters password "passw0rd"
    And User clicks on the submit button
    Then User sees the list screen page


  Scenario: Logged in user remains logged in when reopening app
    Given User enters username "uitest@the-list-shop.com"
    And User enters password "passw0rd"
    And User clicks on the submit button
    Then User sees the list screen page
    And User reopens app
    And User sees the list screen page


  Scenario: Login doesn't work with bad credentials
    Given User enters username "uitest@the-list-shop.com"
    And User enters password "gobbledygook"
    And User clicks on the submit button
    Then User sees the signin page
    And User sees error message



