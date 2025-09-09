Feature: NoBroker Help Center

  @Login
  Scenario: Open Help Center and raise a complaint
    Given Login page is loaded and Help link is visible
    When User clicks on Help Center button
    And User selects Carpentry service
    And User selects Invoice issue
    Then User closes the Help Center panel
