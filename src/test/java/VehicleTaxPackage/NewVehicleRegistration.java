package VehicleTaxPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewVehicleRegistration 
{
	// NEW VEHICLE REGISTRATION WITH MULTIPLE ENTRY DUMMY VEHICLE DATA = WORKING on STAGE 
	
	public static void main(String[] args) throws InterruptedException 
	{
	   ChromeDriver ajdriver =new ChromeDriver();
	   ajdriver.manage().window().maximize();
	   Thread.sleep(2000);
		
	   ajdriver.get("http://10.11.0.8/VehicleTaxDealerTest"); // STAGE SITE 
		Thread.sleep(3000);
				
		WebElement email = ajdriver.findElement(By.id("txtMobileNo"));
		email.sendKeys("8905252328");
		Thread.sleep(1000);
		
		WebElement psd = ajdriver.findElement(By.id("txtPassword"));
		psd.sendKeys("Ajay@123");
		Thread.sleep(1000);
		
		WebElement cathcacode = ajdriver.findElement(By.id("CaptchaInputText"));
		cathcacode.click();
		Thread.sleep(10000);
								
		ajdriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/section[1]/div[1]/form[1]/div[5]/button[1]")).click();
		Thread.sleep(3000);
		
		ajdriver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/i[1]")).click();
		Thread.sleep(2000);
		
		Actions action = new Actions(ajdriver);
		WebElement mainMenu = ajdriver.findElement(By.linkText("New Vehicle Registration"));
		action.moveToElement(mainMenu).moveToElement(ajdriver.findElement(By.xpath("//a[contains(text(),'New Vehicle Registration')]"))).click().build().perform();
		Thread.sleep(2000);
			
		// We can Add form data repeat based on for loop count 
		int j=10;
		for(int i=1; i<=j; i++)
		{						
			WebElement chassisNum = ajdriver.findElement(By.id("txtChasisNo"));
			chassisNum.sendKeys("98798751");
			Thread.sleep(4000);
			
			WebElement engineNum = ajdriver.findElement(By.id("txtEngineNo"));
			engineNum.sendKeys("ENG9879851");
			Thread.sleep(4000);
			engineNum.sendKeys(Keys.TAB);			
			
			// Check that “Google Search button” is enabled or not. 
			/*WebElement BillDateButton= ajdriver.findElement(By.id("txtBillDate"));		
		  
			if(BillDateButton.isEnabled()) 
		    { 
		         System.out.println("Billdate button is enabled. Return:" +BillDateButton.isEnabled()); 
		           
		    } 
		    else
		    { 
		         System.out.println("Billdate button is not enabled. Return: " +BillDateButton.isEnabled()); 
		    } 
			*/
			
		    //Select BILL DATE 
		    WebElement billdat= ajdriver.findElement(By.xpath("//input[@id='txtBillDate']"));
		    billdat.click();
		    
		    //Select 1-3-2024 Date
		    WebElement choosebilldat= ajdriver.findElement(By.xpath("//tbody/tr[1]/td[6]"));
		    choosebilldat.click();
		    
		    WebElement RtoRegNum= ajdriver.findElement(By.id("txtRTORegNo"));
		    RtoRegNum.sendKeys("AV-16-MR-2024");
		    Thread.sleep(2000);
		    
		    //Select RTO Registration Date
		    WebElement RtoRegDateCLK= ajdriver.findElement(By.id("txtRTORegDate"));
		    RtoRegDateCLK.click();
		    
		    //Select 8-3-2024 Date
		    WebElement RtoRegDateSelect= ajdriver.findElement(By.xpath("//tbody/tr[2]/td[6]"));
		    RtoRegDateSelect.click();
		    Thread.sleep(2000);
		    
		    Select companyCode = new Select(ajdriver.findElement(By.id("drpCompanyCode")));
		    companyCode.selectByVisibleText("AKSHAR STEEL");
		    Thread.sleep(2000);
		    	    
		    Select modelCode = new Select(ajdriver.findElement(By.id("drpModelCode")));
		    modelCode.selectByVisibleText("TRAILER");
		    Thread.sleep(2000);
		    
		    Select vehicleType = new Select(ajdriver.findElement(By.id("drpVehicleType")));
		    vehicleType.selectByVisibleText("CNG Fitted Bus/Ambulance Wheeler");
		    Thread.sleep(2000);
		    	    
		    WebElement netAmount= ajdriver.findElement(By.id("txtNetAmount"));
		    netAmount.sendKeys("99999999");
		    netAmount.sendKeys(Keys.TAB);
		    Thread.sleep(2000);
		    
		    JavascriptExecutor ms=(JavascriptExecutor)ajdriver;
		    ms.executeScript("window.scrollBy(0,400)");
		    
		    WebElement ownerNam= ajdriver.findElement(By.id("txtOwnerName"));
		    ownerNam.sendKeys("AJEXA OWENER");
		    Thread.sleep(2000);
		    
		    WebElement mobile= ajdriver.findElement(By.id("txtMobileNo"));
		    mobile.sendKeys("8905252328");
		    Thread.sleep(2000);
		    
		    WebElement Address= ajdriver.findElement(By.id("txtAddress"));
		    Address.sendKeys("30, Roman Ranage building,Khalid house, surat");
		    Thread.sleep(2000);
		    
		    WebElement city= ajdriver.findElement(By.id("txtCity"));
		    city.clear();
		    city.sendKeys("SURAT");
		    Thread.sleep(2000);
		    
		    WebElement zipcode= ajdriver.findElement(By.id("txtZipcode"));
		    zipcode.sendKeys("395007");
		    Thread.sleep(2000);
		    	    
		    WebElement finalSubmit= ajdriver.findElement(By.id("btnSubmit"));
		    finalSubmit.click();
		    Thread.sleep(2000);
		    
		    WebElement finalYes= ajdriver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[4]/div[2]/button[1]"));
		    finalYes.click();
		    Thread.sleep(3000);	    
		    	       
		    WebElement newRegister =ajdriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/div[1]/a[1]"));
		    newRegister.click();
		    Thread.sleep(3000);	    
		}
	}

}
