@anonymoususer
Feature: Logging In Tests
  Good credentials work.  Bad credentials don't. Or, we can skip the login completely.

  Scenario: Login works with the right credentials
    Given User navigates to sign in page
    When User enters username "uitest@the-list-shop.com"
    And User enters password "passw0rd"
    And User clicks on the submit button
    Then User sees the list screen page


  Scenario: Logged in user remains logged in when reopening app
    Given User navigates to sign in page
    When User enters username "uitest@the-list-shop.com"
    And User enters password "passw0rd"
    And User clicks on the submit button
    Then User sees the list screen page
    And User reopens app
    And User sees the list screen page


  Scenario: Login doesn't work with bad credentials
    Given User navigates to sign in page
    When User enters username "uitest@the-list-shop.com"
    And User enters password "gobbledygook"
    And User clicks on the submit button
    Then User sees the signin page
    And User sees error message


  Scenario: User can skip it all and go to list page
    Given User is on choice page
    When User clicks on the skip login button
    Then User sees the list screen page

