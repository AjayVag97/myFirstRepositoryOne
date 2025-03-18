package PropertyTaxPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//APPLY FOR NAME TRANSFER USING TENEMENT NUMBER AND THEN GOING TO PERFORM  = WORKING on STAGE . 
public class NameTransferPropertyTax 
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
			
			//CLick on SUB MENU  NAME TRASNFER 
			WebElement SubNameTrans =avdriver.findElement(By.xpath("//a[contains(text(),'Name Transfer Application')]"));
			SubNameTrans.click();
			Thread.sleep(2000);
						
			//Click on PLUS  button APPLY NAME TRASNFER 
			WebElement NameTransferApply=avdriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/a[1]"));
			NameTransferApply.click();
			Thread.sleep(2000);
									
			//---------------------ENTER TENENT NUMBER for Name Transfer Application ----------------------------------------------		
			//2 B 19 881 0 1      == NAME TRANSFER Application Tenement No.
			//073-D-07-1741-0-002 == 
			//5 B 1 281 0 1       == 
						
			avdriver.findElement(By.id("txtWard")).sendKeys("073");
			Select subWard = new Select(avdriver.findElement(By.id("drpSubWard")));
			subWard.selectByVisibleText("D");
			avdriver.findElement(By.id("txtLoaction")).sendKeys("07");
			avdriver.findElement(By.id("txtOwner")).sendKeys("1731");
			avdriver.findElement(By.id("txtSubOwner")).sendKeys("0");
			avdriver.findElement(By.id("txtOccupier")).sendKeys("001");
			avdriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) avdriver;  
			js.executeScript("window.scrollBy(0,300)");
			
			//Enter Answer here Manually calculate
			avdriver.findElement(By.xpath("//*[@id='CaptchaInputText']")).click();
			Thread.sleep(10000);
					
			WebElement getdetail = avdriver.findElement(By.id("btnSubmit"));
			getdetail.click();
			Thread.sleep(4000);
									
			WebElement ApplyNameTrans = avdriver.findElement(By.id("goToNameTrans"));
			ApplyNameTrans.click();
			Thread.sleep(4000);
			
			JavascriptExecutor jas = (JavascriptExecutor) avdriver;  
			jas.executeScript("window.scrollBy(0,550)");
						
			Select ModAcquisition = new Select(avdriver.findElement(By.id("Acquisition")));
			ModAcquisition.selectByVisibleText("Gift deed (ભેટ ખત)");
			Thread.sleep(2000);
			
			WebElement uploadDoc = avdriver.findElement(By.id("AcquisitionDocument"));
			uploadDoc.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\NewPDF\\WorkCompletionCertificate.pdf");
			Thread.sleep(2000);
			
			WebElement NewPwner1 = avdriver.findElement(By.id("txtOwnerName1"));
			NewPwner1.clear();
			NewPwner1.sendKeys("AALAY");
			Thread.sleep(2000);
			
			WebElement NewPwner2 = avdriver.findElement(By.id("txtOwnerName2"));
			NewPwner2.clear();
			NewPwner2.sendKeys("MALAY");
			Thread.sleep(2000);
			
			WebElement NewPwner3 = avdriver.findElement(By.id("txtOwnerName3"));
			NewPwner3.clear();
			NewPwner3.sendKeys("PRALAY");
			Thread.sleep(2000);
			
			WebElement NewPwner4 = avdriver.findElement(By.id("txtOwnerName4"));
			NewPwner4.clear();
			NewPwner4.sendKeys("GNALAY");
			Thread.sleep(2000);			
			
			WebElement OccupierName = avdriver.findElement(By.id("txtOccupierName"));
			OccupierName.clear();
			OccupierName.sendKeys("OCCUPIER AJ");
			Thread.sleep(2000);
			
			WebElement MyMobile =avdriver.findElement(By.id("txtMobileNo"));
			MyMobile.clear();
			MyMobile.sendKeys("8905252328");
			Thread.sleep(2000);			
			
			WebElement PostalAddress1 =avdriver.findElement(By.id("txtAdress"));
			PostalAddress1.clear();
			PostalAddress1.sendKeys("19,SMC ICCC Near Breadliner circle,");
			Thread.sleep(2000);
					
			WebElement PostalAddress2 =avdriver.findElement(By.id("txtPostalAdress2"));
			PostalAddress2.clear();
			PostalAddress2.sendKeys("BAJRANG NAGAR,KARADVA RD,DINDOLI,SURAT.");
			Thread.sleep(2000);
			
			Select ApplicationID = new Select(avdriver.findElement(By.id("IdentityProofId")));
			ApplicationID.selectByVisibleText("Passport (પાસપોર્ટ)");
			Thread.sleep(2000);
			
			WebElement UploadIDDoc = avdriver.findElement(By.id("IdentityProof"));
			UploadIDDoc.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\NewPDF\\PassPort.pdf");
			Thread.sleep(2000);
			
			WebElement MyCaptcha = avdriver.findElement(By.id("CaptchaInputText"));
			MyCaptcha.click();
			Thread.sleep(10000);
						
			//WebElement finalSubmit =avdriver.findElement(By.id("btnSubmit"));
			//finalSubmit.click();
			//Thread.sleep(3000);
						
			/*
			 * String PreMsg
			 * ="Your Senior Citizen Tax Rebate request already  exists. You can try this after it's done."
			 * ; String ActualMsg=avdriver.findElement(By.
			 * xpath("//span[contains(text(),'Your Senior Citizen Tax Rebate request already exi')]"
			 * )).getText();
			 * 
			 * 
			 * if(ActualMsg.equals(PreMsg)) {
			 * 
			 * System.out.println("THIS IS THE MESSAGE "); }
			 */
			
			
			
		}
}
