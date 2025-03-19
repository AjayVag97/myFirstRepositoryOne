package DatabaseTestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//WORKING FETCH DATABASE from TABLE  
public class DatabaseFetchTable 
{
	@Test
	// @BeforeClass
	public void ViewRetriveTable() throws ClassNotFoundException, SQLServerException, SQLException 
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
			System.out.println("Database Connection Successful.");
				
			Statement statement = conn.createStatement();
	        String query = "select * from HumanResources.Employee";
	        ResultSet resultSet1 = statement.executeQuery(query);
			
			// Iterate through the result set and print worker details
			while (resultSet1.next())
			{
				int empBId = resultSet1.getInt("BusinessEntityID");
				String empNID = resultSet1.getString("NationalIDNumber");
				String empPosition = resultSet1.getString("JobTitle");
				String empBirth = resultSet1.getString("BirthDate");
				int empVacHr = resultSet1.getInt("VacationHours");
				String empGender = resultSet1.getNString("Gender");

				// Print worker details
				System.out.println("Business Entity ID:"+empBId+"| National ID Number:"+empNID+"| Birth Date:"+empBirth+"| Job Title:"+empPosition+"| Vacation Hours:"+empVacHr+"| Gender :"+ empGender );
			}
		}
	}
}
	/*
	@Test
	public void retrieveEmployeeFromDatabase() throws ClassNotFoundException 
	{
		//this.conn=conn;
		try 
		{
			 if(this.connection == null || this.connection.isClosed()) 
			 { 
				 throw new  IllegalStateException("Connection is not initialized or closed."); 
			 }
			 
			 Statement statement = this.connection.createStatement();
			
  
			// Create and execute a SELECT SQL statement.
			String selectSql = "select * from HumanResources.Employee";
			ResultSet resultSet = statement.executeQuery(selectSql);

			System.out.println("TEST CONNECT");

			// Iterate through the result set and print worker details
			while (resultSet.next())
			{
				int empBId = resultSet.getInt("BusinessEntityID");
				String empNID = resultSet.getString("NationalIDNumber");
				String empPosition = resultSet.getString("JobTitle");
				String empBirth = resultSet.getString("BirthDate");
				int empVacHr = resultSet.getInt("VacationHours");
				String empGender = resultSet.getNString("Gender");

				// Print worker details
				System.out.println("BusinessEntityID:"+empBId+",NationalIDNumber:"+empNID+",BirthDate:"+empBirth+",JobTitle:"+empPosition+",VacationHours:"+empVacHr+",Gender:"+ empGender);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
 
	// @AfterClass
	@Test
	public void closeDatabaseConnection() 
	{
		// Close the database connection
		if (connection != null)
		{
			try 			
			{
				System.out.println("Closing Database Connection...");
				connection.close();

			} 
			catch (Exception error) 
			{
				error.printStackTrace();
			}
		}
	}*/
//}

//This is new changes new chnages with new data   new repor 