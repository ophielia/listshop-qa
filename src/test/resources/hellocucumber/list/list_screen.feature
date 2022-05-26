@loggedinuser
Feature: List Screen Tests
  Tests for list screen.

  Background:
    Given Default user is logged in

  Scenario Outline: Logged in user can swipe through toolbars
    Given User navigates to toolbar "<toolbar>"
    Then Toolbar  "<toolbar>" should be displayed

    Examples:
      | toolbar      |
      | Add Item     |
      | Add Dish     |
      | Add List     |
      | Main Toolbar |


  Scenario: Logged in user can swipe from list to list


  Scenario: Logged in user can swipe through every list

  Scenario: Playground
    Given User navigates to list screen page

