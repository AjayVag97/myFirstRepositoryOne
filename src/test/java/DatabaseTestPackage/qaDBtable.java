package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class qaDBtable 
{
	 // WITHOUT TESTNG FRAMEWORK 
	 // Connect to your database.
	    public static void main(String[] args) 
	    {
	    	//String  connectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=QADB;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
	    	String  connectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
	    	//ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);
	                Statement statement = connection.createStatement();) 
	        {
	            // Create and execute a SELECT SQL statement.
	            //String selectSql = "select * from dbo.Persons"; 
	            String selectSql = "select * from HumanResources.Employee";
	            ResultSet resultSet = statement.executeQuery(selectSql);  

	            // Print results from select statement
	            while (resultSet.next())
	            {
	                	int empBId = resultSet.getInt("BusinessEntityID");
			            String empNID = resultSet.getString("NationalIDNumber");
			            String empBirth = resultSet.getString("BirthDate");
			            String empPosition = resultSet.getString("JobTitle");
			            int empVacHr = resultSet.getInt("VacationHours");
			                
			            System.out.println("Business Entity ID: " + empBId + ", National ID Number: " + empNID + ", Birth Date: "+ empBirth + ", Job Title: " + empPosition + ", Vacation Hours: " + empVacHr);
		         } 
		         System.out.println("TABLE CONNECTED DATA PRINTED");
	            	
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}