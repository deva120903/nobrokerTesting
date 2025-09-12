package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.*;
import nobroker.pages.LoginPage;
import nobroker.utils.Base;
import nobroker.utils.Reporter;   // ✅ import your Reporter class

public class Hooks extends Base {

    static ExtentSparkReporter spark;
    static ExtentReports extReports;
    static ExtentTest extTest;
    
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    public static void beforeAll() {
        spark = new ExtentSparkReporter("report/ExtendsReport.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }

    @AfterAll
    public static void afterAll() {
        extReports.flush();
    }

    @Before
    public void setup(Scenario scenario) {
        launchBrowser();
        extTest = extReports.createTest(scenario.getName());
    }

    @Before("@Login")
    public void loginBeforeSearch() {
        LoginPage loginPage = new LoginPage(driver, Hooks.extTest);
        driver.get("https://www.nobroker.in/");

        loginPage.clickLogin();
        loginPage.enterMobileNumber("7094080503");
        loginPage.clickContinue();

        // Enter OTP manually in console
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();
    }

    @Before("@Login1")
    public void loginBeforeSearch1() {
        LoginPage loginPage = new LoginPage(driver, Hooks.extTest);
        driver.get("https://www.nobroker.in/");

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8778114144");
        loginPage.clickContinue();

        // Enter OTP manually in console
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();
    }

    // ✅ Add AfterStep for step-level reporting
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            // log FAIL with screenshot
            Reporter.generateReport(driver, extTest, Status.FAIL, "Step failed: " + scenario.getName());
        } else {
            // log PASS for each executed step
            Reporter.generateReport(driver, extTest, Status.PASS, "Step passed");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Final failure log in case of scenario failure
            Reporter.generateReport(driver, extTest, Status.FAIL, "Scenario failed: " + scenario.getName());
        }
        Base.sleep();
        driver.quit();
    }
}
