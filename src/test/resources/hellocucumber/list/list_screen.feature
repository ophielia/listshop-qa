@loggedinuser
Feature: List Screen Tests
  Tests for list screen. This feature tests the navigation.

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
    Given User swipes through all lists
    Then User should have seen at least 4 lists

  Scenario: Legend view can be displayed when available
    Given User navigates to shopping list "King Soopers"
    And User reveals legend view
    Then User should see legend view

  Scenario: Legend view not available for lists without sources
    Given User navigates to shopping list "Ace Hardware"
    Then User should not see legend handle

  Scenario: User with only one list cannot navigate lists
    Given User logs out
    And User creates new account
    And User is on list page for list "Shopping List"
    When User swipes through all lists
    And User should have seen exactly 1 list




