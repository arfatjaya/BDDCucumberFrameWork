package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.Iterator;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import pageObject.PageObejeManager;
import utils.TestSetup;

import java.util.Set;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class LandingPageStepDefinition {
	
	 WebDriver driver;
	 
	 public String LandingPageproductName;
	 public String offerpageproductName;
	 TestSetup testSetup;
	 PageObejeManager pageObejeManager;
	 LandingPage landingPage;
	 public LandingPageStepDefinition(TestSetup testSetup) {
		 this.testSetup=testSetup;
		this.landingPage=testSetup.pageObejeManager.getLandingPage();
	}
@Given("User is on GreenCart landing page")
public void user_is_on_green_cart_landing_page() throws InterruptedException 
{ 
	Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));	
}
@When("^User search with short name (.+) and extracting actual name of product$")
public void user_search_with_short_name_and_extracting_actual_name_of_product(String ShortName) throws InterruptedException {
	 
	 Thread.sleep(3000);
	landingPage.SearchItem(ShortName);
	 Thread.sleep(3000);
	testSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	 Thread.sleep(3000);
	 
     
}
@When("Added {string} items of the selected product to cart")
public void Added_items_product(String quantity)
{
	
	landingPage.incrementQuantity(Integer.parseInt(quantity));
	landingPage.addToCart();
	
}


}
