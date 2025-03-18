package MobileAppAutomatePackage;

import java.awt.Rectangle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Element;

import org.codehaus.groovy.runtime.memoize.EvictableCache.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.opentelemetry.context.Context;

public class EmployeeConnLogin 
{
	AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException
	{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities MobCapabilities = new DesiredCapabilities();
		//UiAutomator2Options MobCapabilities = new UiAutomator2Options();
		
		MobCapabilities.setCapability("automationName", "uiautomator2"); 
		MobCapabilities.setCapability("platformNameVersion", "14.0.0");  
		MobCapabilities.setCapability("deviceName","Pixel7Device");      
		MobCapabilities.setCapability("platformName","Android");        
		MobCapabilities.setCapability("appPackage", "in.smc.ec.beta");
		MobCapabilities.setCapability("appActivity","in.smc.employee_connect.module.Home.Activity.SplashGCMActivty"); // This is Launcher activity of your app (you can get it from apk info app)
	
		//Create RemoteWebDriver instance and connect to the Appium server
	 	//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), MobCapabilities);
		Thread.sleep(3000);
	}
	
		
		@Test(priority=1)
		public void AllowAccess() throws Exception 
		{	
			 try
			 {				
			   System.out.println("METHOD CALLED SUCCESS");
			
			   //locate the Text on the calculator by using By.name()
			   WebElement AcceptBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc.ec.beta:id/btnAccept']"));
			   AcceptBtn.click();
			   Thread.sleep(3000);
			   
			   WebElement UnderstnBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
			   UnderstnBtn.click();
			   Thread.sleep(3000);
			   
			   WebElement AccessTakePircturVideoBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']"));
			   AccessTakePircturVideoBtn.click(); 
			   Thread.sleep(3000); 
			   
			   WebElement AccessAllowDeviceLocBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']"));
			   AccessAllowDeviceLocBtn.click();
			   Thread.sleep(3000);
			   
			   WebElement AccessAllowNotificationBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']"));
			   AccessAllowNotificationBtn.click(); 
			   Thread.sleep(3000); 
			      
			   WebElement AccessAllowPhotVideoBtn=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_all_button']"));
			   AccessAllowPhotVideoBtn.click(); 
			   Thread.sleep(3000);   
			}
			catch(Exception e)
			{	
				 System.out.println("NOT FOUND PERMISSION OF APP STEPS");
			}
		}	
	
		@Test(priority=2)
		public void LoginEmployee() throws Exception 
		{
			System.out.println("LOGIN EMPLOYEE METHOD CALLED SUCCESS");
		
		   //locate the Text on the calculator by using By.name()
		   WebElement EmpID=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/et_empid']"));
		   EmpID.sendKeys("99999");
		   Thread.sleep(2000);
		   
		   WebElement EmpPSD=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/et_password']"));
		   EmpPSD.sendKeys("12345678");
		   Thread.sleep(2000);
		   
		   WebElement LoginCLK=driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc.ec.beta:id/button_login']"));
		   LoginCLK.click();
		   Thread.sleep(3000);	        
		}
		
