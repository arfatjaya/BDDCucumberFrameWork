package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.security.PublicKey;
import java.util.Iterator;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import pageObject.OfferPage;
import pageObject.PageObejeManager;
import utils.TestSetup;

import java.util.Set;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class OfferPageStepDefinition {
	
	 WebDriver driver;
	 TestSetup testSetup;
	 public String LandingPageproductName;
	 public String offerpageproductName;
	 
	 PageObejeManager pageObejeManager;
	 
	 public OfferPageStepDefinition(TestSetup testSetup) {
		 this.testSetup=testSetup;
	}

@Then("^User search for (.+) shortname in offers page to chek if product is exist$")
public void user_search_for_same_shortname_in_offers_page_to_chek_if_product_is_exist(String ShortName) throws InterruptedException {
	SwitchToOfferPage();
	
	OfferPage offerPage=new OfferPage(testSetup.driver);
	offerPage.SearchItem(ShortName);
	Thread.sleep(2000);
	 offerpageproductName=offerPage.getProductName();
	
	
	
	
	
}
public void SwitchToOfferPage() {
	 
	LandingPage landingPage=testSetup.pageObejeManager.getLandingPage();
	landingPage.SelectTopDeals();
	testSetup.genericUtils.SwitchWindowToChild();

}
@Then("validating offer page and landing page product name")
public void validating_offer_page_and_landing_page_product_name() {
	testSetup.driver.quit();
   Assert.assertEquals(testSetup.landingPageProductName, offerpageproductName);
  
}

}
