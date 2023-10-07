package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObject.CheckoutPage;
import utils.TestSetup;

public class CheckoutPageStepDefinition {

public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
public CheckoutPage checkoutPage;
TestSetup testSetup;
//Spring framework, EJB, s
//SRP
//
public CheckoutPageStepDefinition(TestSetup testSetup)
{
	this.testSetup=testSetup;
	this.checkoutPage = testSetup.pageObejeManager.getCheckoutPage();
}


@Then("verify user has ability to enter promo code and place the order")
public void  verify_user_has_ability_enter_promo() throws InterruptedException
{
	
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	testSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Thread.sleep(6000);
	
	checkoutPage.PlaceOrderConfirm();
	 
	
	
	
}

@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout(String name) throws InterruptedException
{
	
	checkoutPage.CheckoutItems();
	Thread.sleep(3000);
	//Assertion to extract name from screen and compare with name
}



@Then("User select country {string} and agree terms and condition and proceed")
public void user_select_country_and_agree_terms_and_condition_and_proceed(String CountryName) throws InterruptedException {
	checkoutPage.ClickCountryDropDown();
	
	Thread.sleep(3000);
	checkoutPage.selectCountryByName(CountryName);
	Thread.sleep(4000);
	checkoutPage.Agre();
	Thread.sleep(4000);
	
	checkoutPage.ClickProceed();
}

}
