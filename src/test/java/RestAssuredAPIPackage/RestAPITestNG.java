package RestAssuredAPIPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class RestAPITestNG 
{

    @BeforeClass
    public void setup() 
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @BeforeMethod
    public void beforeEachTest() 
    {
        System.out.println("Starting a new test...");
    }

    @AfterClass
    public void teardown() 
    {
        System.out.println("Tests completed.");
    }

    @Test
    public void testGetPostById()
    {
        given().when().get("/posts/1").then().statusCode(200).body("userId", equalTo(1));
        
        
		/*
		  String ActualTitle = driver.getTitle(); 
		  String ExpectedTitle ="Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		  Assert.assertEquals(ExpectedTitle, ActualTitle);
		 */
        
    }
}