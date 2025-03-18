package OOPS;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest 
{
   //private WebDriver driver;
   
    WebDriver driver =new ChromeDriver();
	
    @BeforeTest
	public void beforeTest() 
	{	
    	driver = new ChromeDriver();  
	}
         
  @Test
  public void testEasy() throws InterruptedException 
  {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
	}	
  
			
	@AfterTest
	public void afterTest() 
	{
		NewTest pgttl=new NewTest();
		
		System.out.println("Project Title is == " );
		driver.quit();
	}		
}	

// TestNG Annotation Sequences
	/*@BeforeSuite
		@BeforeTest
		 	@BeforeClass
		  		@BeforeMethod
					@Test
				@AfterMethod
			@AfterClass
		@AfterTest
	 @AfterSuite
	*/