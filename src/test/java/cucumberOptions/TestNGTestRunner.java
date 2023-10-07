package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome=true,
tags="@PlaceOrder    ",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner  extends AbstractTestNGCucumberTests{

	
	@Override  // Overrides the scenarios() method from the superclass
	@DataProvider(parallel=true) // Specifies that this method provides data for the tests and enables parallel execution
	public Object[][] scenarios()
	{
		return super.scenarios();// Returns the scenarios provided by the superclass
	}
}
