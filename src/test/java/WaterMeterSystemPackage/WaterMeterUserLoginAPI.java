package WaterMeterSystemPackage;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;


//REST ASSURED API THROUGH DATA FETCHING  
public class WaterMeterUserLoginAPI 
{
	final static String url="http://10.11.1.13:5050/";

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
		   System.out.println("=======================================================================");
		   System.out.println("CONTENT TYPE OF RESPONSE = "+get(url).then().extract().contentType());
		   System.out.println("=======================================================================");
	}
			
	public static void getResponseHeaders()
	{
		   System.out.println("HEADERS IN THE RESPONSES "+get(url).then().extract().headers());
		   System.out.println("========================================");
	}
	
	public static void getResponseTime()
	{
		  System.out.println("TIME TAKEN TO FETCH THE RESPONSES = "+get(url).timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
		  System.out.println("========================================");
	}
	
   //This will fetch the response body as is and log it. given and when are optional here
	public static void getResponseBody()
	{
       		given().when().get(url).then().log().body();

		 	given().queryParam("USER_NAME","98123")
		 		   .queryParam("PASSWORD","Tushar1234!")
		 		   .queryParam("SITE","(300) Central Zone")
		 		   .queryParam("CONNECTION_TYPE","Zone")
		 		   .when()
		 		   .get("http://10.11.1.13:5050/")
		 		   .then().log().body();				 	
		 	System.out.println("=======================================================================");
   	}

	public static void getResponseStatus()
	{
	   int statusCode= given().queryParam("USER_NAME","98123")
	 		   .queryParam("PASSWORD","Tushar1234!")
	 		   .queryParam("SITE","(300) Central Zone")
	 		   .queryParam("CONNECTION_TYPE","Zone")
	 		   .when().get("http://10.11.1.13:5050/")
	 		   .getStatusCode();
	   		
		       //TO make BOLD content inside System.out.println
		   		String bold = "\u001B[1m";
		   		//String reset = "\u001B[0m";
		   		System.out.println(bold+"THE RESPONSE STATUS IS: "+statusCode);
	
		   		given().when().get(url).then().assertThat().statusCode(200);
		   		System.out.println("=======================================================================");
  			   		
	   }					
}