package MobileAppAutomatePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ViewRegisterComplete 
{
	AndroidDriver driver;
	@Test
	public void myview() throws InterruptedException 
	{
	  System.out.println("FUNCTION CALLED SUCCESSFULLY");
	  
	  WebElement arrow1 = driver.findElement(By.className("android.widget.ImageButton"));
	  arrow1.click();
	  Thread.sleep(2000);
	  
	  WebElement arrow2 = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
	  arrow2.click();
	  Thread.sleep(2000);
	
	}
}
