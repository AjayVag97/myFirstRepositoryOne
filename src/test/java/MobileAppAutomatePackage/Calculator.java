package MobileAppAutomatePackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.*;

public class Calculator 
{
	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities MobCapabilities = new DesiredCapabilities();
		//UiAutomator2Options MobCapabilities = new UiAutomator2Options();
		
		MobCapabilities.setCapability("automationName", "uiautomator2");
		MobCapabilities.setCapability("platformNameVersion", "14.0.0"); 
		MobCapabilities.setCapability("deviceName","Pixel7Device");
		MobCapabilities.setCapability("platformName","Android");
		MobCapabilities.setCapability("appPackage", "com.google.android.calculator");
		MobCapabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	
		//Create RemoteWebDriver instance and connect to the Appium server
	 	//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), MobCapabilities);
	}

	
	@Test
	public void testCal() throws Exception 
	{
		System.out.println("METHOD CALLED SUCCESS");
	
	   //locate the Text on the calculator by using By.name()
	   WebElement two=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']"));
	   two.click();
	   
	   WebElement plus=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='plus']"));
	   plus.click();
	   
	   WebElement four=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='4']"));
	   four.click();
	   
	   WebElement equalTo=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']"));
	   equalTo.click();
	  
	   //locate the edit box of the calculator by using By.tagName()
	   WebElement results=driver.findElement(By.className("android.widget.TextView"));
		
	   //Check the calculated value on the edit box
	   assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
	 }

	@AfterClass
	public void teardown()
	{
		//close the app
		//driver.quit();
		System.out.println("CLOSE APP METHOD CALLED SUCCESS");
	}
	
}

