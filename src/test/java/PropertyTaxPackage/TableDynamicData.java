package PropertyTaxPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

   //FULL WORKING SCRIPT CODE TILL VEHICLE TAX PAYMENT SUCCESS AND PDF DOWNLOAD 
   //HERY PARKER --- CHANGE PAYERNAME AS PER PAYER NAME WISE WHOLE SCRIPT WORKING ! 
	public class TableDynamicData 
	{
		WebDriver driver = new ChromeDriver();
		String username = "8460477210"; // Change to your username and password
		String password = "swati";
		String payerName ="HERY PARKER";  //HERY PARKER -- CHANGE PAYNAME AS PER PAYER NAME WISE WHOLE SCRIPT WORKING ! 
		
		@BeforeClass
		public void init1() throws InterruptedException
		{
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			driver.get("http://10.11.0.8/VehicleTaxDealerTest/User/Login");
			//driver.navigate().to("http://10.11.0.8/VehicleTaxDealerTest/User/Login");
			Thread.sleep(2000);
			System.out.println("1-BROWSER OPENED WORKING");
		}

		@Test
		public void login1() throws InterruptedException 
		{
			
			WebElement uname=driver.findElement(By.xpath("//input[@id='txtMobileNo']"));
			uname.sendKeys(username);
			Thread.sleep(2000);
			
			WebElement upassword=driver.findElement(By.xpath("//input[@id='txtPassword']"));
			upassword.sendKeys(password);		
			Thread.sleep(11000); // Enter CAPTCHA Manually
			
			driver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/section[1]/div[1]/form[1]/div[5]/button[1]")).click();
			Thread.sleep(3000);
			
			System.out.println("2-USER LOGIN WORKING");
		}
		
		@Test
		public void masterToNewVehcileClick1() throws InterruptedException 
		{
			WebElement plin=driver.findElement(By.xpath("//header//div[2]//div[2]//div[1]//a"));
			plin.click();		
			Thread.sleep(1000);
						
			driver.findElement(By.xpath("//a[contains(text(),'Vehicle Registration Status')]")).click();
			Thread.sleep(2000);
			
			/*
			WebElement search= driver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/div[2]/div[1]/div[1]/label[1]/input[1]"));
			search.click();		
			
			search.sendKeys("ALEXA owner");
			Thread.sleep(3000);
			*/
			System.out.println("3-MASTER MENU AND SUB MENU CLICKED ");
		//}
		//public void numColRosCheck1() throws InterruptedException
		//{
			
			//String PayStatus=driver.findElement(By.xpath("//span[contains(text(),'Unpaid')]")).getText();
			//String NewPayStatusA="Unpaid";

			//No.of Rows
			WebElement TogetRows = driver.findElement(By.xpath("//*[@id=\"tblRegStatusList\"]/tbody"));
				List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));
				System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
				Thread.sleep(2000);

			//No.of Cols 
			WebElement ToGetColumns = driver.findElement(By.xpath("//*[@id=\"tblRegStatusList\"]/thead/tr"));
				List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("th"));
				System.out.println("Total Number of Columns in the table are: "+TotalColsList.size());
				Thread.sleep(2000);
				
			System.out.println("4-TABLE ROW AND COLUMN COUNT");
			WebElement baseTable = driver.findElement(By.tagName("table"));
	        
			 //To find first row of table
			 WebElement tableRow = baseTable.findElement(By.xpath("//tbody//tr[1]"));
	         String rowtext = tableRow.getText();
			 System.out.println("1st ROW DATA :"+rowtext);
			    
			    //to get 1st row's 8th column(Payment Status) data
			    WebElement cellIneed = tableRow.findElement(By.xpath("//tbody//tr[1]//td[8]"));
			    String currStatus = cellIneed.getText();
			    System.out.println("8th COLUMN CELL VALUE : " +currStatus); 
			    	    		
			    String myStatus="Paid";
			    				
				 if(currStatus.equals(myStatus)) 
				 {
					 System.out.println("ACTUAL PAYMENT STATUS IS = " +myStatus); 
				 }
				 else 
				 {
					 System.out.println("PAYMENT STATUS IS = " +currStatus);
					 System.out.println("-------------------------------------------------------------------------------");
					 
					 WebElement masterMenu=driver.findElement(By.xpath("//header//div[2]//div[2]//div[1]//a"));
					 masterMenu.click();		
					 Thread.sleep(1000);
								
					  WebElement submen=driver.findElement(By.xpath("//a[contains(text(),'Pay Pending Vehicle Tax')]"));
					  submen.click();				  
					  Thread.sleep(2000);
					  
					  WebElement search=driver.findElement(By.xpath("//body/div[@id='dvMainBody']/form[@id='frmMakePayment']/div[1]/section[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]"));
					  search.click();
					  search.sendKeys(payerName);					  
					  Thread.sleep(2000);
					  
					  //=========If No Records found for payer====================
					  
					  String noMtach=driver.findElement(By.xpath("//tbody//tr//td")).getText();
					  String myMatch="No matching records found";
					   
					  if(noMtach.equals(myMatch))
					  {
						  WebElement cancBtn=driver.findElement(By.xpath("//*[@id=\"frmMakePayment\"]/div/section/section/div[3]/a"));
						  cancBtn.click();
						  Thread.sleep(2000);
						  System.out.println("STOPPED EXECUTION HERE AND NO MATCHING RECORDS FOUND");
						  System.out.println("-------------------------------------------------------------------------------");
					  }
					  				  
					  				  
					  WebElement allCheckbox=driver.findElement(By.xpath("//input[@id='checkBoxAll']"));
					  allCheckbox.click();
					  Thread.sleep(1000);
					  
					  JavascriptExecutor js = (JavascriptExecutor) driver;  
					  js.executeScript("window.scrollBy(0,450)");
					  
					  WebElement Termscheckbox=driver.findElement(By.xpath("//input[@id='chkAct']"));
					  Termscheckbox.click();
					  Thread.sleep(1000);
					  					  
					  WebElement makePay=driver.findElement(By.xpath("//body/div[@id='dvMainBody']/form[@id='frmMakePayment']/div[1]/section[1]/section[1]/div[3]/button[1]"));
					  makePay.click();
					  Thread.sleep(2000);
					  
					  WebElement confirmPay=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
					  confirmPay.click();
					  Thread.sleep(2000);
					  
					  WebElement eazyPay=driver.findElement(By.xpath("//input[@id='rbtn2']"));
					  eazyPay.click();
					  Thread.sleep(1000);
					  
					  WebElement payNow=driver.findElement(By.xpath("//body/div[@id='dvMainBody']/form[@id='frmMakePayment']/div[1]/div[1]/div[1]/div[1]/div[3]/button[2]"));
					  payNow.click();
					  Thread.sleep(4000);
					  
					  
					  WebElement netBank=driver.findElement(By.xpath("//body/form[@id='TransactionForm']/div[1]/div[4]/div[2]/div[3]/div[3]/div[1]/ul[1]/li[3]/div[1]/span[2]"));
					  netBank.click();
					  Thread.sleep(2000);		
					  driver.close();
					  
					  Select bankName = new Select(driver.findElement(By.id("netBankingBank")));
					  bankName.selectByVisibleText("Avenues Test for New TC");
					  Thread.sleep(2000);
					  
					  WebElement makePayFinal=driver.findElement(By.xpath("//body/form[@id='TransactionForm']/div[1]/div[4]/div[2]/div[3]/div[3]/div[1]/div[1]/div[3]/div[1]/div[5]/span[1]/a[1]"));
					  makePayFinal.click();
					  Thread.sleep(5000);
					  
									
					  WebElement sendResp = driver.findElement(By.xpath("//button[@id='btn']"));
					  sendResp.click();
					  Thread.sleep(11000);
					  
					  //==================					  
					  
					  String txnS1="Success";
					  String txnStatus = driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText();
					  if(txnS1.equals(txnStatus))
					  {
						  WebElement printReceipt = driver.findElement(By.xpath("//a[contains(text(),'Print Receipt')]"));
						  printReceipt.click();
						  Thread.sleep(11000);
						  System.out.println("Payment Status SUCCESS so clicked on PRINT RECEIPT button");
						  
					  }
					  else
					  {
						  
						  WebElement printReceipt = driver.findElement(By.xpath("//tbody/tr[8]/td[1]//a"));
						  printReceipt.getText();
						  printReceipt.click();
						  Thread.sleep(11000);
						  System.out.println("Payment Status FAILLED so clicked on TRY AGAIN button");
					  }
					  			  
					  WebElement backToList = driver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[1]/div[1]/div[2]/div[1]/a[1]"));
					  backToList.click();
					  Thread.sleep(11000);
					  System.out.println("BACK TO PAYMENT LIST");
					 }
					 
				 	//System.out.println("5-SEARCHED AND COMPARE PAYMENT STATUS");
					
		}
	}

	