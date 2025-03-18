package PropertyTaxPackage;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class LoginTestNG
{
  
	SafariDriver avdriver =new SafariDriver();
	
	@BeforeTest
	public void browserLauch() throws InterruptedException 
	{ 	
		avdriver.manage().window().maximize();			
		avdriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);	
	}
	
	@Test(priority = 0)
	public void loginUser() throws InterruptedException 
	{		 
	  WebElement email = avdriver.findElement(By.id("txtEmail"));
	  email.sendKeys("nitin.borse@silvertouch.com");
	  Thread.sleep(1000);
		
	  WebElement psd = avdriver.findElement(By.id("txtPassword"));
	  psd.sendKeys("Nitin123");
						
	  avdriver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
	}
}

