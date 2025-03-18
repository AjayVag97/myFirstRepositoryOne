package EcTaxProfessionalPackage;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//NEW EC REGISTRATION APPLICATION AND SAVED INTO DRAFT AND THEN DELETED FROM LISTING PAGE = WORKING on STAGE.  
public class EcNewRegistartion 
{
	public static void main(String[] args) throws InterruptedException, AWTException
	{
    	ChromeDriver avdriver = new ChromeDriver();
		avdriver.manage().window().maximize();
		Thread.sleep(2000);
		
		avdriver.get("https://www.suratmunicipal.gov.in/OnlineServices/Home/Login"); // LIVE  SITE 
		
		//avdriver.get("https://www.suratmunicipal.gov.in/mmgy/Home/LogIn"); // STAGE SITE 
		Thread.sleep(3000);
				
		WebElement email = avdriver.findElement(By.id("txtEmail"));
		email.sendKeys("8905252328");
		//email.sendKeys("8460477218");
		Thread.sleep(1000);
		
		WebElement psd = avdriver.findElement(By.id("txtPassword"));
		psd.sendKeys("Ajay@123");
		//psd.sendKeys("Sj123456");
			
		//Click on SIGN IN button 
		avdriver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
				
		WebElement SearchEnroll = avdriver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[1]/div[2]/ul[1]/li[4]/div[1]/div[5]/div[1]/button[1]"));
		SearchEnroll.click();
		Thread.sleep(1000);	
		
		//CLick on NEW REGISTRATION
		WebElement NewRegClk=avdriver.findElement(By.xpath("//a[contains(text(),'New Registration')]"));
		NewRegClk.click();
		Thread.sleep(2000);
		
		//String MyZone ="Central Zone";
		//String Actualzone = avdriver.findElement(By.xpath("//select[@id='drpZone']")).getText();
		
		//Select CENTRAL ZONE  wise flow scripting  
		Select  myzone = new Select(avdriver.findElement(By.xpath("//select[@id='drpZone']")));
		myzone.selectByVisibleText("West Zone");
		Thread.sleep(2000);
		
		//Select Application Type  
		Select  ApplicantionType = new Select(avdriver.findElement(By.xpath("//select[@id='drpRegCategory']")));
		ApplicantionType.selectByVisibleText("New Registration");
		Thread.sleep(2000);		
		
		//YES click for RC registration 
		WebElement YesRcReg=avdriver.findElement(By.xpath("//label[@id='rb-engR']"));
		YesRcReg.click();
		Thread.sleep(2000);
				
		//Enter Profession Tax RC Number 
		WebElement PrfTaxRcNum=avdriver.findElement(By.xpath("//input[@id='txtProfTaxEcNO']"));
		PrfTaxRcNum.sendKeys("1009");
		PrfTaxRcNum.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		//YES click for Shops & Establishment in
		WebElement YesShopEsta=avdriver.findElement(By.id("rbeng"));
		YesShopEsta.click();
		Thread.sleep(2000);
				
		//Click on NEXT button 
		WebElement nxt=avdriver.findElement(By.id("btnnext"));
		nxt.click();
		Thread.sleep(3000);
		
		JavascriptExecutor ps=(JavascriptExecutor)avdriver;
		ps.executeScript("window.scrollBy(0,350)");
		
		//Select SMC ward
		Select  smcWard = new Select(avdriver.findElement(By.id("ddlWards")));
		smcWard.selectByVisibleText("BHESAN");
		Thread.sleep(2000);	
		
		//Select Establishment Category
		Select  EstaCategory = new Select(avdriver.findElement(By.id("drpEstablishmentCategory")));
		EstaCategory.selectByVisibleText("SHOP");
		Thread.sleep(2000);	
		
		//Choose Date 
		WebElement commencDate = avdriver.findElement(By.id("txtCommencementDate"));
		commencDate.click();
		Thread.sleep(1000);
		
		WebElement commencDateClck = avdriver.findElement(By.id("txtCommencementDate"));
		commencDateClck.click();
		Thread.sleep(1000);
		
		//Select Profession type
		Select  BusinessTyp = new Select(avdriver.findElement(By.id("drpEstablishmentType")));
		BusinessTyp.selectByVisibleText("Business");
		Thread.sleep(2000);	
				
		//Select Business category  type
		Select  BusinessCat = new Select(avdriver.findElement(By.id("drpBusinessCategory")));
		BusinessCat.selectByVisibleText("Proprietor");
		Thread.sleep(2000);	
		
		//Enter TurnOver or Income 
		WebElement income = avdriver.findElement(By.id("txtAnnualIncome"));
		income.sendKeys("998800");
		income.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		JavascriptExecutor psp=(JavascriptExecutor)avdriver;
		psp.executeScript("window.scrollBy(0,800)");
		
		// Do you have any other work place?  == NO then below and YES 
		WebElement isChecked = avdriver.findElement(By.id("rb-NoW"));
		boolean nochecked = isChecked.isSelected();
		System.out.println("NO checkbox is selecetd ="+nochecked);
		
		if(nochecked==true)
		{
			System.out.println("NOT WORKING ANY OTHER PLACES NO CHECKED");
			//Enter Owner pincode  
			WebElement OwnerPincode = avdriver.findElement(By.id("EstablishmentAddressDetails_0_PinCode"));
			OwnerPincode.sendKeys("395007");
			Thread.sleep(2000);			
		}
		
		WebElement YesCheck = avdriver.findElement(By.id("rb-YesW"));
		boolean YesReallyCheck = YesCheck.isSelected();
		System.out.println("YES checkbox is selecetd ="+YesReallyCheck);
		
		if(YesReallyCheck==true)
		{
			WebElement OtheplaceWorkCOunt = avdriver.findElement(By.id("Establishmentdetail_OtherWorkPlaceCount"));
			OtheplaceWorkCOunt.sendKeys("1");
			Thread.sleep(2000);
						
			//Enter Owner Pincode  
			WebElement OwnerPincode = avdriver.findElement(By.id("EstablishmentAddressDetails_0_PinCode"));
			OwnerPincode.sendKeys("395007");
			Thread.sleep(2000);
		}
							
			//Click on SAVE and NEXT button 
			WebElement SavNxt1= avdriver.findElement(By.id("btnSaveNextEsta"));
			SavNxt1.click();
			Thread.sleep(3000);
		
			//Just click oK confirmation
			WebElement justok = avdriver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			justok.click();
			Thread.sleep(2000);				
				
			//Select Usage Group Details
			Select  UsgaGroupDetail = new Select(avdriver.findElement(By.id("Establishmentdetail_UsageGroup")));
			UsgaGroupDetail.selectByVisibleText("School");
			Thread.sleep(2000);	
				
			JavascriptExecutor pps=(JavascriptExecutor)avdriver;
			pps.executeScript("window.scrollBy(0,500)");
			
			//Click on SAVE and NEXT button again
			WebElement SavNxt11= avdriver.findElement(By.id("btnSaveNextEsta"));
			SavNxt11.click();
			Thread.sleep(4000);			
		
		  // STEP 2 APPLICANT DETAILS 
						
			//YES click for Owner of the firm
			WebElement YesOwnerFirm=avdriver.findElement(By.id("rb-engA"));
			YesOwnerFirm.click();
			Thread.sleep(2000);
			
			//Enter owner name and details 
			WebElement OwnerName= avdriver.findElement(By.id("Applicantdetail_ApplicantName"));
			OwnerName.sendKeys("AJEXA OWNER");
			Thread.sleep(2000);
			
			//Date birth
			WebElement mydob =avdriver.findElement(By.id("txtBirthDate"));
			mydob.sendKeys("02/02/1990");
			Thread.sleep(2000);
						
			//Enter owner Address all details 
			WebElement OwnerAddres= avdriver.findElement(By.id("ApplicantAddressDetails_0_Address"));
			OwnerAddres.sendKeys("99, ROMAN REIGN BUDING");
			Thread.sleep(2000);
			
			WebElement OwnerAddres1= avdriver.findElement(By.id("ApplicantAddressDetails_0_Address1"));
			OwnerAddres1.sendKeys("BELGIUM TOWER A ");
			Thread.sleep(2000);
			
			WebElement OwnerAddres2= avdriver.findElement(By.id("ApplicantAddressDetails_0_Address2"));
			OwnerAddres2.sendKeys("Railways station");
			Thread.sleep(2000);
			
			WebElement OwnerCity= avdriver.findElement(By.id("ApplicantAddressDetails_0_City"));
			OwnerCity.clear();
			OwnerCity.sendKeys("SURAT");
			Thread.sleep(2000);
			
			WebElement pincode= avdriver.findElement(By.id("ApplicantAddressDetails_0_PinCode"));
			pincode.clear();
			pincode.sendKeys("395009");
			Thread.sleep(2000);
		
			//Enter Owner mobile number
			WebElement OwnerMobil= avdriver.findElement(By.id("Applicantdetail_ApplicantMobileNo"));
			OwnerMobil.clear();
			OwnerMobil.sendKeys("8905252328");
			Thread.sleep(2000);
		
			//Click on VERIFY button  and Enter OTP Manually
			WebElement ClkVerify=avdriver.findElement(By.id("btnMobVerify"));
			ClkVerify.click();
			Thread.sleep(14000);
			
			//ENTER OTP from mobile device 
			
			//After that Click on VERIFYOTP Manually
			WebElement VerifyOTP=avdriver.findElement(By.id("btnVerifyOTP"));
			VerifyOTP.click();
			Thread.sleep(9000);
		
			//Click on SAVE and NEXT button 
			WebElement SaveNxt= avdriver.findElement(By.id("btnSaveNextApp"));
			SaveNxt.click();
			Thread.sleep(2000);	
				
		//STEP 3  PROFESSIONAL PROPERTY DETAILS -Select Tenant Type
		Select  TenantType = new Select(avdriver.findElement(By.id("TenamentDetails_0_TenaType")));
		TenantType.selectByVisibleText("Tenant");
		Thread.sleep(2000);
		
		avdriver.findElement(By.id("TenamentDetails_0_Ward")).sendKeys("073");
		Select subWard = new Select(avdriver.findElement(By.id("TenamentDetails_0_SubWard")));
		subWard.selectByVisibleText("D");
		avdriver.findElement(By.id("TenamentDetails_0_Location")).sendKeys("07");
		avdriver.findElement(By.id("TenamentDetails_0_Owner")).sendKeys("0035");
		avdriver.findElement(By.id("TenamentDetails_0_SubOwner")).sendKeys("0");
		avdriver.findElement(By.id("TenamentDetails_0_OccupierNo")).sendKeys("001");
		//avdriver.findElement(By.id("txtOccupier")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		//Click on VALIDATE button 
		WebElement ClkValidate= avdriver.findElement(By.id("btnValidate_0"));
		ClkValidate.click();
		Thread.sleep(3000);
		
		//Click on SAVE AND NEXT button 
		WebElement ClkSaveNxt= avdriver.findElement(By.id("btnSaveNextTena"));
		ClkSaveNxt.click();
		Thread.sleep(3000);
		
		//STEP 4 Enter PAN , Aadhar card No. and Signature and UPLOAD document   
		WebElement MyPAN = avdriver.findElement(By.id("Applicantdetail_PANNo"));
		MyPAN.sendKeys("ABCDE9999F");
		Thread.sleep(3000);			
		
		WebElement ChooseFilePAN =avdriver.findElement(By.xpath("//input[@id='docAttachment_0']"));
		ChooseFilePAN.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\5PAN_CARD_54KB.pdf");
		Thread.sleep(3000);	
		
		WebElement uploadPAN=avdriver.findElement(By.xpath("//button[@id='btnUpPanDoc']"));
		uploadPAN.click();
		Thread.sleep(3000);
		
		//Enter Aadhar card number and choose Aadhar file to upload 
		WebElement MyAADHAR = avdriver.findElement(By.id("Applicantdetail_AadharNo"));
		MyAADHAR.sendKeys("444455556666");
		Thread.sleep(3000);	
		
		WebElement ChooseFileAADHAR = avdriver.findElement(By.xpath("//input[@id='docAttachment_3']"));
		ChooseFileAADHAR.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\AADHARcard_13KB.pdf");
		
		WebElement uploadAADHAR=avdriver.findElement(By.xpath("//button[@id='btnUpAadharDoc']"));
		uploadAADHAR.click();
		Thread.sleep(3000);		
		
		//Choose SIgnature file and upload 
		WebElement ChooseFileSIGNATURE = avdriver.findElement(By.xpath("//input[@id='docAttachment_2']"));
		ChooseFileSIGNATURE.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\SIGNATUREimg.jpg");
		
		WebElement uploadSIGNATURE=avdriver.findElement(By.xpath("//button[@id='btnUpSignDoc']"));
		uploadSIGNATURE.click();
		Thread.sleep(3000);
		
		//Click on SAVE AND NEXT button 
		WebElement SaveAndNxt= avdriver.findElement(By.id("btnSaveNextAppPrf"));
		SaveAndNxt.click();
		Thread.sleep(9000);
		
		JavascriptExecutor jss = (JavascriptExecutor) avdriver;  
		jss.executeScript("window.scrollBy(0,600)");
					
		//STEP 5  all 7 documents upload 		
		
		//VERA Bill ---------------------------------------
		WebElement VeraFile = avdriver.findElement(By.xpath("//input[@id='imgAttachment_0']"));
		VeraFile.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\1VERA_BILL_15KB.pdf");
		Thread.sleep(2000);
		
		//Click on UPLOAD button for VERA Bill
		WebElement uploadVera=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_0']"));
		uploadVera.click();
		Thread.sleep(3000);
				
		//RENT Agreement ---------------------------------------
		WebElement RentAgreeFile = avdriver.findElement(By.xpath("//input[@id='imgAttachment_1']"));
		RentAgreeFile.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\2RENT_AGREEMENT_15KB.pdf");
		Thread.sleep(2000);
		
		//Click on UPLOAD button for RENT Agreement
		WebElement uploadRentAgree=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_1']"));
		uploadRentAgree.click();
		Thread.sleep(3000);
				
		//LIGHT BILL ---------------------------------------
		WebElement LighBillFile = avdriver.findElement(By.xpath("//input[@id='imgAttachment_2']"));
		LighBillFile.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\3LIGHT_BILL_15KB.pdf");
		Thread.sleep(2000);
								
		//Click on UPLOAD button for LIGHT BILL
		WebElement uploadLightBill=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_2']"));
		uploadLightBill.click();
		Thread.sleep(3000);			
		
		//BUSINESS PURCHASE BILL ---------------------------------------
		WebElement BusinesPurchasFile = avdriver.findElement(By.xpath("//input[@id='imgAttachment_3']"));
		BusinesPurchasFile.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\4BUSINESS_PURCHASE_BILL_15KB.pdf");
		Thread.sleep(2000);
										
		//Click on UPLOAD button for Business BILL
		WebElement uploadBusinessBill=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_3']"));
		uploadBusinessBill.click();
		Thread.sleep(3000);			
				
		//PAN card ---------------------------------------
		WebElement PanChooseFile = avdriver.findElement(By.xpath("//input[@id='imgAttachment_4']"));
		PanChooseFile.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\5PAN_CARD_54KB.pdf");
		Thread.sleep(2000);
												
		//Click on UPLOAD button for PAN file
		WebElement uploadPANfile=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_4']"));
		uploadPANfile.click();
		Thread.sleep(3000);	
		
		//OTHER document---------------------------------------
		WebElement OtherFile6 = avdriver.findElement(By.xpath("//input[@id='imgAttachment_5']"));
		OtherFile6.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\6OTHER_DOCS_15KB.pdf");
		Thread.sleep(2000);
														
		//Click on UPLOAD button for OTHER document 
		WebElement uploadOTHERfile=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_5']"));
		uploadOTHERfile.click();
		Thread.sleep(3000);
		
		//FORM3  document---------------------------------------
		WebElement Form3File7 = avdriver.findElement(By.xpath("//input[@id='imgAttachment_6']"));
		Form3File7.sendKeys("F:\\AVprojects\\XDummyImages\\DummyFiles\\PDF\\7PROFESSIONAL_TAX_EC_FORM_3_187KB.pdf");
		Thread.sleep(2000);
																
		//Click on UPLOAD button for FORM3 document 
		WebElement uploadForm3=avdriver.findElement(By.xpath("//button[@id='btnUpDoc_6']"));
		uploadForm3.click();
		Thread.sleep(3000);
		
		// ALL 7 documents uploaded here 
		
		//Check the Checkbox
		WebElement mycheckbox = avdriver.findElement(By.id("chkConfirm"));
		mycheckbox.click();
		Thread.sleep(1000);
		
		WebElement SaveApp = avdriver.findElement(By.id("btnSaveApplication"));
		SaveApp.click();
		Thread.sleep(2000);	
			
		//CONFIRMATION POPUP to click on OK button
		WebElement OkDraft = avdriver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		OkDraft.click();
		Thread.sleep(5000);		
		System.out.println("YOUR APPLICATION SAVED IN DRAFT");
		
			
		DeleteApplication myobject= new DeleteApplication();
		myobject.AppDeletMethod(avdriver);  // To call in same browser 
		Thread.sleep(3000);
	}
	
}

