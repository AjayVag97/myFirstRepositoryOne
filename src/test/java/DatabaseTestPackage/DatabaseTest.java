package DatabaseTestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//WORKING CODE WITH DATABASE CONNECTION TEST CASES
public class DatabaseTest 
{
    private Connection conn;

    @BeforeClass
    public void setUp() throws Exception 
    {	
    	try
    	{
		    // Load the SQL Server JDBC driver
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		    // Establish the connection
		    String Url = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;encrypt=true;trustServerCertificate=true";
		    String User = "qauser";
		    String Password = "qauser@123";
		    conn = DriverManager.getConnection(Url, User, Password);
		        
		    System.out.println("Database connected successfully!");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("Database connected issue!");
    	}
    }

    @Test
    public void testFetchData() throws Exception 
    {
      try 
      {
        Statement statement = conn.createStatement();
        String query = "select * from HumanResources.Employee";
        ResultSet resultSet = statement.executeQuery(query);
        //ResultSet resultSet = statement.executeQuery("select * from HumanResources.Employee");

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

        	//String employeeName = resultSet.getString("name");
            //Assert.assertEquals(employeeName, "John Doe");
        }
       }
       catch (Exception e) 
       {
            e.printStackTrace();
       }
     }

    @AfterClass
    public void tearDown() throws Exception 
    {
        if (conn != null && !conn.isClosed()) 
        {
        	conn.close();
            System.out.println("Database connection closed.");
        }
    }
}
