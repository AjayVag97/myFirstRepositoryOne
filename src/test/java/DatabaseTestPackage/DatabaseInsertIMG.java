package DatabaseTestPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseInsertIMG 
{
   //IMAGE table created and IMAGE path saved Success properly 
	@Test
	public void InsertTable() throws SQLException
	{
		String ConnectionUrl = "jdbc:sqlserver://ISD_8_C_11;databaseName=AdventureWorks2022;user=qauser;password=qauser@123;encrypt=true;trustServerCertificate=true";
		Connection mycon = DriverManager.getConnection(ConnectionUrl);
		
		if(mycon==null)
		{
			System.out.println("Connection Failed !");
		}
		else 
		{
			System.out.println("Connection Success");
			
			String InsertQuery = "Insert into HumanResources.ProfileImage(Eid,myPicName,ImagePath) values (?,?,?)";
			PreparedStatement statement = mycon.prepareStatement(InsertQuery);
			
			 statement.setInt(1,3);
			 statement.setString(2, "SmcTrip");
			 statement.setString(3, "F:\\SmcTrip.jpg");
			 
			 int MyRowsInsert = statement.executeUpdate();
			 System.out.println("Total Data = " +MyRowsInsert);
			 
			 if(MyRowsInsert>0)
			 {
				 System.out.println("Image path inserted success !");
			 }			
		 }
	}
}
