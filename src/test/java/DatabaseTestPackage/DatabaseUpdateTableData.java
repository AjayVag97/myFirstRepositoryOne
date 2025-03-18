package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseUpdateTableData 
{
	//WORKING DATA UPDATED INTO TABLE OF MSSQL SERVER   
  @Test
  public void updateTabular() throws SQLException 
  {
	  String connectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
		
	  // Check if the connection is successful
	  Connection conn = DriverManager.getConnection(connectionUrl);

	  if (conn == null) 
	  {
		System.out.println("Connection FAILED ");
	  } 
	  else
	  {
			System.out.println("Database Connection Successful");
			
			//String selectSql = "select * from HumanResources.Employee";
			String updateQuery = "UPDATE HumanResources.EmployeeDataSelenium SET FNAME = ?, LNAME = ?,GENDER =? WHERE EmpId = ? ";
			//String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
			
			PreparedStatement stmt = conn.prepareStatement(updateQuery);

	        // Set the parameters for the update query
			
	        stmt.setString(1,"Vikas"); 
	        stmt.setString(2,"Gawik");
	        stmt.setString(3,"Male");
	        stmt.setInt(4, 11);
	        
	        // Execute the update query
	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) 
	        {
	            System.out.println("An existing user was updated successfully!");
	        }
		}
  }
}

