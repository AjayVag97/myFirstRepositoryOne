package TestNGCodePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PropertyTaxPackage.SeniorCitizenTaxRebate;

public class ReAssessmentWithTestNG
{
	ChromeDriver ReAssDriver = new ChromeDriver();
	@BeforeTest
	public void browserLaunch() throws InterruptedException
	{
		ReAssDriver.manage().window().maximize();			
		ReAssDriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);	
	 }
	
	@Test(priority = 0)
	public void loginUser() throws InterruptedException 
	{		 
	  WebElement email = ReAssDriver.findElement(By.id("txtEmail"));
	  email.sendKeys("nitin.borse@silvertouch.com");
	  Thread.sleep(1000);
		
	  WebElement psd = ReAssDriver.findElement(By.id("txtPassword"));
	  psd.sendKeys("Nitin123");
						
	  ReAssDriver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void loginUserSearching() throws InterruptedException 
	{
		WebElement SearchEnroll = ReAssDriver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[5]/div[1]/button[1]/span[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//CLick on APPLY FOR REASSESSMENETS 
		WebElement ReaAssment=ReAssDriver.findElement(By.xpath("//a[contains(text(),'Reassessment Application')]"));
		ReaAssment.click();
		Thread.sleep(2000);
					
		//Click on PLUS  button APPLY REASSESSMENETS APPLICATION 
		WebElement ReaAsssemtnApply=ReAssDriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
		ReaAsssemtnApply.click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
 	public void tenementNumber() throws InterruptedException
 	{
		//ENTER TENENT NUMBER as per need   
		//073 D 07 1731 0 002   == Addition of construction of new Reassessment.
		//073-D-07-0691-0-001  == Already Sent for Reassessment.
		//2 B 19 881 0 001  == Senior Citizen Tax Rebate request already exists.
			 	  
		ReAssDriver.findElement(By.id("txtWard")).sendKeys("073");
		Select subWard = new Select(ReAssDriver.findElement(By.id("drpSubWard")));
		subWard.selectByVisibleText("D");
		ReAssDriver.findElement(By.id("txtLoaction")).sendKeys("07");
		ReAssDriver.findElement(By.id("txtOwner")).sendKeys("1731");
		ReAssDriver.findElement(By.id("txtSubOwner")).sendKeys("0");
		ReAssDriver.findElement(By.id("txtOccupier")).sendKeys("002");
		ReAssDriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) ReAssDriver;  
		js.executeScript("window.scrollBy(0,300)");
		
		//Enter Answer here Manually calculate
		ReAssDriver.findElement(By.xpath("//*[@id='CaptchaInputText']")).click();
		Thread.sleep(10000);
		
		WebElement getdetail = ReAssDriver.findElement(By.id("btnSubmit"));
		getdetail.click();
		Thread.sleep(4000);
  	
 		try
		{
			//Check ReAssessment DONE or not
			String FirstStatus="Your Reassessment request already exists. You can try this after it's done.";
			String SecondStatus="Your Senior Citizen Tax Rebate request already exists. You can try this after it's done.";
			
			String ActualStatus=ReAssDriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[3]/div")).getText();
			System.out.println("ACTUAL Status is = "+ActualStatus);
		
			if(FirstStatus.equals(ActualStatus))
			{		
				// 073-D-07-0691-0-001  == Already Reassessment
				ReAssDriver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
				Thread.sleep(2000);
				System.out.println("Your Reassessment request already exists. You can try this after it's done.");
				
				//Click on REASSESSMENT APPLICATION LIST button
				WebElement ReAssCLK=ReAssDriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
				ReAssCLK.click();
				Thread.sleep(2000);
							
				//Click on PLUS  button APPLY FOR REASSESSMENETS
				WebElement ReAsssApply=ReAssDriver.findElement(By.xpath("/html/body/div[2]/div/section/section/div[2]/a"));
				ReAsssApply.click();
				Thread.sleep(2000);
				
				System.out.println("TRY NEW TENEMENT NUMBER");
				System.exit(0); // To skip execution of FINALLY CODE BLOCK 
			}
			if(SecondStatus.equals(ActualStatus))
			{
				//2 B 19 881 0 1  ==   Reassessment
				ReAssDriver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
				System.out.println("Your Senior Citizen Tax Rebate request already exists. You can try this after it's done.");
				Thread.sleep(2000);
				
				//Click on REASSESSMENT APPLICATION LIST button
				WebElement SrReAssCLK=ReAssDriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
				SrReAssCLK.click();
				Thread.sleep(2000);
							
				//Click on PLUS  button of APPLY FOR REASSESSMENETS
				WebElement SrReAsssApply=ReAssDriver.findElement(By.xpath("/html/body/div[2]/div/section/section/div[2]/a"));
				SrReAsssApply.click();
				Thread.sleep(2000);	
								
								
				//--------------CALLING TO SeniorCitizenTaxRebate -------------
				SeniorCitizenTaxRebate myobject= new SeniorCitizenTaxRebate();
				myobject.seniorcitizn(ReAssDriver);
								
				System.out.println("TRY NEW TENEMENT NUMBER");
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			System.out.println("TRY code executed of if condition");
		}
			
		finally
		{
			System.out.println("FINALLY CODE EXECTUTED");
			//5 B 1 281 0 1  to Add new Reassessment
			
			//JavascriptExecutor jss = (JavascriptExecutor) radriver;  
			//jss.executeScript("window.scrollBy(0,300)");
						
			//Click on  ADDITION IN CONSTRUCTION button
			WebElement selAddConst=ReAssDriver.findElement(By.id("AdditionConstruction"));
			selAddConst.click();
			Thread.sleep(3000);
			
			Select construDOc = new Select(ReAssDriver.findElement(By.id("ConstructionDocumentId")));
			construDOc.selectByVisibleText("Construction material purchase bills (માલસામાન ખરીદીના બીલો)");
			Thread.sleep(2000);
			
			WebElement uploadDoc = ReAssDriver.findElement(By.id("ConstructionDocument"));
			uploadDoc.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\WorkCompletionCert.pdf");
			Thread.sleep(2000);
			
			//Enter Mobile Number 
			WebElement mynum=ReAssDriver.findElement(By.id("MobileNo"));
			mynum.clear();
			mynum.sendKeys("8905252328");
			Thread.sleep(2000);
			
			//Select Applicant ID 
			Select ApplicantID = new Select(ReAssDriver.findElement(By.id("ApplicantIdentityProofId")));
			ApplicantID.selectByVisibleText("Aadhar card (આધાર કાર્ડ)");
			Thread.sleep(1000);
			
			WebElement uploadID = ReAssDriver.findElement(By.id("ApplicantIdentityProof"));
			uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
			Thread.sleep(2000);
			
			WebElement myRemark = ReAssDriver.findElement(By.id("Remark"));
			myRemark.sendKeys("THIS IS TESTING REMARK FOR REASSESSMENT PROCESS");
			Thread.sleep(2000);
			
			WebElement ClickVerifyMob=ReAssDriver.findElement(By.id("btn_verify"));
			ClickVerifyMob.click();
			Thread.sleep(15000);
			//Enter manually your OTP will take time here  
			
			WebElement VerifyMobOTP = ReAssDriver.findElement(By.id("btnVerifyOTP"));
			VerifyMobOTP.click();
			Thread.sleep(2000);
			
			// FINAL SUMBIT NOT ALLOWED BY ME 
			ReAssDriver.close();
			
			//FiNAL SUBMIT New Assessment
			WebElement SubmitReassess =ReAssDriver.findElement(By.id("btnSaveReassessmentForm"));
			SubmitReassess.click();
			Thread.sleep(3000);
										
			WebElement YesClcik = ReAssDriver.findElement(By.xpath("btnSaveReassessment"));
			YesClcik.click();
			Thread.sleep(4000);
		
			//Get the Latest Application number 
			String applicationNum =ReAssDriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
			System.out.println("Latest Application Number is= " +applicationNum);
			Thread.sleep(2000);
							
			//Search application 
			WebElement propertylistSearch =ReAssDriver.findElement(By.xpath("//input[@type='search']"));
			propertylistSearch.sendKeys(applicationNum);
			Thread.sleep(3000);
							
			WebElement clickapplicationNum =ReAssDriver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
			clickapplicationNum.click();
			Thread.sleep(3000);
			
			System.out.println("YOUR REASSESSMENT DONE SUCCESSFULLY");
		}	
	
 	}
	
    
}
