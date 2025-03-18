package WaterMeterSystemPackage;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginRoleWiseTestCase 
{
 
	//ROLE WISE LOGIN TEST CASE  
	public class LoginUserTestCases 
	{
	   
		 //@Test(enabled = false)  //TO SKIP TEST CASES
		 @Test(priority=1)
		 public static void CentralZoneUser() throws InterruptedException 
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
		       
			    String Actualmessage="Zone";
			     
			     String ExpectedMessage = avdriver.findElement(By.xpath("//b[contains(text(),'Zone')]")).getText();
			     
			     if(Actualmessage.equals(ExpectedMessage))
			     {
			    	 System.out.println("CENTRAL ZONE USER IS LOGGEDIN ");
			     }
			    avdriver.close();
		}
		 
		 	//@Test(enabled = false) //TO SKIP TEST CASES
			@Test(priority=2)
			public static void WestZone24X7User() throws InterruptedException 
			{
				// TODO Auto-generated method stub
				ChromeDriver avdriver=new ChromeDriver();
				avdriver.manage().window().maximize();			
				avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
				Thread.sleep(3000);	
				
				WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
				usernameField.clear(); 
				usernameField.sendKeys("98793");
				
			    WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
			    passwordField.clear();   
			    passwordField.sendKeys("Mk1111111");
			    
			       
			    Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
				myZone.selectByVisibleText("(200) West Zone");
				Thread.sleep(2000);
			        
			     Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
			     ConnType.selectByVisibleText("24X7");
				 Thread.sleep(2000);
			        		       
			     WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
			     loginButton.click();
			     Thread.sleep(3000);
			     
			     String Actualmessage="24X7";
			     
			     String ExpectedMessage = avdriver.findElement(By.xpath("//b[contains(text(),'24X7')]")).getText();
			     
			     if(Actualmessage.equals(ExpectedMessage))
			     {
			    	 System.out.println("WEST ZONE 24X7 USER IS LOGGEDIN ");
			     }
			    avdriver.close();
			}
		 		 
			//@Test(enabled = false) //TO SKIP TEST CASES
			@Test(priority=3)
			public static void WestZone24X7SmartCityUser() throws InterruptedException 
			{
				// TODO Auto-generated method stub
				ChromeDriver avdriver=new ChromeDriver();
				avdriver.manage().window().maximize();			
				avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
				Thread.sleep(3000);	
				
				WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
				usernameField.clear(); 
				usernameField.sendKeys("98502");
				
			    WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
			    passwordField.clear();   
			    passwordField.sendKeys("Jenish1810");
			    
			       
			    Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
				myZone.selectByVisibleText("(200) West Zone");
				Thread.sleep(2000);
			        
			     Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
			     ConnType.selectByVisibleText("24X7 Smart City");
				 Thread.sleep(2000);
			        		       
			     WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
			     loginButton.click();
			     Thread.sleep(3000);
			     
			     String Actualmessage="24X7 Smart City";
			     
			     String ExpectedMessage = avdriver.findElement(By.xpath("//b[contains(text(),'24X7 Smart City')]")).getText();
			     
			     if(Actualmessage.equals(ExpectedMessage))
			     {
			    	 System.out.println("WEST ZONE 24X7 SMART CITY USER IS LOGGEDIN");
			     }
			    avdriver.close();
			}
			
			//@Test(enabled = false) //TO SKIP TEST CASES
			@Test(priority=4)
			public static void WestZone24X7SmartCityJahangirabadUser() throws InterruptedException 
			{
				// TODO Auto-generated method stub
				ChromeDriver avdriver=new ChromeDriver();
				avdriver.manage().window().maximize();			
				avdriver.get("http://10.11.1.13:5050/"); // STAGE SITE 
				Thread.sleep(3000);	
				
				WebElement usernameField = avdriver.findElement(By.id("UserName")); // Replace with actual ID
				usernameField.clear(); 
				usernameField.sendKeys("98507");
				
			    WebElement passwordField = avdriver.findElement(By.id("Password")); // Replace with actual ID
			    passwordField.clear();   
			    passwordField.sendKeys("Sndp1505");
			    			       
			    Select myZone = new Select(avdriver.findElement(By.id("SiteCode")));
				myZone.selectByVisibleText("(200) West Zone");
				Thread.sleep(2000);
			        
			     Select ConnType = new Select(avdriver.findElement(By.id("UserType")));
			     ConnType.selectByVisibleText("24X7 Smart City(JAHANGIRABAD)");
				 Thread.sleep(2000);
			        		       
			     WebElement loginButton = avdriver.findElement(By.id("btnSubmit")); 
			     loginButton.click();
			     Thread.sleep(3000);
			     
			     String Actualmessage="24X7 Smart City(JAHANGIRABAD)";
			     
			     String ExpectedMessage = avdriver.findElement(By.xpath("//b[contains(text(),'24X7 Smart City(JAHANGIRABAD)')]")).getText();
			     
			     if(Actualmessage.equals(ExpectedMessage))
			     {
			    	 System.out.println("WEST ZONE 24X7 SMART CITY (JAHANGIRABAD)USER IS LOGGEDIN");
			     }
			    avdriver.close();
			}	
	}
}
