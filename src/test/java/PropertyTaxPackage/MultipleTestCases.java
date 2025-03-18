package PropertyTaxPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleTestCases
{

	WebDriver driver = new ChromeDriver();
	String username = "8460477210"; // Change to your username and password
	String password = "swati";

	
	@BeforeClass
	public void init() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://10.11.0.8/VehicleTaxDealerTest/User/Login");
		//driver.navigate().to("http://10.11.0.8/VehicleTaxDealerTest/User/Login");
		Thread.sleep(2000);
		System.out.println("1-BROWSER OPENED WORKING");
	}

	@Test
	public void login() throws InterruptedException 
	{
		
		WebElement uname=driver.findElement(By.xpath("//input[@id='txtMobileNo']"));
		uname.sendKeys(username);
		Thread.sleep(2000);
		
		WebElement upassword=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		upassword.sendKeys(password);		
		Thread.sleep(11000); // Enter CAPTCHA Manually
		
		driver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/section[1]/div[1]/form[1]/div[5]/button[1]")).click();
		Thread.sleep(7000);
		
		System.out.println("2-USER LOGIN WORKING");
		//driver.close();
			
	}
	
	@Test
	public void masterToNewVehcileClick() throws InterruptedException 
	{
		WebElement plin=driver.findElement(By.xpath("//header//div[2]//div[2]//div[1]//a"));
		plin.click();		
		Thread.sleep(3000);
					
		driver.findElement(By.xpath("//a[contains(text(),'New Vehicle Registration')]")).click();
		Thread.sleep(3000);
		System.out.println("3-MASTER MENU AND SUB MENU CLICKED ");
	}

	@Test
	public void newVehcileForm() throws InterruptedException 
	{
		
			WebElement ChasisNum=driver.findElement(By.xpath("//input[@id='txtChasisNo']"));
			ChasisNum.sendKeys("963963");   // 963963 //258261
			ChasisNum.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			WebElement EngineNum=driver.findElement(By.xpath("//input[@id='txtEngineNo']"));
			EngineNum.sendKeys("258258");   //258258 // 963961
			EngineNum.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			
			/*				
			try
			{
				WebElement RequireOK=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
				RequireOK.click();	
			}
			catch(Exception e)
			{
				System.out.println("Somthing not found");
			}
			*/					
		
			WebElement RtoRegNum=driver.findElement(By.xpath("//input[@id='txtRTORegNo']"));
			RtoRegNum.sendKeys("AA-91-AA-9123");
			Thread.sleep(2000);
					
			WebElement RtoRegDate=driver.findElement(By.xpath("//input[@id='txtRTORegDate']"));
			RtoRegDate.click();
			RtoRegDate.sendKeys("01/01/2024");
			RtoRegDate.sendKeys(Keys.TAB);
			
			WebElement BillDate=driver.findElement(By.xpath("//input[@id='txtBillDate']"));
			BillDate.click();
			BillDate.sendKeys("10/01/2024");
			BillDate.sendKeys(Keys.TAB);
			Thread.sleep(2000);
									
			Select CompanyCode = new Select(driver.findElement(By.id("drpCompanyCode")));
			CompanyCode.selectByVisibleText("Bajaj Tempo Ltd.");
			Thread.sleep(2000);
			
			Select ModelCode = new Select(driver.findElement(By.id("drpModelCode")));
			ModelCode.selectByVisibleText("KARGO KING PICK UP");
			Thread.sleep(2000);
			
			Select VehicleTyope = new Select(driver.findElement(By.id("drpVehicleType")));
			VehicleTyope.selectByVisibleText("PRIVATE MOTOR CAR/JEEP CAR");
			Thread.sleep(2000);
			
			WebElement TxnAmount=driver.findElement(By.id("txtNetAmount"));
			TxnAmount.sendKeys("9999999");
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,450)");
			
			WebElement OwnerName=driver.findElement(By.id("txtOwnerName"));
			OwnerName.sendKeys("ALEXA PARKER");
			Thread.sleep(2000);
			
			WebElement adreess=driver.findElement(By.id("txtAddress"));
			adreess.sendKeys("2512, rojer building "+ "Someshwar road,");
			Thread.sleep(2000);
						
			WebElement city=driver.findElement(By.id("txtCity"));
			city.sendKeys("SURAT");
			Thread.sleep(2000);
			
			WebElement ZipCode=driver.findElement(By.id("txtZipcode"));
			ZipCode.sendKeys("395010");
			Thread.sleep(2000);
								
			WebElement submitButton=driver.findElement(By.id("btnSubmit"));			
			submitButton.click();		
			Thread.sleep(4000);		
			
			WebElement confirtmYES=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));			
			confirtmYES.click();		
			Thread.sleep(5000);
			
			try 
			{				
				String mystring = "Please enter valid Chasis No. And Engine No.";
							
				String receivedstring = driver.findElement(By.xpath("//div[contains(text(),'Please enter valid Chasis No. And Engine No.')]")).getText();
				System.out.println("RECEIVED ERROR MESSAGE  =" + receivedstring);
					
				if(mystring.equals(receivedstring))
				{
					WebElement existYetOK=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
					existYetOK.click();
					System.out.println("ALREADY EXISTING CHASHIS NO. AND ENGIN NO.");
				}
				else
				{
					WebElement YES=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));			
					YES.click();		
					Thread.sleep(5000);
					System.out.println("BOTH CHASHIS NO. AND ENGIN NO. ARE  DIFFERENT");
					System.out.println("4-NEW VEHICLE REGISTER CREATED ");
				}
				
			}
			catch(Exception e)
			{
				System.out.println("CHASIS NO. & ENGINE NO. ALREADY EXISTING");
			}
			
			
			
			
	}

	
	@Test
	public void searchVehicle() throws InterruptedException
	{
		WebElement search= driver.findElement(By.xpath("//body/div[@id='dvMainBody']/div[1]/section[1]/section[1]/div[2]/div[2]/div[1]/div[1]/label[1]/input[1]"));
		search.click();		
		
		search.sendKeys("ALEXA owner");
		
		String PayStatus=driver.findElement(By.xpath("//span[contains(text(),'Unpaid')]")).getText();
		String NewPayStatusA="Unpaid";
	//=============================================================	
		//No.of Cols 
		List <WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of columns are : " +col.size()); 
        
        //No.of Rows 
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
	
		
		if(PayStatus.equals(NewPayStatusA))
		{
			System.out.println("PAYMENT STATUS IS = " +NewPayStatusA);
		}
		else
		{
			System.out.println("PAYMENT STATUS IS = " +PayStatus);
		}
		System.out.println("5-SEARCHED AND COMPARE PAYMENT STATUS");
		
	}
		
	
	@Test
	public void userLogout() throws InterruptedException
	{
			
		WebElement userProfile=driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]"));
		userProfile.click();		
		Thread.sleep(5000);
		
		WebElement userLogout=driver.findElement(By.xpath("//a[@id='lbLogout']"));
		userLogout.click();		
		Thread.sleep(3000);	
	
		System.out.println("6-LOGOUT BROWSER 1");
	}
	

	@Test
	//@AfterClass
	public void zquit() 
	{
		driver.close();
		System.out.println("FINALLY BROWSER CLOSED");
	}
}
