package WaterMeterSystemPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewWaterMeterConnection 
{
	   ChromeDriver avdriver = new ChromeDriver();
	
	   //@Test(enabled = false)  //TO SKIP TEST CASES
	   @Test(priority=1)
	    public void OwenerLoginMethod() throws InterruptedException
		{
			// TODO Auto-generated method stub
			//ChromeDriver avdriver = new ChromeDriver();
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
			
		}
	    
	    @Test(priority=2)
	    public void NewWaterConnection() throws InterruptedException
	    {		
	    	
	    	avdriver.findElement(By.xpath("//a[contains(text(),'Masters')]")); 
			WebElement masterMenu = avdriver.findElement(By.xpath("//a[contains(text(),'Masters')]")); 
			masterMenu.click();   
			Thread.sleep(2000);
			
			WebElement WaterConnection = avdriver.findElement(By.xpath("//a[contains(text(),'Water Connections')]")); 
			WaterConnection.click();   
			Thread.sleep(2000);
					
			WebElement AddNew = avdriver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]")); 
			AddNew.click();   
			Thread.sleep(2000);
			
			WebElement wardNum = avdriver.findElement(By.id("Ward")); 
			wardNum.clear();
			wardNum.sendKeys("1");
			Thread.sleep(2000);
		
			WebElement ConnNum = avdriver.findElement(By.id("ConnectionNo")); 
			ConnNum.clear();
			ConnNum.sendKeys("2323");
			Thread.sleep(2000);
			
			WebElement ownName = avdriver.findElement(By.id("Name1")); 
			ownName.clear();
			ownName.sendKeys("AJAY TESTER QA");
			Thread.sleep(2000);
	
			WebElement Address1 = avdriver.findElement(By.id("Address1")); 
			Address1.clear();
			Address1.sendKeys("23, Elite Residency,");
			Thread.sleep(2000);
			
			WebElement MobileNum = avdriver.findElement(By.id("MobileNo")); 
			MobileNum.clear();
			MobileNum.sendKeys("8905252328");
			Thread.sleep(2000);
			
			WebElement TotalFamily = avdriver.findElement(By.id("TotFamily")); 
			TotalFamily.clear();
			TotalFamily.sendKeys("1");
			Thread.sleep(2000);
			
			WebElement inCityCheckBox = avdriver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/label[1]")); 
			inCityCheckBox.click();
			Thread.sleep(2000);
			
			WebElement NondhNum = avdriver.findElement(By.id("NondhNo")); 
			NondhNum.clear();
			NondhNum.sendKeys("7/278/A/1/7/5/1/ TO 9/9");
			Thread.sleep(2000);
			
			WebElement SeqNum = avdriver.findElement(By.id("SeqNo")); 
			SeqNum.clear();
			SeqNum.sendKeys("5522");
			Thread.sleep(2000);
			
			Select GrouCode = new Select(avdriver.findElement(By.xpath("//select[@id='GroupCode']")));
			GrouCode.selectByVisibleText("Bulk");
			Thread.sleep(2000);
					
			Select Residency = new Select(avdriver.findElement(By.xpath("//select[@id='UsageCode']")));
			Residency.selectByVisibleText("RESTAURANT");
			Thread.sleep(2000);
			
			Select ConnectionSize = new Select(avdriver.findElement(By.xpath("//select[@id='ConnectionSize']")));
			ConnectionSize.selectByVisibleText("2'' PipeLine");
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) avdriver;  
			js.executeScript("window.scrollBy(0,500)");
			
			Select WaterTankNum = new Select(avdriver.findElement(By.xpath("//select[@id='Tankid']")));
			WaterTankNum.selectByVisibleText("ESR-SE11");
			Thread.sleep(2000);
	
			WebElement InstallDate = avdriver.findElement(By.id("strInstallationDate")); 
			InstallDate.clear();
			InstallDate.sendKeys("12/12/2024");
			Thread.sleep(2000);
			
			WebElement isBoreCheckBox = avdriver.findElement(By.xpath("//span[contains(text(),'Is Bore Available ?')]")); 
			isBoreCheckBox.click();
			Thread.sleep(2000);
					
			Select ConnDetail = new Select(avdriver.findElement(By.xpath("//select[@id='ConnDetail']")));
			ConnDetail.selectByVisibleText("Secondary");
			Thread.sleep(2000);
					
			WebElement PrimConnWard = avdriver.findElement(By.xpath("//input[@id='PrmWard']")); 
			PrimConnWard.sendKeys("1");
			Thread.sleep(2000);
			
			WebElement PrimConnNum = avdriver.findElement(By.xpath("//input[@id='PrmConnectionNo']")); 
			PrimConnNum.sendKeys("2");
			Thread.sleep(2000);
			
			WebElement MeterNum = avdriver.findElement(By.id("MeterNo")); 
			MeterNum.sendKeys("123");
			Thread.sleep(2000);
			
			WebElement MeterOwn = avdriver.findElement(By.xpath("//label[contains(text(),'SMC')]")); 
			MeterOwn.click();
			Thread.sleep(2000);
					
			Select MeterMake = new Select(avdriver.findElement(By.id("MeterMakeCode")));
			MeterMake.selectByVisibleText("BAYLAN");
			Thread.sleep(2000);
			
			Select MeterStatus = new Select(avdriver.findElement(By.xpath("//select[@id='strMeterStatusType_SubType']")));
			MeterStatus.selectByVisibleText("Live Connection");
			Thread.sleep(2000);
			
			WebElement ApplicationDate = avdriver.findElement(By.id("strApplicationDate")); 
			ApplicationDate.clear();
			ApplicationDate.sendKeys("20/12/2024");
			ApplicationDate.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
								
			WebElement Nxt = avdriver.findElement(By.id("btnOwnerDetails")); 
			Nxt.click();
			Thread.sleep(3000);
		
		}
		
	    @Test(priority=3)
	    public void TenamentDetails() throws InterruptedException
	    {	
	    	WebElement singleRadio = avdriver.findElement(By.xpath("//label[contains(text(),'Single')]"));
	    	singleRadio.click();
	    	Thread.sleep(2000);
	    	
			//7 A	5	4507	0	1
	    	try 
	    	{
		    	avdriver.findElement(By.id("txtWard1")).sendKeys("7");
				WebElement subWard = avdriver.findElement(By.id("txtSubWard1"));
				subWard.sendKeys("A");
				avdriver.findElement(By.id("txtLocation1")).sendKeys("5");
				avdriver.findElement(By.id("txtOwner1")).sendKeys("4507");
				avdriver.findElement(By.id("txtSubOwner1")).sendKeys("0");
				avdriver.findElement(By.id("txtOccupierNo1")).sendKeys("1");
				
				WebElement AddBtn=avdriver.findElement(By.id("btnAddTenement"));
				AddBtn.click();
				Thread.sleep(2000);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		System.out.println("TENEMENT NUMBER IS INVALID ");
	    	}
	    	
			WebElement Nxt2 = avdriver.findElement(By.id("btnTenementNext")); 
			Nxt2.click();
			Thread.sleep(3000);
			
	    }
	    
	    @Test(priority=4)
	    public void ZsaveData() throws InterruptedException
	    {
	    	
	    	WebElement SaveWaterData=avdriver.findElement(By.id("btnSubmitWCForm"));
	    	SaveWaterData.click();
			Thread.sleep(4000);
			System.out.println("NEW WATER METER CONNECTION FORM SUBMITTED SUCCESSFULLY");
			
			avdriver.close();
			//Water Connection Details saved successfully.
	    }
}

