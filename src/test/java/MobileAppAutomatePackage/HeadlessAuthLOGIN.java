package MobileAppAutomatePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessAuthLOGIN 
{
	    public static void main(String[] args) throws InterruptedException 
	    {
	        // Set up ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

				        
	        // Set Chrome options for headless mode
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080");

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver(options);

	        try 
	        {
	            // Navigate to the login page
	            driver.get("https://example.com/login");

	            // Locate username and password fields
	            WebElement usernameField = driver.findElement(By.id("username"));
	            WebElement passwordField = driver.findElement(By.id("password"));

	            // Input credentials
	            usernameField.sendKeys("99999");
	            passwordField.sendKeys("12345678");

	            // Submit login form
	            WebElement loginButton = driver.findElement(By.id("loginButton"));
	            loginButton.click();

	            // Check if authentication was successful
	            String pageSource = driver.getPageSource();
	            if (pageSource.contains("Welcome")) 
	            {
	                System.out.println("Authentication Successful!");
	            }
	            else
	            {
	                System.out.println("Authentication Failed.");
	            }
	        }
	        finally 
	        {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}
