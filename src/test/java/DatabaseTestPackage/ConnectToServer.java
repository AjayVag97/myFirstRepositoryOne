package DatabaseTestPackage;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ConnectToServer 
	{
	    // Connect to your database.
	    public static void main(String[] args) 
	    {
	    	String  connectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
	    	ResultSet resultSet = null;

	        try (Connection connection = DriverManager.getConnection(connectionUrl);Statement statement = connection.createStatement();) 
	        {
	            // Create and execute a SELECT SQL statement.
	            String selectSql = "select * from HumanResources.Employee";
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next())
	            {
	               // System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
	               // Print worker details
	                
	                int empBId = resultSet.getInt("BusinessEntityID");
	                String empNID = resultSet.getString("NationalIDNumber");
	                String empBirth = resultSet.getString("BirthDate");
	                String empPosition = resultSet.getString("JobTitle");
	                int empVacHr = resultSet.getInt("VacationHours");
	                
	                System.out.println("BusinessEntityID: " + empBId + ", NationalIDNumber: " + empNID + ", BirthDate: "+ empBirth + ", JobTitle: " + empPosition + ", VacationHours: " + empVacHr);
	            } 
	            System.out.println("CONNECTION DATA PRINTED  ");
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	}