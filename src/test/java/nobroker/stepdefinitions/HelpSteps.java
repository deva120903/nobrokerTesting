package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nobroker.pages.HelpCenterPage;
import nobroker.utils.Base;

public class HelpSteps {

    WebDriver driver = Hooks.driver;
    HelpCenterPage helpCentrePage;

    public HelpSteps() {
        helpCentrePage = new HelpCenterPage(driver);
    }

    @Given("Login page is loaded and Help link is visible")
    public void login_page_is_loaded_and_help_link_visible() {
        boolean isHelpVisible = helpCentrePage.isHelpCenterVisible();
        Assert.assertTrue(isHelpVisible, "Help Center link is not visible on login page");
    }

    @When("User clicks on Help Center button")
    public void user_clicks_on_help_center_button() {
        boolean clicked = helpCentrePage.clickHelpCenter();
        Assert.assertTrue(clicked, "Failed to click on Help Center button");
        Base.sleep();
    }

    @And("User selects Carpentry service")
    public void user_selects_carpentry_service() {
        boolean selected = helpCentrePage.selectService();
        Assert.assertTrue(selected, "Failed to select Carpentry service");
        Base.sleep();
    }

    @And("User selects Invoice issue")
    public void user_selects_invoice_issue() {
        boolean selected = helpCentrePage.selectIssue();
        Assert.assertTrue(selected, "Failed to select Invoice issue");
        Base.sleep();
    }

    @Then("User closes the Help Center panel")
    public void user_closes_the_help_center_panel() {
        boolean closed = helpCentrePage.closeHelpCenterPanel();
        Assert.assertTrue(closed, "Failed to close Help Center panel");
        Base.sleep();
    }
}
