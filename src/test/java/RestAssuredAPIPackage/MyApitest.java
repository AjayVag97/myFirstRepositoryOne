package RestAssuredAPIPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.equalTo; 
import io.restassured.response.Response; 


public class MyApitest 
{
	
	
	@Test
    public void testGetts() 
	{ 
        RestAssured.baseURI = "http://myapi.com"; 
  
        // Send a GET request to the API 
        Response response = RestAssured.get("/api/resource"); 
  
        // Verify that the response has a 200 OK status code 
        response.then().assertThat().statusCode(200); 
  
        // Verify that the response body contains the expected data 
        response.then().assertThat().body("some.property", equalTo("expected value")); 
    } 
	
	/*
	@Test
	public void testGet()
	{ 
	    RestAssured.get("http://my-api.com/resource/123") 
			        .then() 
			        .assertThat() 
			        .statusCode(200) 
			        .and() 
			        .contentType(ContentType.JSON) 
			        .and() 
			        .body("id", equalTo(123)); 
    }
	*/
}



