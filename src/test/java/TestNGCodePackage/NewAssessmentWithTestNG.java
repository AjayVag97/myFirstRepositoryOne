package TestNGCodePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewAssessmentWithTestNG
{
	ChromeDriver newAssDriver = new ChromeDriver();
	@BeforeTest
	public void browserLaunch() throws InterruptedException
	{
		newAssDriver.manage().window().maximize();			
		newAssDriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);	
	 }
	
	@Test(priority = 0)
	public void loginUser() throws InterruptedException 
	{		 
	  WebElement email = newAssDriver.findElement(By.id("txtEmail"));
	  email.sendKeys("nitin.borse@silvertouch.com");
	  Thread.sleep(1000);
		
	  WebElement psd = newAssDriver.findElement(By.id("txtPassword"));
	  psd.sendKeys("Nitin123");
						
	  newAssDriver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
	}
    
	@Test(priority = 1)
	public void loginUserSearching() throws InterruptedException 
	{
		WebElement SearchEnroll = newAssDriver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[5]/div[1]/button[1]/span[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//CLick on APPLY FOR NEW/SELF ASSESSMENETS 
		WebElement newAssmnt=newAssDriver.findElement(By.xpath("//a[contains(text(),'New / Self Assessment Application')]"));
		//WebElement newAssmnt=avdriver.findElement(By.xpath("//*[@id=\"dvMainBody\"]/div/section/section/div[2]/div/div[1]/a"));
		newAssmnt.click();
		Thread.sleep(2000);
					
		//Click on PLUS  button APPLY FOR NEW/SELF ASSESSMENETS
		WebElement NewAsssemtnApply=newAssDriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
		NewAsssemtnApply.click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void basicDetails() throws InterruptedException
	{
		//---------------------APPLICATION ANME AND DETAILS ----------------------------------------------		
		WebElement applicantName =newAssDriver.findElement(By.xpath("//input[@id='ApplicantName']"));
		applicantName.clear();
		applicantName.sendKeys("ALEXA PARKER");
		Thread.sleep(2000);
					
		WebElement mobile =newAssDriver.findElement(By.xpath("//input[@id='MobileNo']"));
		mobile.clear();
		mobile.sendKeys("8905252328");
		Thread.sleep(2000);
				
		WebElement myaddress =newAssDriver.findElement(By.xpath("//textarea[@id='Address']"));
		myaddress.sendKeys("19,SMC ICCC Near Breadliner circle, University road, surat ");
		Thread.sleep(2000);
		
		WebElement remark =newAssDriver.findElement(By.xpath("//textarea[@id='Remark']"));
		remark.sendKeys("This is testing REMARKS ");
		Thread.sleep(2000);
			
		// Applicant ID selection 
		Select ApplicationID = new Select(newAssDriver.findElement(By.id("IdentityProofId")));
		ApplicationID.selectByVisibleText("Aadhar card (આધાર કાર્ડ)");
		Thread.sleep(2000);
			
		WebElement uploadID = newAssDriver.findElement(By.id("IdentityProof"));
		uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
		Thread.sleep(2000);		
		
		JavascriptExecutor js = (JavascriptExecutor) newAssDriver;  
		js.executeScript("window.scrollBy(0,400)");
		
		//Work Completion cert selection 
		Select selectWorkCert = new Select(newAssDriver.findElement(By.id("WorkCompletionCertificateId")));
		selectWorkCert.selectByVisibleText("Construction material purchase bills (માલસામાન ખરીદીના બીલો) ");
		Thread.sleep(2000);
					
		WebElement uploadWorkCertui = newAssDriver.findElement(By.id("WorkCompletionCertificate"));
		uploadWorkCertui.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\WorkCompletionCert.pdf");
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void propertyDetails() throws InterruptedException
	{
		//PROPERTY DETAILS 
		Select myzone = new Select(newAssDriver.findElement(By.id("ZoneId")));
		myzone.selectByVisibleText("South East Zone");
		Thread.sleep(2000);
		
		Select propertTaxWard = new Select(newAssDriver.findElement(By.id("WardNo")));
		propertTaxWard.selectByVisibleText("Godadra (65)");
		Thread.sleep(2000);
		
		Select marketLoc = new Select(newAssDriver.findElement(By.id("MarketLocation")));
		marketLoc.selectByVisibleText("D");
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void mainUsage() throws InterruptedException
	{
		//=====MAIN USAGE selection =============
		Select mainusag = new Select(newAssDriver.findElement(By.id("MainUsage")));
		mainusag.selectByVisibleText("RESIDENCE");
		Thread.sleep(2000);
	
		Select OccupanyselfTenent = new Select(newAssDriver.findElement(By.id("SelfTenentMode")));
		OccupanyselfTenent.selectByVisibleText("Self");
		Thread.sleep(2000);
				
		Select propertytyp = new Select(newAssDriver.findElement(By.id("PropertyType")));
		propertytyp.selectByVisibleText("Row House");
		Thread.sleep(2000);
					
		//Click on Water supply meter		
		WebElement watreMeter = newAssDriver.findElement(By.id("inlineRadio1"));
		watreMeter.click();
		Thread.sleep(2000);
	 }
	
	@Test(priority = 5)
	public void addFloorWiseDetails() throws InterruptedException
	{
		//Click on Add floor details 
		WebElement addFloorDetails = newAssDriver.findElement(By.id("btnAddArea"));
		addFloorDetails.click();
		Thread.sleep(2000);
				
		Select floor = new Select(newAssDriver.findElement(By.id("Floor")));
		floor.selectByVisibleText("3rd Floor");
		Thread.sleep(2000);
		
		Select usageType = new Select(newAssDriver.findElement(By.id("UsageType")));
		usageType.selectByVisibleText("Residence");
		Thread.sleep(2000);
		
		Select floorUsage = new Select(newAssDriver.findElement(By.id("floorUsage")));
		floorUsage.selectByVisibleText("RESIDENCE");
		Thread.sleep(2000);
		
		WebElement areaFt = newAssDriver.findElement(By.id("Area"));
		areaFt.sendKeys("880");
		Thread.sleep(2000);
				
		WebElement constAge = newAssDriver.findElement(By.id("FloorAge"));
		constAge.sendKeys("6");
		Thread.sleep(2000);
		
		WebElement plusbutton = newAssDriver.findElement(By.id("btnAddFloor"));
		plusbutton.click();
		Thread.sleep(2000);	
		
		//Click on CALCULATE TAX button
		WebElement calTax = newAssDriver.findElement(By.id("btnCalculatePTax"));
		calTax.click();
		Thread.sleep(2000);
				
	}
	
	@Test(priority = 6)
	public void mobileOTVerify() throws InterruptedException
	{
		WebElement clickVerifyMob = newAssDriver.findElement(By.id("btn_verify"));
		clickVerifyMob.click();
		Thread.sleep(12000);
				
		WebElement VerifyMobOTP = newAssDriver.findElement(By.id("btnVerifyOTP"));
		VerifyMobOTP.click();
		Thread.sleep(2000);
		
		//FiNAL SUBMIT New Assessment
		WebElement finalSubmit =newAssDriver.findElement(By.id("btnNewAssessmentSubmit"));
		finalSubmit.click();
		Thread.sleep(3000);
				
		WebElement YesClcik = newAssDriver.findElement(By.xpath("//button[@id='']"));
		YesClcik.click();
		Thread.sleep(4000);
	}
	
	@Test(priority =7)
	public void getApplication() throws InterruptedException
	{
		//Get the Latest Application number 
		String applicationNum =newAssDriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Application Number is= " +applicationNum);
		Thread.sleep(2000);
				
		//Search application 
		WebElement propertylistSearch =newAssDriver.findElement(By.xpath("//input[@type='search']"));
		propertylistSearch.sendKeys(applicationNum);
		Thread.sleep(3000);
				
		WebElement clickapplicationNum =newAssDriver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
		clickapplicationNum.click();
		Thread.sleep(3000);				
		
		//CALLING TO SURVEYERO SIDE LOGIN FUNCTION 
		//LoginSurveyorAction Surveyorapprove = new LoginSurveyorAction();
		//Surveyorapprove.CheckApprove();
	}
}
