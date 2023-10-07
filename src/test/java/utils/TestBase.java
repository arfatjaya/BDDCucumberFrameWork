// Importing necessary libraries
package utils;

import java.io.FileInputStream; // Input stream for reading files
import java.io.IOException; // Exception for IO operations
import java.time.Duration; // Duration class for timeouts
import java.util.Properties; // Properties class to manage application properties
import java.util.concurrent.TimeUnit; // TimeUnit class for managing time units

import org.openqa.selenium.WebDriver; // Selenium WebDriver for browser automation
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for Chrome browser automation

// Declaring a class named TestBase
public class TestBase 
{
    public WebDriver driver; // Declaring a WebDriver object

    // Method to manage WebDriver configuration and return the initialized WebDriver instance
    public WebDriver WebDriverManager() throws InterruptedException, IOException {
        
        // Reading global properties file using FileInputStream
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties(); // Creating Properties object to store key-value pairs
        prop.load(fis); // Loading properties from the file
        
        // Retrieving URL and browser properties from the properties file
        String url = prop.getProperty("QAUrl"); // Getting QA URL from properties
        String browser_properties = prop.getProperty("browser"); // Getting browser type from properties
        String browser_maven=System.getProperty("browser"); // Getting browser type from system properties (Maven)

        // Checking if the driver instance is null
        if(driver == null) {
            // Checking if the browser property is set to Chrome
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                // Setting ChromeDriver path and initializing ChromeDriver
                System.setProperty("webdriver.chrome.driver","C:\\Users\\samqu\\Downloads\\chromedriver\\chromedriver.exe");
                driver = new ChromeDriver(); // Initializing ChromeDriver
            }
            
            // Setting implicit wait time for WebDriver operations to 5 seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
            driver.get(url); // Navigating the browser to the specified URL
            driver.manage().window().maximize(); // Maximizing the browser window
        }
        
        return driver; // Returning the initialized WebDriver instance
    }
}
