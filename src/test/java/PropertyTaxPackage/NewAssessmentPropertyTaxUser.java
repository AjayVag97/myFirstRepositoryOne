package PropertyTaxPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// NEW ASSESSMENET SUBMIT,  SEARCH PARTICULAR APPLICATION  NUMBER AND REDIRECT ON APPLICATION DETAILS PAGE  = WORKING on STAGE

public class NewAssessmentPropertyTaxUser 
{
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver avdriver =new ChromeDriver();
		avdriver.manage().window().maximize();
		Thread.sleep(2000);
		
		//avdriver.get("https://www.suratmunicipal.gov.in/OnlineServices/PropertyTax/Enroll/"); // LIVE  SITE 
		
		avdriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);
				
		WebElement email = avdriver.findElement(By.id("txtEmail"));
		email.sendKeys("nitin.borse@silvertouch.com");
		Thread.sleep(1000);
		
		WebElement psd = avdriver.findElement(By.id("txtPassword"));
		psd.sendKeys("Nitin123");
						
		avdriver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
							
		
		WebElement SearchEnroll = avdriver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[5]/div[1]/button[1]/span[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//CLick on APPLY FOR NEW/SELF ASSESSMENETS 
		WebElement newAssmnt=avdriver.findElement(By.xpath("//a[contains(text(),'New / Self Assessment Application')]"));
		//WebElement newAssmnt=avdriver.findElement(By.xpath("//*[@id=\"dvMainBody\"]/div/section/section/div[2]/div/div[1]/a"));
		newAssmnt.click();
		Thread.sleep(2000);
					
		//Click on PLUS  button APPLY FOR NEW/SELF ASSESSMENETS
		WebElement NewAsssemtnApply=avdriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
		NewAsssemtnApply.click();
		Thread.sleep(2000);
								
		//---------------------APPLICATION ANME AND DETAILS ----------------------------------------------		
		WebElement applicantName =avdriver.findElement(By.xpath("//input[@id='ApplicantName']"));
		applicantName.clear();
		applicantName.sendKeys("ALEXA PARKER");
		Thread.sleep(2000);
					
		WebElement mobile =avdriver.findElement(By.xpath("//input[@id='MobileNo']"));
		mobile.clear();
		mobile.sendKeys("8905252328");
		Thread.sleep(2000);
				
		WebElement myaddress =avdriver.findElement(By.xpath("//textarea[@id='Address']"));
		myaddress.sendKeys("19,SMC ICCC Near Breadliner circle, University road, surat ");
		Thread.sleep(2000);
		
		WebElement remark =avdriver.findElement(By.xpath("//textarea[@id='Remark']"));
		remark.sendKeys("This is testing REMARKS ");
		Thread.sleep(2000);
			
		// Applicant ID selection 
		Select ApplicationID = new Select(avdriver.findElement(By.id("IdentityProofId")));
		ApplicationID.selectByVisibleText("Aadhar card (આધાર કાર્ડ)");
		Thread.sleep(2000);
			
		WebElement uploadID = avdriver.findElement(By.id("IdentityProof"));
		uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
		Thread.sleep(2000);		
		
		JavascriptExecutor js = (JavascriptExecutor) avdriver;  
		js.executeScript("window.scrollBy(0,400)");
		
		//Work Completion cert selection 
		Select selectWorkCert = new Select(avdriver.findElement(By.id("WorkCompletionCertificateId")));
		selectWorkCert.selectByVisibleText("Construction material purchase bills (માલસામાન ખરીદીના બીલો) ");
		Thread.sleep(2000);
					
		WebElement uploadWorkCertui = avdriver.findElement(By.id("WorkCompletionCertificate"));
		uploadWorkCertui.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\WorkCompletionCert.pdf");
		Thread.sleep(2000);
		
					
		//PROPERTY DETAILS 
		Select myzone = new Select(avdriver.findElement(By.id("ZoneId")));
		myzone.selectByVisibleText("South East Zone");
		Thread.sleep(2000);
		
		Select propertTaxWard = new Select(avdriver.findElement(By.id("WardNo")));
		propertTaxWard.selectByVisibleText("Godadra (65)");
		Thread.sleep(2000);
		
		Select marketLoc = new Select(avdriver.findElement(By.id("MarketLocation")));
		marketLoc.selectByVisibleText("D");
		Thread.sleep(2000);
	
		//=====MAIN USAGE selection =============
		Select mainusag = new Select(avdriver.findElement(By.id("MainUsage")));
		mainusag.selectByVisibleText("RESIDENCE");
		Thread.sleep(2000);
	
		Select OccupanyselfTenent = new Select(avdriver.findElement(By.id("SelfTenentMode")));
		OccupanyselfTenent.selectByVisibleText("Self");
		Thread.sleep(2000);
				
		Select propertytyp = new Select(avdriver.findElement(By.id("PropertyType")));
		propertytyp.selectByVisibleText("Row House");
		Thread.sleep(2000);
					
		//Click on Water supply meter		
		WebElement watreMeter = avdriver.findElement(By.id("inlineRadio1"));
		watreMeter.click();
		Thread.sleep(2000);
		
		//Click on Add floor details 
		WebElement addFloorDetails = avdriver.findElement(By.id("btnAddArea"));
		addFloorDetails.click();
		Thread.sleep(2000);
				
		Select floor = new Select(avdriver.findElement(By.id("Floor")));
		floor.selectByVisibleText("3rd Floor");
		Thread.sleep(2000);
		
		Select usageType = new Select(avdriver.findElement(By.id("UsageType")));
		usageType.selectByVisibleText("Residence");
		Thread.sleep(2000);
		
		Select floorUsage = new Select(avdriver.findElement(By.id("floorUsage")));
		floorUsage.selectByVisibleText("RESIDENCE");
		Thread.sleep(2000);
		
		WebElement areaFt = avdriver.findElement(By.id("Area"));
		areaFt.sendKeys("880");
		Thread.sleep(2000);
				
		WebElement constAge = avdriver.findElement(By.id("FloorAge"));
		constAge.sendKeys("6");
		Thread.sleep(2000);
		
		WebElement plusbutton = avdriver.findElement(By.id("btnAddFloor"));
		plusbutton.click();
		Thread.sleep(2000);		
		
		//Click on CALCULATE TAX button
		WebElement calTax = avdriver.findElement(By.id("btnCalculatePTax"));
		calTax.click();
		Thread.sleep(2000);
		
		WebElement clickVerifyMob = avdriver.findElement(By.id("btn_verify"));
		clickVerifyMob.click();
		Thread.sleep(12000);
				
		WebElement VerifyMobOTP = avdriver.findElement(By.id("btnVerifyOTP"));
		VerifyMobOTP.click();
		Thread.sleep(2000);
		
		//FiNAL SUBMIT New Assessment
		WebElement finalSubmit =avdriver.findElement(By.id("btnNewAssessmentSubmit"));
		finalSubmit.click();
		Thread.sleep(3000);
				
		WebElement YesClcik = avdriver.findElement(By.xpath("//button[@id='']"));
		YesClcik.click();
		Thread.sleep(4000);
		
		
		//div[contains(text(),'New Assessment has been Apply successfully.')]
		
		/*	
		String erromsg = "Page encountered an error!!!";
		String erromsg12 =avdriver.findElement(By.xpath("//div[text()[normalize-space()='Page encountered an error!!!']]")).getText();
				
		try
		{
			if(erromsg.equals(erromsg12))
			{
				System.out.println("Redirected on Error page"); 	
			}				
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		*/
		
		//PropertyTax Assessment Application List
		//avdriver.get("https://www.suratmunicipal.gov.in/mmgy/PropertyTax/AssessmentApplicationList");
		//Thread.sleep(3000);
					
		//Get the Latest Application number 
		String applicationNum =avdriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println("Latest Application Number is= " +applicationNum);
		Thread.sleep(2000);
				
		//Search application 
		WebElement propertylistSearch =avdriver.findElement(By.xpath("//input[@type='search']"));
		propertylistSearch.sendKeys(applicationNum);
		Thread.sleep(3000);
				
		WebElement clickapplicationNum =avdriver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
		clickapplicationNum.click();
		Thread.sleep(3000);
				
		//CALLING TO SURVEYERO SIDE LOGIN FUNCTION 
		//LoginSurveyorAction Surveyorapprove = new LoginSurveyorAction();
		//Surveyorapprove.CheckApprove();
		
	}
}
