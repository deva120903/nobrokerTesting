Feature: NoBroker Help Center Complaint Flow

  Scenario: Open Help Center and raise a complaint
    When User clicks on Help Center button
    And User selects "Carpentry" service
    And User selects complaint issue "Quality"
    Then User closes the Help Center panel