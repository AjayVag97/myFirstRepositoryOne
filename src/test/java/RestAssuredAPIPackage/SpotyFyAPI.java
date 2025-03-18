package RestAssuredAPIPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SpotyFyAPI 
{

	@Test
	public void GetUserId()
	{
			RestAssured.given()
			 .baseUri("https://api.spotify.com/").basePath("v1/me")
			 .header("Authorization", "Bearer " +Token)
			 .when().get("/me")
			 .then()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			// To verify country in Response Payload
			 .body("country", equals("IN"));
	}
	
}

