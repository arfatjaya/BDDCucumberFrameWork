package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObject.PageObejeManager;

public class TestSetup {
	 public WebDriver driver;
	    public String landingPageProductName;
	    public PageObejeManager pageObejeManager;
	    public TestBase testBase;
	    public GenericUtils genericUtils;

	    public TestSetup() throws InterruptedException, IOException {
	        testBase = new TestBase();
	        driver = testBase.WebDriverManager();
	        pageObejeManager = new PageObejeManager(driver);
	        genericUtils = new GenericUtils(driver);
	    }

}//
