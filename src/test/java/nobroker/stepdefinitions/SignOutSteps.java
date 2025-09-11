package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nobroker.pages.Packers_MoversPage;
import nobroker.pages.SignOutPage;
import nobroker.utils.Base;

public class SignOutSteps {

	WebDriver driver = Hooks.driver;
	SignOutPage signout;

	public SignOutSteps() {
		signout = new SignOutPage(driver);
	}
	
	@Given("User in the final stage")
	public void user_in_the_final_stage() {
		boolean verify = signout.userFinal();
		Assert.assertTrue(verify, "Final stage not opened");
		Base.sleep(1000);
	}
	@When("User click on sign out")
	public void user_click_on_sign_out() {
		boolean selected = signout.clickSignOut();
		Assert.assertTrue(selected, "Sign out not selected");
		Base.sleep(1000);
	}
	@Then("User end all the process on the website")
	public void user_end_all_the_process_on_the_website() {
		boolean verified = signout.verifySignout();
		Assert.assertTrue(verified, "Not signed out are not verified");
		Base.sleep(1000);
	}

	
}
