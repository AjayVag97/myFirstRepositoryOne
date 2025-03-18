package PropertyTaxPackage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

//REASSESSMENET SUBMIT AND CHECK THAT ALREADY REASSESSMENT DONE OR NOT IF NOT THEN GOING TO PERFORM  = WORKING on STAGE .  

public class ReAssessmentPropertyTaxUser 
{
    public static void main(String[] args) throws InterruptedException
	{
    	ChromeDriver radriver = new ChromeDriver();
		radriver.manage().window().maximize();
		Thread.sleep(2000);
		
		//radriver.get("https://www.suratmunicipal.gov.in/OnlineServices/PropertyTax/Enroll/"); // LIVE  SITE 
		
		radriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);
				
		WebElement email = radriver.findElement(By.id("txtEmail"));
		email.sendKeys("nitin.borse@silvertouch.com");
		Thread.sleep(1000);
		
		WebElement psd = radriver.findElement(By.id("txtPassword"));
		psd.sendKeys("Nitin123");
						
		radriver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);		
		
		WebElement SearchEnroll = radriver.findElement(By.xpath("//body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[5]/div[1]/button[1]/span[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//Click on APPLY FOR REASSESSMENETS 
		WebElement ReAssmnt=radriver.findElement(By.xpath("//a[contains(text(),'Reassessment Application')]"));
		ReAssmnt.click();
		Thread.sleep(2000);
					
		//Click on PLUS  button APPLY FOR REASSESSMENETS
		WebElement ReAsssemtnApply=radriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
		ReAsssemtnApply.click();
		Thread.sleep(2000);
				
		//ENTER TENENT NUMBER as per need   073-D-07-0691-0-001	 == Already Sent for Reassessment.
		//2 B 19 881 0 1  == Senior Citizen Tax Rebate request already exists.
		//5 B 1 281 0 1   == Addition of construction of new Reassessment.
		
		radriver.findElement(By.id("txtWard")).sendKeys("2");
		Select subWard = new Select(radriver.findElement(By.id("drpSubWard")));
		subWard.selectByVisibleText("B");
		radriver.findElement(By.id("txtLoaction")).sendKeys("19");
		radriver.findElement(By.id("txtOwner")).sendKeys("881");
		radriver.findElement(By.id("txtSubOwner")).sendKeys("0");
		radriver.findElement(By.id("txtOccupier")).sendKeys("1");
		radriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) radriver;  
		js.executeScript("window.scrollBy(0,300)");
		
		//Enter Answer here Manually calculate
		radriver.findElement(By.xpath("//*[@id='CaptchaInputText']")).click();
		Thread.sleep(10000);
				
		radriver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(4000);
						
		//radriver.findElement(By.xpath("//button[@id='btnClear']")).click();
		//Thread.sleep(3000);
		try
		{
			//Check ReAssessment DONE or not
			String firstStatus="Your Reassessment request already exists. You can try this after it's done.";
			String secondStatus="Your Senior Citizen Tax Rebate request already exists. You can try this after it's done.";
			
			String ActualStatus=radriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[3]/div")).getText();
			System.out.println("ACTUAL Status is = "+ActualStatus);
		
			if(firstStatus.equals(ActualStatus))
			{		
				// 073-D-07-0691-0-001  == Already Reassessment
				radriver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
				Thread.sleep(2000);
				System.out.println("Your Reassessment request already exists. You can try this after it's done.");
				
				//Click on REASSESSMENT APPLICATION LIST button
				WebElement ReAssCLK=radriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
				ReAssCLK.click();
				Thread.sleep(2000);
							
				//Click on PLUS  button APPLY FOR REASSESSMENETS
				WebElement ReAsssApply=radriver.findElement(By.xpath("/html/body/div[2]/div/section/section/div[2]/a"));
				ReAsssApply.click();
				Thread.sleep(2000);
				
				System.out.println("TRY NEW TENEMENT NUMBER");
				System.exit(0); // To skip execution of FINALLY CODE BLOCK 
			}
			if(secondStatus.equals(ActualStatus))
			{
				//2 B 19 881 0 1  ==   Reassessment
				radriver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
				System.out.println("Your Senior Citizen Tax Rebate request already exists. You can try this after it's done.");
				Thread.sleep(2000);
				
				//Click on REASSESSMENT APPLICATION LIST button
				WebElement SrReAssCLK=radriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
				SrReAssCLK.click();
				Thread.sleep(2000);
							
				//Click on PLUS  button of APPLY FOR REASSESSMENETS
				WebElement SrReAsssApply=radriver.findElement(By.xpath("/html/body/div[2]/div/section/section/div[2]/a"));
				SrReAsssApply.click();
				Thread.sleep(2000);	
								
								
				//--------------CALLING TO SeniorCitizenTaxRebate -------------
				SeniorCitizenTaxRebate myobject= new SeniorCitizenTaxRebate();
				myobject.seniorcitizn(radriver);
								
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
			WebElement selAddConst=radriver.findElement(By.id("AdditionConstruction"));
			selAddConst.click();
			Thread.sleep(3000);
			
			Select construDOc = new Select(radriver.findElement(By.id("ConstructionDocumentId")));
			construDOc.selectByVisibleText("Construction material purchase bills (માલસામાન ખરીદીના બીલો)");
			Thread.sleep(2000);
			
			WebElement uploadDoc = radriver.findElement(By.id("ConstructionDocument"));
			uploadDoc.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\WorkCompletionCert.pdf");
			Thread.sleep(2000);
			
			//Enter Mobile Number 
			WebElement mynum=radriver.findElement(By.id("MobileNo"));
			mynum.clear();
			mynum.sendKeys("8905252328");
			Thread.sleep(2000);
			
			//Select Applicant ID 
			Select ApplicantID = new Select(radriver.findElement(By.id("ApplicantIdentityProofId")));
			ApplicantID.selectByVisibleText("Aadhar card (આધાર કાર્ડ)");
			Thread.sleep(1000);
			
			WebElement uploadID = radriver.findElement(By.id("ApplicantIdentityProof"));
			uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
			Thread.sleep(2000);
			
			WebElement myRemark = radriver.findElement(By.id("Remark"));
			myRemark.sendKeys("THIS IS TESTING REMARK FOR REASSESSMENT PROCESS");
			Thread.sleep(2000);
			
			WebElement ClickVerifyMob=radriver.findElement(By.id("btn_verify"));
			ClickVerifyMob.click();
			Thread.sleep(15000);
			//Enter manually your OTP will take time here  
			
			WebElement VerifyMobOTP = radriver.findElement(By.id("btnVerifyOTP"));
			VerifyMobOTP.click();
			Thread.sleep(2000);
			
			// FINAL SUMBIT NOT ALLOWED BY ME 
			radriver.close();
			
			//FiNAL SUBMIT New Assessment
			WebElement SubmitReassess =radriver.findElement(By.id("btnSaveReassessmentForm"));
			SubmitReassess.click();
			Thread.sleep(3000);
										
			WebElement YesClcik = radriver.findElement(By.xpath("btnSaveReassessment"));
			YesClcik.click();
			Thread.sleep(4000);
		
			//Get the Latest Application number 
			String applicationNum =radriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
			System.out.println("Latest Application Number is= " +applicationNum);
			Thread.sleep(2000);
							
			//Search application 
			WebElement propertylistSearch =radriver.findElement(By.xpath("//input[@type='search']"));
			propertylistSearch.sendKeys(applicationNum);
			Thread.sleep(3000);
							
			WebElement clickapplicationNum =radriver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
			clickapplicationNum.click();
			Thread.sleep(3000);
			
			System.out.println("YOUR REASSESSMENT DONE SUCCESSFULLY");
		}	
	}
}