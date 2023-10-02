package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
By search=By.xpath("//input[@type='search']");

//By productName=By.xpath("//h4[normalize-space()='Tomato - 1 Kg']");
By productName = By.cssSelector("h4.product-name");
//By productName = By.cssSelector("h4[class='product-name']");
 
By TopDeals=By.linkText("Top Deals");
By increment=   By.cssSelector("a.increment");
By addToCart = By.cssSelector(".product-action button");

public void SearchItem(String name)
{
	 driver.findElement(search).sendKeys(name);
}

public String getProductName()
{
	  return driver.findElement(productName).getText();
}

public void SelectTopDeals()
{
	   driver.findElement(TopDeals).click();
}
public String getTitleLandingPage()
{
	return driver.getTitle();
}
public void incrementQuantity(int quantity)
{
	int i = quantity-1;
	while(i>0)
	{
		driver.findElement(increment).click();
		i--;
	}
	
}
public void addToCart()
{
	driver.findElement(addToCart).click();
}




}
