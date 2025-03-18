package RestAssuredAPIPackage;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import okhttp3.Response;

public class JsonPayload
{
	@Test
	public void GetBookDetails()
	{  
	    // Specify the base URL to the RESTful web service 
	    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
	    
	    // Get the RequestSpecification of the request to be sent to the server 
	    RequestSpecification httpRequest = RestAssured.given(); 
	    Response response = httpRequest.get("/v4"); 

	    // Get the status line from the Response in a variable called statusLine
	    String statusLine = response.getStatusLine();
	    
	    Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" 
	     /*expected value*/, "Correct status code returned");

	}
}