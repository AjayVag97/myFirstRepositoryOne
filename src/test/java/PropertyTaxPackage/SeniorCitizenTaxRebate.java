package PropertyTaxPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//SENIOR CITIZEN TAX REBATE DONE OR NOT IF NOT THEN GOING TO CALL THIS FUNCTION  = WORKING on STAGE 
public class SeniorCitizenTaxRebate 
{
	public void seniorcitizn(ChromeDriver radriver) throws InterruptedException
	{		
		System.out.println("METHOD CALL SUCCESS FROM REASSESSMENT");
		
		WebElement seniorcximenu=radriver.findElement(By.xpath("//a[contains(text(),'Senior Citizen Tax Rebate Application')]"));
		seniorcximenu.click();
		Thread.sleep(3000);		
		
		WebElement clickmysenior=radriver.findElement(By.xpath("//a[contains(text(),'Apply Senior Citizen Tax Rebate Application')]"));
		clickmysenior.click();
		Thread.sleep(2000);		
				
							
				//ENTER TENENT NUMBER as per need   073-D-07-0691-0-001	 == Already Sent for Reassessment.
				//2 B 19 881 0 1  == Senior Citizen Tax Rebate request already exists.
				//5 B 1 281 0 1   == Addition of construction of new Reassessment.
				
				radriver.findElement(By.id("txtWard")).sendKeys("073");
				Select subWard = new Select(radriver.findElement(By.id("drpSubWard")));
				subWard.selectByVisibleText("D");
				radriver.findElement(By.id("txtLoaction")).sendKeys("07");
				radriver.findElement(By.id("txtOwner")).sendKeys("0035");
				radriver.findElement(By.id("txtSubOwner")).sendKeys("0");
				radriver.findElement(By.id("txtOccupier")).sendKeys("1");
				radriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
				Thread.sleep(2000);
				
				//Enter Answer here Manually calculate
				radriver.findElement(By.xpath("//*[@id='CaptchaInputText']")).click();
				Thread.sleep(10000);
						
				radriver.findElement(By.id("btnSubmit")).click();
				Thread.sleep(5000);
				
				JavascriptExecutor js = (JavascriptExecutor) radriver;  
				js.executeScript("window.scrollBy(0,300)");
				
				//Select Applicant ID 
				Select SrAgeType = new Select(radriver.findElement(By.id("SeniorCitizenDocumentType")));
				SrAgeType.selectByVisibleText("Birth Certificate (જન્મ પ્રમાણપત્ર)");
				Thread.sleep(1000);
				
				WebElement uploadID = radriver.findElement(By.id("SeniorCitizenDocument"));
				uploadID.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
				Thread.sleep(2000);
				
				WebElement myRemark = radriver.findElement(By.id("Remark"));
				myRemark.sendKeys("THIS IS TESTING REMARK FOR SENIOR CITIZEN");
				Thread.sleep(2000);
				
				//Enter Mobile Number 
				WebElement mynum=radriver.findElement(By.id("MobileNo"));
				mynum.clear();
				mynum.sendKeys("8905252328");
				Thread.sleep(2000);
				
				// FINAL SUMBIT NOT ALLOWED BY ME 
				radriver.close();
				
				//Click on VERIFY MOBILE NO. button
				WebElement ClickVerifyMob=radriver.findElement(By.id("btn_verify"));
				ClickVerifyMob.click();
				Thread.sleep(15000);
				//Enter manually your OTP will take time here  
				
				
				
				WebElement VerifyMobOTP = radriver.findElement(By.id("btnVerifyOTP"));
				VerifyMobOTP.click();
				Thread.sleep(2000);
				
				
		
				System.out.println("YOU ALREADY REQUESTED FOR SENIOR CITIZEN TAX REBATE, PLEASE WAIT FOR MORE DAYS");
		
	}

}
