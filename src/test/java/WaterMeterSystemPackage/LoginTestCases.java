package WaterMeterSystemPackage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//WATER METER SYSTEM PROJECT SCRIPT OF LOGIN PAGE 
public class LoginTestCases 
{
    private WebDriver avdriver;

    @BeforeTest
	public void browserLauch() throws InterruptedException 
	{ 	
    	
    	ChromeDriver avdriver=new ChromeDriver();
		avdriver.manage().window().maximize();			
		avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
		Thread.sleep(3000);	
	}
	
    @DataProvider(name = "loginData")
    public Object[][] loginData() 
    {
        return new Object[][] 
        {
            {"validUser ", "validPassword", true}, // Valid credentials
            {"invalidUser ", "invalidPassword", false}, // Invalid credentials
            {"", "", false}, // Empty credentials
            {"validUser ", "", false}, // Missing password
            {"", "validPassword", false} // Missing username
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password ) throws InterruptedException 
    {
        
    	// Locate the username and password fields and the login button
        WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
    
        WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
          
        Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
		//myZone.selectByVisibleText("(300) Central Zone");
		Thread.sleep(2000);
        
        Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
        //ConnType.selectByVisibleText("Zone");
		Thread.sleep(2000);
        		       
        WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
        Thread.sleep(3000);

        // Clear fields and enter credentials
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("ajay");
        passwordField.sendKeys("Ajay123");
        myZone.selectByVisibleText("(300) Central Zone");
        ConnType.selectByVisibleText("Zone");
        loginButton.click();
        
        System.out.println("User Login Success");
        /*
        // Check the result
        if (expectedResult) 
        {
            // Assuming successful login redirects to a dashboard
            String expectedUrl = "http://10.11.1.13:5050/home/dashboard"; // Replace with actual URL
            Assert.assertEquals(avdriver.getCurrentUrl(), expectedUrl, "Login should be successful.");
        }
        else
        {
            // Assuming unsuccessful login shows an error message
            WebElement errorMessage = avdriver.findElement(By.id("errorMessage")); // Replace with actual ID
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed.");
        }  */
    }

    @AfterClass
    public void tearDown() 
    {
       // Close the browser
       if (avdriver != null) 
       {
            avdriver.quit();
       }
    }
}
