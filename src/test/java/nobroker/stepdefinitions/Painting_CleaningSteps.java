package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import nobroker.pages.LoginPage;
import nobroker.pages.Painting_CleaningPage;
import nobroker.utils.Base;

public class Painting_CleaningSteps {

    WebDriver driver = Hooks.driver;
    Painting_CleaningPage paintingPage;

    public Painting_CleaningSteps() {
        paintingPage = new Painting_CleaningPage(driver);
    }

    @Given("User opens the menu on Home page")
    public void open_home_menu() {
        boolean opened = paintingPage.openHomeMenu();
        Assert.assertTrue(opened, "Home menu not opened");
        Base.sleep(1000); // wait 1 second for menu animation
    }

    @When("User selects Painting and Cleaning service")
    public void select_painting_cleaning_service() {
        boolean clicked = paintingPage.selectPaintingCleaningService();
        Assert.assertTrue(clicked, "Painting and Cleaning service not selected");
        Base.sleep(1000); // wait for page load
    }

    @When("User clicks on Home Cleaning")
    public void click_home_cleaning() {
		
		  boolean clicked = paintingPage.clickHomeCleaning();
		  Assert.assertTrue(clicked, "Home Cleaning not clicked"); Base.sleep(1000); //wait for submenu to expand
		 
    	}

    @When("User selects Full Home Cleaning")
    public void select_full_home_cleaning() {
		
		  boolean selected = paintingPage.selectFullHomeCleaning();
		  Assert.assertTrue(selected, "Full Home Cleaning not selected");
		  Base.sleep(1000); // wait for page/modal to load
		     }

    @Then("Full Home Cleaning page should be visible")
    public void verify_full_home_cleaning_page() {
		
		  boolean visible = paintingPage.isFullHomeCleaningPageVisible();
		  Assert.assertTrue(visible, "Full Home Cleaning page not visible");
		  Base.sleep(500);
		 
    }

    @When("User selects Furnished Apartment")
    public void select_furnished_apartment() {
		
		  boolean selected = paintingPage.selectFurnishedApartment();
		  Assert.assertTrue(selected, "Furnished Apartment not selected");
		  Base.sleep(1000); // wait for item list/modal
		     }

    @When("User adds all available items")
    public void add_all_available_items() {
		
		  boolean added = paintingPage.addAllItems(); Assert.assertTrue(added,
		  "Failed to add items"); Base.sleep(1000);
		 // wait for add animation/modal update
    }

    @Then("All selected items should be added successfully")
    public void verify_all_items_added() {
		
		  boolean verified = paintingPage.verifyItemsAdded();
		  Assert.assertTrue(verified, "Items not added correctly"); Base.sleep(500);
		 
    }

    @When("User removes some items")
    public void remove_some_items() {
		
		  boolean removed = paintingPage.removeSomeItems(); Assert.assertTrue(removed,
		  "Failed to remove items"); Base.sleep(1000); // wait for remove animation/modal update
		     }

    @Then("Removed items should be updated successfully")
    public void verify_removed_items() {
		
		  boolean verified = paintingPage.verifyItemsRemoved();
		  Assert.assertTrue(verified, "Items not removed correctly"); Base.sleep(500);
		 
    }
    
    @When("User clicks on painting")
    public void user_clicks_on_painting() {
		
		  boolean selected = paintingPage.clickPainting(); Assert.assertTrue(selected,
		  "Painting not selected"); Base.sleep(1000);
		 
        
    }

    @When("User selects interior painting")
    public void user_selects_interior_painting() {
		
		  boolean selected = paintingPage.isInteriorPainting();
		  Assert.assertTrue(selected, "Interior painting not selected");
		  Base.sleep(1000);
		 
    }

    @When("User selects exterior painting")
    public void user_selects_exterior_painting() {
		
		  boolean selected = paintingPage.isExteriorPainting();
		  Assert.assertTrue(selected, "Exterior painting not selected");
		  Base.sleep(1000);
		 
    }

    @Then("painting page should be visible")
    public void painting_page_should_be_visible() {
		
		  boolean selected = paintingPage.verifyPaintingPage();
		  Assert.assertTrue(selected, "Exterior painting not verified");
		  Base.sleep(1000);
		 
    }
    
    @When("User enter invalid data and clicks the Search button")
    public void user_enter_invalid_data_and_clicks_the_search_button() {
		paintingPage.isInvalidData("XYZ1234");

    }

    @Then("System should prevent invalid search action")
    public void system_should_prevent_invalid_search_action() {
    	boolean selected = paintingPage.preventSearch();
		 Assert.assertTrue(selected, "Prevention of invalid search");
		  Base.sleep(1000);
    }

    @When("User wants to change the menu in the same page in action")
    public void user_wants_to_change_the_menu_in_the_same_page_in_action() {
    	boolean selected = paintingPage.changeMenu();
		 Assert.assertTrue(selected, "Not navigate to other menu in one action");
		  Base.sleep(1000);
    }

    @Then("User can not access the menu")
    public void user_can_not_access_the_menu() {
    	boolean selected = paintingPage.validateAccessMenu();
		 Assert.assertTrue(selected, "Access denied to navigate to other menu in one action");
		  Base.sleep(1000);
    }

}
