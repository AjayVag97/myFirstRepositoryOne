package DatabaseTestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeleniumDatabaseTesting 
{
	// Connection object
	static Connection con = null;
	
	// Statement object
	private static Statement stmt;
	
	// Constant for Database URL
	public static String DB_URL = "jdbc:sqlserver://ISD_8_C_11/AdventureWorks2022";
	
	//Database Username
	public static String DB_USER = "qauser";
	
	// Database Password
	public static String DB_PASSWORD = "qauser@123";

	@BeforeTest
	public void setUp() throws Exception
	{
		try
		{
				// Database connection
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				//Class.forName(dbClass);
				
				// Get connection to DB
				Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				// Statement object to send the SQL statement to the Database
				stmt = con.createStatement();
				
				System.out.println("Database Connection Successful");    	 
		}
		catch(Exception e)
		{
				e.printStackTrace();
		}
	 }
		
		@Test
		public void test()
		{
		 try
		 {
			String query = "select * from dbo.Persons";
			
			// Get the contents of userinfo table from DB
			ResultSet resultSet = stmt.executeQuery(query);
			
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (resultSet.next())
			{
				int perId = resultSet.getInt("PersonID");
                String fName = resultSet.getString("FirstName");
                String lname = resultSet.getString("LastName");
                String pAdd = resultSet.getString("Address");
                String pCity = resultSet.getString("City");
                
                System.out.println("PersonID: " + perId + ", FirstName: " + fName + ", LastName: "+ lname + ", Address: " + pAdd + ", City: " + pCity);
			}
		  }
		  catch(Exception e)
		  {
				e.printStackTrace();
		  }
		}
		
		@AfterTest
		public void tearDown() throws Exception 
		{
			// Close DB connection
			if (con != null) 
			{
				con.close();
			}
		}
}