package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",monochrome=true,
tags="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestRunner  extends AbstractTestNGCucumberTests{

	
	@Override  // Overrides the scenarios() method from the superclass
	@DataProvider(parallel=true) // Specifies that this method provides data for the tests and enables parallel execution
	public Object[][] scenarios()
	{
		return super.scenarios();// Returns the scenarios provided by the superclass
	}
}
//-----------------arfatjaya