package WaterMeterSystemPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//WORKING CODE OF WATER METER SYSTEM PROJECT SCRIPT OF LOGIN PAGE 
public class LoginUserTestCases 
{
	
	   //@Test(enabled = true)
		@Test(priority=1)
		public static void EmptyFormSubmit() throws InterruptedException 
		{
			// TODO Auto-generated method stub
			ChromeDriver avdriver=new ChromeDriver();
			avdriver.manage().window().maximize();			
			avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
			Thread.sleep(3000);	
			
			 WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
		     loginButton.click();
		     Thread.sleep(4000);
		     
		     String Actualmessage="UserName is required";
		     
		     String ExpectedMessage = avdriver.findElement(By.id("UserName-error")).getText();
		     
		     if(Actualmessage.equals(ExpectedMessage))
		     {
		    	 System.out.println("PLEASE ENTER ALL REQUIRED DETAILS");
		     }
		     
		    avdriver.close();
		}
	
	
	
	
		//@Test(enabled = false) //TO SKIP TEST CASES
		@Test(priority=2)
		public static void InvalidUserLogin() throws InterruptedException 
		{
			// TODO Auto-generated method stub
			ChromeDriver avdriver=new ChromeDriver();
			avdriver.manage().window().maximize();			
			avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
			Thread.sleep(3000);	
			
			WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
			usernameField.clear(); 
			usernameField.sendKeys("981233");
			
		    WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
		    passwordField.clear();   
		    passwordField.sendKeys("Tushar12344");
		    
		       
		    Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
			myZone.selectByVisibleText("(300) Central Zone");
			Thread.sleep(2000);
		        
		     Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
		     ConnType.selectByVisibleText("Zone");
			 Thread.sleep(2000);
		        		       
		     WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
		     loginButton.click();
		     Thread.sleep(3000);
		     
		     String Actualmessage="Invalid User";
		     
		     String ExpectedMessage = avdriver.findElement(By.xpath("//div[contains(text(),'Invalid User')]")).getText();
		     
		     if(Actualmessage.equals(ExpectedMessage))
		     {
		    	 System.out.println("INVALID USER TRYING TO LOGIN INTO SYSTME");
		     }
		    avdriver.close();
		}
	
		 //@Test(enabled = false)  //TO SKIP TEST CASES
		 @Test(priority=3)
		 public static void ValidUserLogin() throws InterruptedException 
		 {
				// TODO Auto-generated method stub
				ChromeDriver avdriver=new ChromeDriver();
				avdriver.manage().window().maximize();			
				avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
				Thread.sleep(3000);	
				
				WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
				usernameField.clear(); 
				usernameField.sendKeys("98123");
				
			    WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
			    passwordField.clear();   
			    passwordField.sendKeys("Tushar1234");
			    			       
			    Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
				myZone.selectByVisibleText("(300) Central Zone");
				Thread.sleep(2000);
			        
			    Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
			    ConnType.selectByVisibleText("Zone");
				Thread.sleep(2000);
			        		       
			    WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
			    loginButton.click();
			    Thread.sleep(3000);
		       
			    System.out.println("User Login Success");
				
			    WebElement justclk=avdriver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]"));
			    justclk.click();
			    Thread.sleep(2000);
			     
			    WebElement logoutButton = avdriver.findElement(By.id("aLogout")); 
			    logoutButton.click();
			    Thread.sleep(3000);
			     
			    avdriver.close();
		}
}
