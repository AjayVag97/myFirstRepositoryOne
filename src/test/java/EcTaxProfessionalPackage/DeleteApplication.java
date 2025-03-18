package EcTaxProfessionalPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteApplication 
{
	//ChromeDriver avdriver = new ChromeDriver();
	
	public void AppDeletMethod(ChromeDriver avdriver) throws InterruptedException  // To call in same browser 
	 {
		 System.out.println("DELETE APPLICATION FUNCTION CALLED SUCCESS");
		 
		 String ApplicationNum=avdriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		
		 // ApplicationNum.click();
		 
		 WebElement searchApp =avdriver.findElement(By.xpath("//*[@id='tblPrTaxECStatus_filter']/label/input"));
		 searchApp.sendKeys(ApplicationNum);
		 Thread.sleep(2000);
		 
		 WebElement clkDelet =avdriver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[2]"));
		 clkDelet.click();
		 Thread.sleep(2000);
		 
		 WebElement YesClkDel =avdriver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		 YesClkDel.click();
		 Thread.sleep(2000); 
		 			 
		 System.out.println("YOUR DUMMY APPLICATION DELETED SUCCESSFULLY !");
	 } 
	 
}
