Feature: Home Page Search and Navigation
  This feature tests different scenarios for the NoBroker search functionality.

  @Login
  Scenario: TS_SEARCH_08 Missing landmark
    Given the user selects Chennai as location
    When the user leaves the landmark blank
    And the user clicks on search button
    Then an alert message should be displayed

  @Login1
  Scenario: TS_SEARCH_09 Mismatch location–landmark combination
    Given the user selects Mumbai as location
    When the user enters Velachery as landmark
    And the user clicks on search button
    Then an alert message should be displayed

  @Login1
  Scenario: TS_SEARCH_10 Valid city with landmark
    Given the user selects Chennai as location
    When the user enters Velachery as landmark
    And the user clicks on search button
    Then the properties page should be displayed
