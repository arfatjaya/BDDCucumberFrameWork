package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");

		if(driver == null)
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\samqu\\Downloads\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		}
		 return driver;
	}

}
