package RestAssuredAPIPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.pagefactory.bys.ContentType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FirstAPItest 
{
	
	@BeforeClass
    public static void setup() 
	{
        RestAssured.baseURI = "https://www.suratmunicipal.gov.in/OnlineServices/Home/Login";
    }	
		
	@Test
    public void AuserLogin() 
	{
		// Specify the base URL to the RESTful web service 
		//RestAssured.baseURI = "https://www.suratmunicipal.gov.in/OnlineServices/Home/Login";
		RestAssured.baseURI = "http://10.11.1.9/ReconciliationManagementSystem";		

		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given();
        
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
        //Response res = httpRequest.get("https://www.suratmunicipal.gov.in");
        Response response = httpRequest.request(Method.GET, "http://10.11.1.9/ReconciliationManagementSystem");

        // Print the message body of the response received from the server 
        System.out.println("Status received => " + response.getStatusLine()); 
        System.out.println("The Response=>" + response.print());        
    }
	
	
	@Test
	public void testGet() 
	{ 
		  //Set baseURI 
	      //RestAssured.baseURI = "https://www.suratmunicipal.gov.in"; 
	
	      // Send a GET request to the API 
	      Response response = RestAssured.get("/api/resource"); 
	
	      // Verify that the response has a 200 OK status code 
	      response.then().assertThat().statusCode(200); 
	
	      // Verify that the response body contains the expected data 
	      //response.then().assertThat().body("some.property", equalTo("expected value")); 
	} 
}
