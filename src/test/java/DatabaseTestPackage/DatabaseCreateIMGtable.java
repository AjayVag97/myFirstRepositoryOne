package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseCreateIMGtable 
{
  @Test
  public void ImageSAVE() throws SQLException 
  {
	  	String ConnectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
		
		Connection mycon = DriverManager.getConnection(ConnectionUrl);
		
		if(mycon== null)
		{
			System.out.println("Connection failed!");
		}
		else
		{
			System.out.println("Connection Success!");
			
			String myquery ="Create table HumanResources.ProfileImage(Eid int primary Key,myPicName varchar(100),ImagePath NVARCHAR(100))"; //NVARCHAR for special character 
			//String myquery ="Create table HumanResources.ProfileImage(Eid int primary Key,myPicName varchar(100),ImagePath VARBINARY(MAX))"; //VARBINARY for image only
			
			System.out.println("Table created success");
			
			Statement statement = mycon.createStatement();
	        statement.executeUpdate(myquery);
	        //TEST
			
		}
	  }
}
