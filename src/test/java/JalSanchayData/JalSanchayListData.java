package JalSanchayData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.Action;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Debug;

public class JalSanchayListData 
{

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		// TODO Auto-generated method stub
		
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.get("https://jsactr.mowr.gov.in/jsjb.aspx"); // STAGE SITE 
		Thread.sleep(6000);
						
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,350)");
		
		WebElement email= driver.findElement(By.id("txtLoginId"));
		email.sendKeys("commissioner@suratmunicipal.gov.in");
		Thread.sleep(1000);	
		
		WebElement password= driver.findElement(By.id("txtPassword"));
		password.sendKeys("Mowr@1234");
		Thread.sleep(5000);
		
		WebElement myCaptch= driver.findElement(By.id("txtCaptcha"));
		myCaptch.click();
		Thread.sleep(6000);
				
		WebElement submtBtn= driver.findElement(By.id("btnSubmit"));
		submtBtn.click();
		Thread.sleep(4000);	
		
		WebElement AddUpdtaeJalSanchayMenu = driver.findElement(By.xpath("//span[contains(text(),'Add/Update Jal Sanchay')]"));
		AddUpdtaeJalSanchayMenu.click();
		Thread.sleep(5000);
		
		/*
		 * WebElement CloseBtn= driver.findElement(By.xpath("//input[@id='btnClose']"));
		 * CloseBtn.click(); Thread.sleep(2000);
		 */
			
		WebElement SearchBtn= driver.findElement(By.xpath("//input[@id='btnsearch']"));
		SearchBtn.click();
		Thread.sleep(5000);
	
		WebElement mytable = driver.findElement(By.id("gvData"));
		int numberOfRows = mytable.findElements(By.tagName("tr")).size();
		System.out.println("TOTAL ROW COUNTS : "+numberOfRows);
		Thread.sleep(4000);
		
	
		// Locate the table
        WebElement mytable1 = driver.findElement(By.id("gvData"));

        // Fetch all rows of the table
        List<WebElement> rows = mytable1.findElements(By.tagName("tr"));

        // Iterate through each row
        for (WebElement row : rows) 
        {
            // Fetch all cells in the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Iterate through each cell and print the text
            for (WebElement cell : cells) 
            {
                System.out.print(cell.getText() + "\t");
                Thread.sleep(3000);
            }
            System.out.println();
        }
        
        
     // Locate the table element (use an appropriate locator)
        WebElement table = driver.findElement(By.id("gvData"));  // Adjust the locator as per your page
        // Execute JavaScript to scroll the table to the right-most column
        JavascriptExecutor jsh = (JavascriptExecutor) driver;
        // Get the scrollable width of the table and scroll to the last column
        jsh.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", table);
        System.out.println("Page scrolled horizontal success.");
        Thread.sleep(2000);
                       
        WebElement clkEdit= driver.findElement(By.xpath("//tbody/tr[2]/td[21]/a[1]"));
        clkEdit.click();
		Thread.sleep(5000);
		
		//Getting current page URL 
		String strUrl = driver.getCurrentUrl();
		System.out.println("Page Current URL is : " +strUrl);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F12);
		robot.keyRelease(KeyEvent.VK_F12);
		Thread.sleep(5000);
	    System.out.println("CONSOLE OPENED SUCCESSFULLY.");
		

		/*
		WebElement myimages = driver.findElement(By.xpath("//img[@id='image1']"));
		String path = myimages.getAttribute("src");
		System.out.println("All the image list : " +path);
		*/
		 // 2. Get all image elements on the page
        List<WebElement> images = driver.findElements(By.tagName("img"));

        // Print the src attribute of each image
        System.out.println("Images on the page:");
        for (WebElement image : images) 
        {
            String imgSrc = image.getAttribute("src");
            System.out.println("All the image list : " +imgSrc);  // Print the image URL (src)
        }
		
		
		//Getting IMAGE list of the page 
		//List<WebElement> images = driver.findElements(By.xpath("//img[@id='image1']"));
		//System.out.println("All the image list : " +images);
		
		
		//Open console page 
		String openDevTools = Keys.chord(Keys.ALT, Keys.CONTROL, "i");
		driver.findElement(By.tagName("body")).sendKeys(openDevTools);
		Thread.sleep(10000);

		// Printing the content of the entire page
        //String pageContent = driver.findElement(By.xpath("/html/body")).getText();
        String pageContent = driver.findElement(By.xpath("//body/form[@id='form1']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).getText();
        System.out.println(pageContent);
		
		/*	
		// Create a new Excel workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Page Details");

        // Create header row in Excel
        sheet.createRow(0).createCell(0).setCellValue("Sr No");
        sheet.getRow(0).createCell(1).setCellValue("Page Title");
        sheet.getRow(0).createCell(2).setCellValue("Other Details");

        // Find elements containing page IDs and other details
        List<WebElement> pages = driver.findElements(By.cssSelector(".page-link"));  // Change selector accordingly

        // Loop through each page and extract details
        int rowNum = 1;
        for (WebElement page : pages) 
        {
            String pageId = page.getAttribute("data-id");  // Replace with actual attribute that holds the page ID
            String pageTitle = page.getText();  // Replace with actual text or attribute for title
            String otherDetails = "Some other detail"; // Replace with actual details you want to scrape

            // Create a new row and insert the page details
            sheet.createRow(rowNum).createCell(0).setCellValue(pageId);
            sheet.getRow(rowNum).createCell(1).setCellValue(pageTitle);
            sheet.getRow(rowNum).createCell(2).setCellValue(otherDetails);
            rowNum++;
        }

        // Save the Excel file
        try (FileOutputStream fileOut = new FileOutputStream("PageDetails.xlsx")) 
        {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully!");
        }
*/
        // Close the browser
        //driver.quit();
    }
}