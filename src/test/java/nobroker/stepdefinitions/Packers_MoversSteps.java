 package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import nobroker.pages.Packers_MoversPage;
import nobroker.utils.Base;

public class Packers_MoversSteps {

	WebDriver driver = Hooks.driver;
	Packers_MoversPage moversPage;

	public Packers_MoversSteps() {
		moversPage = new Packers_MoversPage(driver);
	}

	@Given("User opens the menu on Home page for packers and movers")
	public void openMenu_Packers() {
		boolean opened = moversPage.openMenu();
		Assert.assertTrue(opened, "Home menu not opened");
		Base.sleep(1000);
	}

	@When("User selects packers and movers service")
	public void select_packers_movers() {
		boolean selected = moversPage.selectPackersMovers();
		Assert.assertTrue(selected, "Packers and Movers not selected");
		Base.sleep(1000);
	}

	@When("User clicks on within city")
	public void click_within_city() {

		boolean clicked = moversPage.clickWithinCity();
		Assert.assertTrue(clicked, "Within City not clicked");
		Base.sleep(1000);

	}

	@When("User enters the city name")
	public void enter_city_name() {
		boolean entered = moversPage.enterCity();
		Assert.assertTrue(entered, "City not entered");
		Base.sleep(1000);
	}

	@When("User enter the source city")
	public void enter_source() {
		moversPage.enterSource("Villivakkam");
		Base.sleep(1000);
	}

	@When("User enter the destination city and click check price")
	public void enter_destination() {
		moversPage.enterDestination("Guindy");
		Base.sleep(1000);
	}

	@When("User enters the city name for city tempo")
	public void enter_city_tempo() {
		boolean entered = moversPage.enterCityDemo();
		Assert.assertTrue(entered, "City not entered");

	}

	@When("User enter the source city for city tempo")
	public void enter_source_tempo() {
		moversPage.enterSourcecityDemo("Villivakkam");
		Base.sleep(1000);
	}

	@When("User enter the destination city for city tempo and click check price")
	public void user_enter_the_destination_city_for_city_tempo_and_click_check_price() {
		moversPage.enterDestinationCitydemo("Guindy");
		Base.sleep(1000);
	}

	/*
	 * @When("User remove the item that was already added") public void
	 * navigate_remove_items() {
	 * 
	 * boolean closeBtn = moversPage.removeItemThatAdded();
	 * Assert.assertTrue(closeBtn, "Remove adding the item and click close");
	 * Base.sleep(1000);
	 * 
	 * }
	 */

	@When("User navigate to the add to inventory page")
	public void navigate_inventory_page() {

		/*
		 * boolean clicked = moversPage.navigateToInventoryWithoutAdding(); boolean
		 * close = moversPage.removeItemThatAdded(); Assert.assertTrue(clicked,
		 * "without adding the item and click continue"); Base.sleep(1000);
		 */}

	@When("User navigate without add the item and click continue")
	public void navigate_without_items() {
		/*
		 * 
		 * boolean continueBtn = moversPage.clickContinueWithoutAdd();
		 * Assert.assertTrue(continueBtn, "without adding the item and click continue");
		 * Base.sleep(1000);
		 */
	}

	@When("User verifies the alert message for not add item")
	public void verify_alert_message() {

		/*
		 * boolean alert = moversPage.isAlertPresent(); Assert.assertTrue(alert,
		 * "Expected an alert but none displayed!");
		 * 
		 * if (alert) { String msg = moversPage.getAlertMessage();
		 * System.out.println("Alert text: " + msg); // You can also add Assert here
		 * forexpected text Assert.assertEquals(msg.trim(),
		 * "Please add items to calculate your quotation");
		 * 
		 * }
		 */

	}

	@When("User add the items and verify the added items and click continue")
	public void add_items() {

		boolean added = moversPage.addItems();
		Assert.assertTrue(added, "Items not added");
		Base.sleep(1000);

	}

	@When("User clicks on city tempo")
	public void user_clicks_on_city_tempo() {
		boolean clicked = moversPage.clickCityTempo();
		Assert.assertTrue(clicked, "Within City not clicked");
		Base.sleep(1000);
	}

	@When("User add the vehicle and verify the added vehicle and click continue")
	public void user_add_the_vehicle_and_verify_the_added_vehicle_and_click_continue() {
		boolean schedule = moversPage.addVehicle();
		Assert.assertTrue(schedule, "Schedule not clicked");
		Base.sleep(1000);
	}

	@Then("Packers and movers service verified")
	public void verify_packers_movers_service() {
		System.out.println("Packers & Movers flow verified successfully!");
	}
}