		@Test(priority=3)
		public void RegisterNewComplaint() throws Exception 
		{			
			//Click on REGISTER NEW COMPLAINT button
			WebElement RegisterComplnCLK=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/txtService' and @text='Register Complaint']"));
			RegisterComplnCLK.click();
			Thread.sleep(3000);		   

			//Click on CREATE NEW COMPLAINT button
			WebElement CreateNewCompln=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/txtName' and @text='Create New Complaint']"));
			CreateNewCompln.click();  
			Thread.sleep(3000);		 

			//Click on CATEGORY dropdown
			WebElement ClKCategory = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/spnCategory']"));
			ClKCategory.click();
			Thread.sleep(2000);

			//Click on SELECT CATEGORY from dropdown list 
			WebElement SelectCatList = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/lbl_title' and @text='Garbage & Cleanliness ']"));
			SelectCatList.click();
			Thread.sleep(2000);
			
			//Click on COMPLAINT CODE dropdown 
			WebElement ComplanCodeClK = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/spnComplainCode']"));
			ComplanCodeClK.click();
			Thread.sleep(2000);

			//Click on SELECT COMPLAINT CODE from dropdown list
			WebElement SelectComplanCodeClK = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/lbl_title' and @text='Construction & Demolition Waste ']"));
			SelectComplanCodeClK.click();
			Thread.sleep(2000);
			
			//Click on ZONE dropdown 		
			WebElement ZoneCLK = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/spnZone']"));
			ZoneCLK.click();
			Thread.sleep(2000);

			//Click on SELECT ZONE dropdown list 
			WebElement SelectZoneeClK = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/lbl_title' and @text='South East Zone (Limbayat)']"));
			SelectZoneeClK.click();
			Thread.sleep(2000);
			
			//Click on WARD dropdown
			WebElement WardCLK = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/spnWard']"));
			WardCLK.click();
			Thread.sleep(2000);

			//Click on SELECT WARD dropdown
			WebElement SelectWardeCLK = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/lbl_title' and @text='Godadara']"));
			SelectWardeCLK.click();
			Thread.sleep(2000);
			
			//Click on LOCATION  dropdown
			WebElement myLocation = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/edtLocation']"));
			myLocation.sendKeys("Shiv Sagar Residency");
			Thread.sleep(2000);

			//Click on SELECT LOCATION  dropdown
			WebElement describeCompalin=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc.ec.beta:id/edtDescription']"));
			describeCompalin.sendKeys("Neighbour is not cleaning wastage dirty water when they clean their floor which making dirty our places");
			Thread.sleep(2000);
			
			//Scroll down app down 
			Actions act = new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN).build().perform();    //Page Down
            System.out.println("SCROLLED DOWN WORKING");
            Thread.sleep(3000);
         
			/* Scroll down app down 
			 * act.sendKeys(Keys.PAGE_UP).build().perform(); //Page Up
			 * System.out.println("Scroll up perfomed"); Thread.sleep(3000);
			 */
			
			WebElement SubmitCLK=driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc.ec.beta:id/btnSubmit']"));
			SubmitCLK.click();  
			Thread.sleep(2000);	
						
			//WebElement ClearCLK=driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc.ec.beta:id/btnClear']"));
			//ClearCLK.click();
			//Thread.sleep(2000);
			 
			System.out.println("COMPLAINT FORM SUBMITTED");				
			
			WebElement arrow1 = driver.findElement(By.className("android.widget.ImageButton"));
			arrow1.click();
			Thread.sleep(2000);
			
			WebElement arrow2 = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
			arrow2.click();
			Thread.sleep(2000);
			
			WebElement PendinComplaint = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/txtName' and @text='Pending Complaints']"));
			PendinComplaint.click();
			Thread.sleep(2000);
			
			String  MycomplaintNumber  = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/txtComplaintID']")).getText();
			System.out.println("YOUR COMPLAINT NUMBER IS = " +MycomplaintNumber);
			Thread.sleep(2000);
			
			//ViewRegisterComplete nyobjec = new ViewRegisterComplete();
			//nyobjec.myview();  
			//Thread.sleep(3000);			
		}		
	
		/*
		@Test(priority=0)
		public void CheckEmptyFormSubmit() throws Exception 
		{
			//Scroll down app down 
			Actions act = new Actions(driver);
	        act.sendKeys(Keys.PAGE_DOWN).build().perform();    //Page Down
	        System.out.println("SCROLLED DOWN WORKING");
	        Thread.sleep(3000);
			
			//Click on SUBMIT CLick when empty form 
			WebElement SubmitCLK=driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc.ec.beta:id/btnSubmit']"));
			SubmitCLK.click();  
			Thread.sleep(3000);	
			
			String myValidation ="Please select Complain Category!";
			String receivedValid =driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc.ec.beta:id/snackbar_text']")).getText();
			Thread.sleep(2000);
			
			if(myValidation.equals(receivedValid))
			{
				System.out.println("FILL THE COMPLAINT FORM FIRST");
			}
			
			// Scroll down app down 
			 act.sendKeys(Keys.PAGE_UP).build().perform(); //Page Up
			 System.out.println("Scroll up perfomed");
			 Thread.sleep(3000);
		}
		*/
		
		@AfterClass
		public void teardown()
		{
			//close the app
			//driver.quit();
			System.out.println("APP CLOSE METHOD CALLED SUCCESS");
		}
}
