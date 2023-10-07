package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	By CountryDropDown = By.xpath("//div[@class='wrapperTwo']//div//select");
	
	
	By cheeckbox = By.xpath("//input[@type='checkbox']");
	 
	By Proceed = By.xpath("//button[normalize-space()='Proceed']");
	
	
	
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public void   PlaceOrderConfirm() throws InterruptedException
	{
		  driver.findElement(placeOrder).click();
		   Thread.sleep(6000);
	}
	public void    ClickCountryDropDown() throws InterruptedException
	{
		  driver.findElement(CountryDropDown).click();
		  Thread.sleep(6000);
	}
	public void selectCountryByName(String countryName) {
        By dynamicCountryLocator = By.xpath("//option[@value='" + countryName + "']");
        WebElement countryOption = driver.findElement(dynamicCountryLocator);
        countryOption.click();
    }
	public void Agre()
	 {
		 
		 driver.findElement(cheeckbox).click();
		 
	 }
	
	public void ClickProceed()
	 {
		 
		 driver.findElement(Proceed).click();
		 
	 }
	
	
}
