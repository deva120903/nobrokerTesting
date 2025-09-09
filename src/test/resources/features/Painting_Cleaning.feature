Feature: Verify the Painting & Cleaning page Functionality

  @Login
  Scenario: User navigates and manages items in Full Home Cleaning for Furnished Apartment
    Given User opens the menu on Home page
    When User selects Painting and Cleaning service
    And User clicks on Home Cleaning
    And User selects Full Home Cleaning
    Then Full Home Cleaning page should be visible

    When User selects Furnished Apartment
    And User adds all available items
    Then All selected items should be added successfully

    When User removes some items
    Then Removed items should be updated successfully

   @Login
   Scenario: User navigates and manages items in Interior and Exterior painting 
    Given User opens the menu on Home page
    When User selects Painting and Cleaning service
    And User clicks on painting
    And User selects interior painting 
    And User selects exterior painting
    Then painting page should be visible