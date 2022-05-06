@loggedinuser
Feature: List Management Tests
  Tests for managing lists.

  Background:
    Given Default user is logged in

  Scenario: User sees lists when on list management page
    Given User navigates to list management page
    Then User sees at least 1 list

  Scenario: User can add a list
    Given User navigates to list management page
    When User adds a list
    Then User sees an additional list
    And One of the lists is called "Shopping List"

  Scenario: User can change the list name - adding to existing
    Given User navigates to list management page
    When User adds " welcome" to list named "Shopping List"
    Then User no longer sees list "Shopping List"
    And One of the lists is called "Shopping List Welcome"

  Scenario: User can change the list name - replacing existing
    Given User navigates to list management page
    When User adds a list
    And User changes name of "Shopping List" to "Dream List"
    Then User no longer sees list "Shopping List"
    And One of the lists is called "Dream List"

  Scenario: User can remove a list
    Given User navigates to list management page
    When User removes list "Dream List"
    Then User no longer sees list "Dream List"
    And User sees 1 fewer lists

  Scenario: User can navigate to List Screen by tapping on list name
    Given User navigates to list management page
    When User selects list "Costco"
    Then User is on list page for list "Costco"



