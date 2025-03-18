package TestNGCodePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeniorCitizenTaxRebateWithTestNG 
{
	ChromeDriver SrCtznDriver = new ChromeDriver();
	@BeforeTest
	public void browserLaunch() throws InterruptedException
	{
		SrCtznDriver.manage().window().maximize();			
		SrCtznDriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);	
	 }
	
	@Test(priority = 0)
	public void loginUser() throws InterruptedException 
	{		 
	  WebElement email = SrCtznDriver.findElement(By.id("txtEmail"));
	  email.sendKeys("nitin.borse@silvertouch.com");
	  Thread.sleep(1000);
		
	  WebElement psd = SrCtznDriver.findElement(By.id("txtPassword"));
	  psd.sendKeys("Nitin123");
						
	  SrCtznDriver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void loginUserSearching() throws InterruptedException 
	{
		WebElement SearchEnroll = SrCtznDriver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[5]/div[1]/button[1]/span[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//CLick on APPLY FOR SENIOR CITZEN  
		WebElement ReaAssment=SrCtznDriver.findElement(By.xpath("//a[contains(text(),'Senior Citizen Tax Rebate Application')]"));
		ReaAssment.click();
		Thread.sleep(2000);
					
		//Click on PLUS  button APPLY SENIOR CITZEN  APPLICATION 
		WebElement ReaAsssemtnApply=SrCtznDriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
		ReaAsssemtnApply.click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
 	public void SeniorCitizen() throws InterruptedException
 	{
		//ENTER TENENT NUMBER as per need   
		//073 D 07 1731 0 002   == Addition of construction of new Reassessment.
		//073-D-07-0691-0-001  == Already Sent for Reassessment.
		//2 B 19 881 0 001  == Senior Citizen Tax Rebate request already exists.
			 	  
		SrCtznDriver.findElement(By.id("txtWard")).sendKeys("073");
		Select subWard = new Select(SrCtznDriver.findElement(By.id("drpSubWard")));
		subWard.selectByVisibleText("D");
		SrCtznDriver.findElement(By.id("txtLoaction")).sendKeys("07");
		SrCtznDriver.findElement(By.id("txtOwner")).sendKeys("1731");
		SrCtznDriver.findElement(By.id("txtSubOwner")).sendKeys("0");
		SrCtznDriver.findElement(By.id("txtOccupier")).sendKeys("002");
		SrCtznDriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) SrCtznDriver;  
		js.executeScript("window.scrollBy(0,300)");
		
		//Enter Answer here Manually calculate
		SrCtznDriver.findElement(By.xpath("//*[@id='CaptchaInputText']")).click();
		Thread.sleep(10000);
		
		WebElement getdetail = SrCtznDriver.findElement(By.id("btnSubmit"));
		getdetail.click();
		Thread.sleep(4000);
 	}
	
	@Test(priority = 2)
 	public void tenementNumber() throws InterruptedException
 	{
		//Select Applicant ID 
		Select SrAgeType = new Select(SrCtznDriver.findElement(By.id("SeniorCitizenDocumentType")));
		SrAgeType.selectByVisibleText("Birth Certificate (જન્મ પ્રમાણપત્ર)");
		Thread.sleep(1000);
		
		WebElement uploadID = SrCtznDriver.findElement(By.id("SeniorCitizenDocument"));
		uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
		Thread.sleep(2000);
		
		WebElement myRemark = SrCtznDriver.findElement(By.id("Remark"));
		myRemark.sendKeys("THIS IS TESTING REMARK FOR SENIOR CITIZEN");
		Thread.sleep(2000);
		
		//Enter Mobile Number 
		WebElement mynum=SrCtznDriver.findElement(By.id("MobileNo"));
		mynum.clear();
		mynum.sendKeys("8905252328");
		Thread.sleep(2000);
		
		// FINAL SUMBIT NOT ALLOWED BY ME 
		SrCtznDriver.close();
		
		//Click on VERIFY MOBILE NO. button
		WebElement ClickVerifyMob=SrCtznDriver.findElement(By.id("btn_verify"));
		ClickVerifyMob.click();
		Thread.sleep(15000);
		//Enter manually your OTP will take time here  
				
		
		WebElement VerifyMobOTP = SrCtznDriver.findElement(By.id("btnVerifyOTP"));
		VerifyMobOTP.click();
		Thread.sleep(2000);
		
		System.out.println("YOU ALREADY REQUESTED FOR SENIOR CITIZEN TAX REBATE, PLEASE WAIT FOR MORE DAYS");
 	}
	
	
	
	
	
	
}
