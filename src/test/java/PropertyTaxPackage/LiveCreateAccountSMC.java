package PropertyTaxPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveCreateAccountSMC {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver ajDriver= new ChromeDriver();
		ajDriver.manage().window().maximize();
		Thread.sleep(2000);
		
		ajDriver.get("https://www.suratmunicipal.gov.in/OnlineServices/");
		Thread.sleep(2000);
		
			
		WebElement clickNewAccount =ajDriver.findElement(By.className("main-nav-signup-btn"));
		clickNewAccount.click();
		
		
	}

}
