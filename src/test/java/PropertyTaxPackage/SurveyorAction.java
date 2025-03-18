package PropertyTaxPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

public class SurveyorAction
	{
		public static void main(Strings[] args[]) throws InterruptedException
		{
				
			ChromeDriver aavdriver =new ChromeDriver();
			aavdriver.manage().window().maximize();
					
			String SearchEnroll = aavdriver.findElement(By.xpath("//*[@id='tblApplicationList']/tbody/tr[1]/td[1]/div/text()")).getText();
			System.out.println("My Application Number is : " +SearchEnroll );
			
			WebElement mysearch =aavdriver.findElement(By.xpath("//*[@id='tblApplicationList_filter']/label/input"));
			mysearch.sendKeys(SearchEnroll);
			Thread.sleep(1000);	
			
			WebElement actionclick =aavdriver.findElement(By.id("dropdownMenuLink"));
			actionclick.click();
			Thread.sleep(1000);	
			
			WebElement ViewClick =aavdriver.findElement(By.xpath("//*[@id=\"tblApplicationList\"]/tbody/tr/td[7]/div/ul/li[1]/a"));
			ViewClick.click();
			Thread.sleep(3000);
			
			//For Scroll down:
			//JavascriptExecutor jsss = (JavascriptExecutor) aavdriver;  
			//jsss.executeScript("window.scrollBy(0,1000)");
			
			//Scrolling to the bottom of a page:
			JavascriptExecutor js = ((JavascriptExecutor) aavdriver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					
			WebElement documentscrutiny = aavdriver.findElement(By.xpath("//*[@id='btn_DocumentScrutiny']/a"));
			documentscrutiny.click();
			Thread.sleep(2000);
		}
			
	}
