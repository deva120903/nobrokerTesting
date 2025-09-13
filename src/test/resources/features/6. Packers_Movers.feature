Feature: Verify the Packers & Movers page Functionality

  @Login1
  Scenario: TS_PACKER_14 User navigates and manages in Packers and Movers for move items from one place to another
    Given User opens the menu on Home page for packers and movers
    When User selects packers and movers service
    And User clicks on within city
    And User enters the city name
    And User enter the source city
    And User enter the destination city and click check price
    And User navigate to the add to inventory page
    And User navigate without add the item and click continue
    And User verifies the alert message for not add item
    And User add the items and verify the added items and click continue
    Then Packers and movers service verified
    
    @Login
    Scenario: TS_PACKER_15  User navigates and manages in Packers and Movers for city tempo to move from one place to another
    Given User opens the menu on Home page for packers and movers
    When User selects packers and movers service
    And User clicks on city tempo
    And User enters the city name for city tempo
    And User enter the source city for city tempo
    And User enter the destination city for city tempo and click check price
    And User add the vehicle and verify the added vehicle and click continue
    Then Packers and movers service verified