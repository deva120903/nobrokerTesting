package nobroker.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import nobroker.pages.LoginPage;
import nobroker.utils.Base;

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

    @Before("@Search")
    public void loginBeforeSearch() {
        LoginPage loginPage = new LoginPage(driver, Hooks.extTest);
        driver.get("https://www.nobroker.in/");

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8778114144");
        loginPage.clickContinue();

        // Enter OTP manually in console
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();
        
    }

    @After
    public void tearDown() {
        Base.sleep();
        driver.quit();
    }
}
