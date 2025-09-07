package nobroker.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src\\test\\resources\\features\\login.feature",
	glue="nobroker.stepdefinitions",
	plugin= {"pretty","html:reports/cucumber-html-report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
