package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.TestSetup;

public class Hooks {
	TestSetup testSetup;
	public Hooks(TestSetup testSetup)
	{
		
		this.testSetup = testSetup;
	}
	
	
	@After
	public void AfterScenario() throws InterruptedException, IOException  
	{
		
		testSetup.testBase.WebDriverManager().quit();
		
	}
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException, InterruptedException
	{
		WebDriver driver =testSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
		
	}

}
