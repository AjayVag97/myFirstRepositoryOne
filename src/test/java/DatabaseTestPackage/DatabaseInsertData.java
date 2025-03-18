package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

//WORKING DATA INSERTED INTO TABLE OF MSSQL SERVER   
public class DatabaseInsertData 
{
  @Test
  public void InsertData() throws SQLException 
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
			
		  String InsertQuery = "INSERT into HumanResources.EmployeeDataSelenium(EmpId,FNAME,LNAME,GENDER,MOBILE,BIRTHDATE,CITY,COUNTRY) values(?,?,?,?,?,?,?,?)";
		
		  PreparedStatement statement = conn.prepareStatement(InsertQuery);
     
      	  statement.setInt(1, 13);
      	  statement.setString(2, "ANAika");
      	  statement.setString(3, "Vgh");
      	  statement.setString(4, "FeMale");
      	  statement.setString(5, "5533741012");
      	  statement.setString(6, "2001-02-02");
      	  statement.setString(7, "Pune");
      	  statement.setString(8, "INDIA");
      	 
      	 int rowsInserted = statement.executeUpdate();
         System.out.println("Total Data = " +rowsInserted );
      	 
      	 if (rowsInserted > 0) 
      	 {
      	    System.out.println(" New Employee is inserted successfully!");
      	 }
      }
  }
}