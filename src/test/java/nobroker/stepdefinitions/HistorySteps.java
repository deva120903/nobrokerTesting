package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nobroker.pages.HistoryPage;
import nobroker.utils.Base;

public class HistorySteps {

    WebDriver driver = Hooks.driver;
    HistoryPage historyPage;

    public HistorySteps() {
        historyPage = new HistoryPage(driver);
    }

    @When("User clicks on History tab")
    public void user_clicks_on_history_tab() {
        boolean clicked = historyPage.clickHistoryTab();
        Assert.assertTrue(clicked, "Failed to click on History tab");
        Base.sleep();
    }

    @And("User selects a service from the history list")
    public void user_selects_service_from_history() {
        boolean selected = historyPage.selectServiceFromHistory();
        Assert.assertTrue(selected, "Failed to select service from history list");
        Base.sleep();
    }

    @Then("Relevant service details are displayed")
    public void relevant_service_details_displayed() {
        boolean detailsVisible = historyPage.areServiceDetailsVisible();
        Assert.assertTrue(detailsVisible, "Service details are not displayed");
    }

    @And("exit from the history view")
    public void exit_from_history_view() {
        boolean exited = historyPage.closeHistoryView();
        Assert.assertTrue(exited, "Failed to exit from the history view");
        Base.sleep();
    }
}
