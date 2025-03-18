package RestAssuredAPIPackage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.JsonException;

public class APIUtil
{
	   //private static Map<String, Set<?>> dataMapForTestCaseDetails = new HashMap<>();
	   public static void main(String[] args) throws JsonException 
	   {
	       try
	       {
	           RestAssured.baseURI = "https://reqres.in/";
	           String strURITokenForPost = "api/users";
	           
	           RequestSpecification request = RestAssured.given();
	           
	           JSONObject requestParams = new JSONObject();// JSON Object Creation
	           requestParams.put("name", "John"); // Adding the information as key-value pair in the JSON
	           requestParams.put("job", "tester");
	           request.body(requestParams);
	           request.header("Content-Type", "application/json");
	           
	           Response response = request.post(strURITokenForPost); // here we are hitting the uri
	           System.out.println("\n Status Code is : " + response.getStatusCode()); // Response status code is printed here 
	           System.out.println("--->Response JSON Body: " + response.getBody().asString());
	       } 
	       catch(Exception ex)
	       {
	           System.out.println("WARNING: " + ex.getMessage() + " In API Util class file.");
	       }
	   }
}