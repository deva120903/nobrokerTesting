package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.*;
import nobroker.pages.Search;
import nobroker.stepdefinitions.Hooks;

public class SearchSteps {

    WebDriver driver = Hooks.getDriver();
    ExtentTest extTest = Hooks.extTest;
    Search searchPage;

    public SearchSteps() {
        searchPage = new Search(driver, extTest);
    }

    
    // ---------- Select City ----------
    @Given("the user selects Chennai as location")
    public void the_user_selects_chennai_as_location() {
        searchPage.selectCity("Chennai");
    }

    @Given("the user selects Mumbai as location")
    public void the_user_selects_mumbai_as_location() {
        searchPage.selectCity("Mumbai");
    }

    // ---------- Enter Landmark ----------
    @When("the user enters Velachery as landmark")
    public void the_user_enters_velachery_as_landmark() {
        searchPage.enterLocality("Velachery");
    }

    @When("the user leaves the landmark blank")
    public void the_user_leaves_the_landmark_blank() {
        searchPage.leaveLandmarkBlank();
    }

    // ---------- Click Search ----------
    @And("the user clicks on search button")
    public void the_user_clicks_on_search_button() {
        searchPage.clickSearchButton();
    }

    // ---------- Alert Verification ----------
    @Then("an alert message should be displayed")
    public void an_alert_message_should_be_displayed() {
          boolean alert = searchPage.isAlertPresent();
          Assert.assertTrue(alert, "Expected an alert but none displayed!");
          if (alert) {
              String msg = searchPage.getAlertMessage();
             System.out.println("Alert text: " + msg);
         }
    }

    // ---------- Properties Page Verification ----------
    @Then("the properties page should be displayed")
    public void the_properties_page_should_be_displayed() {
        boolean loaded = searchPage.isPropertiesPageLoaded();
        Assert.assertTrue(loaded, "Properties page did not load!");
    }
}
