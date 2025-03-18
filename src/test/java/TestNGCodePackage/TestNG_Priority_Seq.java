package TestNGCodePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;			
import org.testng.annotations.Test;			

public class TestNG_Priority_Seq
{		
		WebDriver  ajdriver ;			

	    // Method 1: Open Brower say CHROME			
		@Test (priority=1)	   
		public void openBrowser() throws InterruptedException 
		{				
	    	ChromeDriver ajDriver= new ChromeDriver();
			ajDriver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("Browser Opened");
	    }		

	    // Method 2: Launch Google.com			
		@Test (priority=2)	
	    public void launchGoogle() 
	    {				
	        ajdriver.get("http://www.google.co.in");
	        System.out.println("Google Url Get");
	        
	    }		
        
	    // Method 3: Perform a search using "Facebook"			
		@Test (priority=3)
	    public void peformSeachAndClick1stLink()
	    {				
	        ajdriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Facebook");		
	        System.out.println("Searching facebook");
	    }		

	    // Method 4: Verify Google search page title.			
		@Test (priority=4)		
	    public void FaceBookPageTitleVerification() throws InterruptedException 
	    {				
	        ajdriver.findElement(By.xpath("//textarea[@id='APjFqb']")).click();						
	        Thread.sleep(3000);		
	        Assert.assertEquals(ajdriver.getTitle().contains("Facebook - Google Search"), true);				
	    }		
	}	