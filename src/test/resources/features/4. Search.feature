Feature: Home Page Search and Navigation
  This feature tests different scenarios for the NoBroker search functionality.

  @Login
  Scenario: Missing landmark
    Given the user selects Chennai as location
    When the user leaves the landmark blank
    And the user clicks on search button
    Then an alert message should be displayed

  @Login
  Scenario: Mismatch location–landmark combination
    Given the user selects Mumbai as location
    When the user enters Velachery as landmark
    And the user clicks on search button
    Then an alert message should be displayed

  @Login
  Scenario: Valid city with landmark
    Given the user selects Chennai as location
    When the user enters Velachery as landmark
    And the user clicks on search button
    Then the properties page should be displayed
