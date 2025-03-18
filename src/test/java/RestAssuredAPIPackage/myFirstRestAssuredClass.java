package RestAssuredAPIPackage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class myFirstRestAssuredClass 
{

	final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

			public static void main(String args[]) 
			{
				getResponseContentType();
				getResponseHeaders(); 
				getResponseTime();    
				getResponseBody();    
				getResponseStatus();  				
			}
			
			public static void getResponseContentType()
			{
				   System.out.println("CONTENT TYPE OF RESPONSE = "+get(url).then().extract().contentType());
				   System.out.println("========================================");
			}
					
			public static void getResponseHeaders()
			{
				   System.out.println("HEADERS IN THE RESPONSE "+get(url).then().extract().headers());
				   System.out.println("========================================");
			}
			
			public static void getResponseTime()
			{
				  System.out.println("TIME TAKEN TO FETCH THE RESPONSE = "+get(url).timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
				  System.out.println("========================================");
			}
			
		   //This will fetch the response body as is and log it. given and when are optional here
			public static void getResponseBody()
			{
		       		given().when().get(url).then().log().body();

				 	given().queryParam("CUSTOMER_ID","68195")
				 		   .queryParam("PASSWORD","1234!")
				 		   .queryParam("Account_No","1")
				 		   .when()
				 		   .get("http://demo.guru99.com/V4/sinkministatement.php")
				 		   .then().log().body();				 	
				 	System.out.println("========================================");
		   	}

			public static void getResponseStatus()
			{
			   int statusCode= given().queryParam("CUSTOMER_ID","68195")
		           .queryParam("PASSWORD","1234!")
		           .queryParam("Account_No","1")
		           .when().get("http://demo.guru99.com/V4/sinkministatement.php")
		           .getStatusCode();
			   		
			       //TO make BOLD content inside System.out.println
			   		String bold = "\u001B[1m";
			   		//String reset = "\u001B[0m";
			   		System.out.println(bold+"THE RESPONSE STATUS IS: "+statusCode);

			   		given().when().get(url).then().assertThat().statusCode(200);
			   		System.out.println("========================================");
		   }					
}
