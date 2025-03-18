package TestNGCodePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NameTransferWithTestng 
{
		ChromeDriver avdriver =new ChromeDriver();
		
		@BeforeTest
	    public void browserLauch() throws InterruptedException 
		{ 	
			avdriver.manage().window().maximize();			
			avdriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
			Thread.sleep(3000);	
		}
		
		@Test(priority = 0)
		public void loginUser() throws InterruptedException 
		{		 
		  WebElement email = avdriver.findElement(By.id("txtEmail"));
		  email.sendKeys("nitin.borse@silvertouch.com");
		  Thread.sleep(1000);
			
		  WebElement psd = avdriver.findElement(By.id("txtPassword"));
		  psd.sendKeys("Nitin123");
							
		  avdriver.findElement(By.xpath("//button[@type='submit']")).click();
		  Thread.sleep(3000);
		}
	    
		@Test(priority = 1)
		public void loginUserSearching() throws InterruptedException 
		{
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
	  	}
	  
	 	@Test(priority = 2)
	 	public void tenementNumber() throws InterruptedException
	 	{
		 	  
		    avdriver.findElement(By.id("txtWard")).sendKeys("073");
			Select subWard = new Select(avdriver.findElement(By.id("drpSubWard")));
			subWard.selectByVisibleText("D");
			avdriver.findElement(By.id("txtLoaction")).sendKeys("07");
			avdriver.findElement(By.id("txtOwner")).sendKeys("1731");
			avdriver.findElement(By.id("txtSubOwner")).sendKeys("0");
			avdriver.findElement(By.id("txtOccupier")).sendKeys("002");
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
	  	}	 	  	
	 
	 	@Test(priority = 3)
	 	public void aaNameTransferdetails() throws InterruptedException
	 	{
	 		// scroll DOWN  
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
			Thread.sleep(4000);
			
			 // scroll to the top 
			JavascriptExecutor jass = (JavascriptExecutor) avdriver;  
			jass.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(3000);
						
			/*
			WebElement MyCaptcha = avdriver.findElement(By.id("CaptchaInputText"));
			MyCaptcha.click();
			Thread.sleep(10000);
			
			WebElement finalSubmit =avdriver.findElement(By.id("btnSubmit"));
			finalSubmit.click();
			Thread.sleep(3000);
			
			WebElement confirmYes =avdriver.findElement(By.id("submitaction"));
			confirmYes.click();
			Thread.sleep(4000);
			*/
			
	  	}
	 	
	 	@Test(priority = 4)
	 	public void xyzSearchClick() throws InterruptedException
	 	{
	 		 		
	 		WebElement clickMenu =avdriver.findElement(By.xpath("//*[@id='NameTransferApplication']/div/div/div[2]/div/ul/li[7]/a"));
			clickMenu.click();
			Thread.sleep(4000);			
			
           String myApplication =avdriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
           System.out.println("YOUR APPLICATION NUMBER =" +myApplication);
           
           WebElement myAppNumber = avdriver.findElement(By.xpath("//*[@id='tblApplicationList_filter']/label/input"));
           myAppNumber.click(); 
           myAppNumber.sendKeys(myApplication); 
           Thread.sleep(2000); 
           
           WebElement myAppClick = avdriver.findElement(By.xpath("//tbody/tr[1]/td[1]/a"));
           myAppClick.click(); 
           Thread.sleep(2000); 
           
           // Scroll DOWN  
           JavascriptExecutor jas = (JavascriptExecutor) avdriver;  
           jas.executeScript("window.scrollBy(0,550)");
           
	 	}
      
	 	//Using @Ignore at the method level is functionally equivalent to @Test(enabled=false).
	 	@Ignore
	    //@AfterTest
	    public void terminateBrowser()
	    {
	         avdriver.close();
	    }
	 
}


