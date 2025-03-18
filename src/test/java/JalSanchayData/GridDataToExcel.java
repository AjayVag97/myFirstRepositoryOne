package JalSanchayData;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GridDataToExcel 
{
    public static void main(String[] args) throws IOException
    {
        // Set up WebDriver
    	ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);

        // Navigate to the page containing the grid/list
        driver.get("https://example.com");  // Replace with your URL

        // Locate the grid (in this case, a table)
        WebElement table = driver.findElement(By.id("gridId")); // Adjust the locator based on your page

        // Get all rows in the table (assuming each record is in a row)
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Create a new Excel workbook and sheet
        Workbook workbook = new Workbook();
        Sheet sheet = workbook.createSheet("Grid Data");

        // Loop through each row and extract data
        int rowNum = 0;
        for (WebElement row : rows) 
        {
            // Create a new Excel row
            Row excelRow = sheet.createRow(rowNum++);
            List<WebElement> cells = row.findElements(By.tagName("td")); // Extract each cell in the row

            // Check if it's not an empty row (e.g., header)
            if (cells.size() > 0) {
                int cellNum = 0;
                for (WebElement cell : cells) 
                {
                    // Create a new Excel cell and write data to it
                    Cell excelCell = excelRow.createCell(cellNum++);
                    excelCell.setCellValue(cell.getText());
                }
            }
        }

        // Write the data to an Excel file
        FileOutputStream fileOut = new FileOutputStream(new File("grid_data.xlsx"));
        workbook.write(fileOut);
        fileOut.close();

        // Close the browser
        driver.quit();
        
        System.out.println("Grid data has been successfully exported to Excel.");
    }
}
