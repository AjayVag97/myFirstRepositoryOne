package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

//WORKING DROP TABLE from DATABASE  
public class DatabaseDropTable 
{
	@Test
    public void DropTable() throws SQLException 
	{
		  String ConnectionUrl2 = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
		  Connection conn2 = DriverManager.getConnection(ConnectionUrl2);
		 
		  // SQL query to drop the table
          String dropTableQuery = "DROP TABLE IF EXISTS HumanResources.EmployeeDataSelenium";  // Replace table name if necessary
    
		  // Create statement and execute the drop table query	
          Statement statement = conn2.createStatement();
          statement.executeUpdate(dropTableQuery);

          System.out.println("Table 'EmployeeDataSelenium' dropped successfully!");
	 }
}

