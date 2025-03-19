package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseWithAllQuery 
{
  @Test
  public void updateTable() throws SQLException  
  {
	  String userDBlogin = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
	  
	  Connection DbConn =DriverManager.getConnection(userDBlogin);
	 
	  if (DbConn==null)
	  {
		  System.out.println("Database Connection issue! ");
	  }
	  else
	  {
		  String myquery ="UPDATE HumanResources.EmployeeDataSelenium SET FNAME=?,LNAME=?,CITY=? where EmpId=?";
		  
		  PreparedStatement mystmt=DbConn.prepareStatement(myquery);
		  
		  mystmt.setString(1, "AALAY");
		  mystmt.setString(2, "VAGAM");
		  mystmt.setString(3, "MUMBAI");
		  mystmt.setInt(4, 9);
		  
		  int rowdata=mystmt.executeUpdate();
		  if(rowdata>0)
		  {
			  System.out.println("User Data updated successfully");
		  }
	  	}
	  }
  
	  @Test
	  public void CreateTable() throws SQLException
	  {
		  
		String DbserverConn="jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWork2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";

		Connection DbConn2=DriverManager.getConnection(DbserverConn);
		
		if(DbConn2==null)
		{
			System.out.println("Connection failed");
		}
		else
		{
			System.out.println("Connection Done. ");
			
			String myquery1 ="Create table Humanresources.EmployeeDataSeleniumTwo(EmpID int Primary Key,NAME varchar(60),MOBILE varchar(60),EMAIL varchar(60),CITY varchar(60),COUNTRY varchar(60)";
			
			Statement myst =DbConn2.createStatement();
			//int result = statement.executeUpdate(myquery1);
			
		}
	}
}
		  
		  