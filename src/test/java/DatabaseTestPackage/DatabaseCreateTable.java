package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

//WORKING CREATE TABLE in DATABASE  

public class DatabaseCreateTable 
{
  @Test
  public void CreateNewTable() throws SQLException 
  {
	  	String ConnectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";

		// Check if the connection is successful
		Connection conn = DriverManager.getConnection(ConnectionUrl);
				
		if (conn == null) 
		{
			System.out.println("Connection FAILED");
		} 
		else
		{
			System.out.println("Database Connection Successful."); 
						
	        //String createTableQuery  = "CREATE table HumanResources.EmployeeDataSelenium(" +"EmpId INT Primary Key," +"FNAME VARCHAR(50)," +"LNAME VARCHAR(50)"+")";
	        //String createTableQuery  = "CREATE table HumanResources.EmployeeDataSeleniumTEST('EmpId' int Primary Key,'FNAME' VARCHAR(50),'LNAME' VARCHAR(50))";
	        String createTableQuery = "CREATE TABLE HumanResources.EmployeeDataSeleniumTESTER (EmpID int Primary Key,firstname varchar(30), lastname varchar(30), tel integer, email varchar(40), arrive_stamp timestamp)";
	        Statement statement = conn.createStatement();
	        statement.executeUpdate(createTableQuery);
	        	       	        
	        System.out.println(" TABLE CREATED SUCCESSFUL.");
	    }
	  }
}