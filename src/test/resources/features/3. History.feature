Feature: Verify History Page Functionality

 @Login
  Scenario: User views recent services in History
    Given User clicks on History tab
    And User selects a service from the history list
    Then Relevant service details are displayed
    And exit from the history view
