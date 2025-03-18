package RestAssuredAPIPackage;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class SmcAPILogin 
{
	//Working RestAssured API testing code of website 
	final static String url="https://www.suratmunicipal.gov.in/";

	@Test
	public void loginAPI() 
	{
		getResponseContentType();
		getResponseHeaders(); 
		getResponseTime();    
		getResponseBody();    
		getResponseStatus();  

	}

	public static void getResponseContentType()
	{
		System.out.println("THE CONTENT TYPE OF RESPONSE = "+get(url).then().extract().contentType());
		System.out.println("========================================");
	}

	//This will fetch the response body as is and log it. given and when are optional here
	public static void getResponseBody()
	{
		given().when().get(url).then().log().body();

		given().queryParam("MOBILE_NUMBER","8905252328")
		.queryParam("PASSWORD","Ajay@123")
		//.queryParam("Account_No","1")
		.when()
		.get("https://www.suratmunicipal.gov.in/OnlineServices/Home/Login")
		.then().log().body();			 	
		System.out.println("========================================");
	}

	public static void getResponseStatus()
	{
		int statusCode= given().queryParam("MOBILE_NUMBER","8905252328")
				.queryParam("PASSWORD","Ajay@123")
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

	public static void getResponseHeaders()
	{
		System.out.println("THE HEADERS IN THE RESPONSE "+get(url).then().extract().headers());
		System.out.println("========================================");
	}

	public static void getResponseTime()
	{
		System.out.println("THE TIME TAKEN TO FETCH THE RESPONSE = "+get(url).timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
		System.out.println("========================================");
	}
}
