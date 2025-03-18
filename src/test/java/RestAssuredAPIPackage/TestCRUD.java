package RestAssuredAPIPackage;

import java.io.IOException;
import java.text.ParseException;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
 
/*
 * This test class has test methods for CRUD actions on REST API
 * REST Service http://dummy.restapiexample.com/api
 * It has test methods for Create , Edit , Get and Delete Employee items
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
 * https://docs.spring.io/autorepo/docs/spring/3.2.3.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
 * @author
 *
 */

public class TestCRUD 
{
    private String responseBody;
    public String responseBodyPOST;
   
    final static Logger logger = Logger.getLogger(TestCRUD.class);
    //RESTTemplate Object
    private RestTemplate restTemplate;
 
    //Employee ID
    private String employeeId;
    // Create Response Entity - Stores HTTPStatus Code, Response Body, etc
    private ResponseEntity &amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt;response;
    
    @BeforeTest
    public void beforeTest() throws IOException, ParseException 
    {
        logger.info(&amp;amp;amp;quot;Setting up prerequisite for test execution&amp;amp;amp;quot;);
        logger.info(&amp;amp;amp;quot;Creating RestTemplate object before tests&amp;amp;amp;quot;);
        this.restTemplate = new RestTemplate();
    }
 
    /**
     * Test Method to add employee using HTTP POST request
     *
     * Verifies POST action Status Code
     *
     * @throws IOException
     * @throws ParseException
     */
    
    @Test
    public void addEmployee() throws IOException, ParseException 
    {
        String addURI = &amp;amp;amp;quot;http: //dummy.restapiexample.com/api/v1/create&amp;amp;amp;quot;;
        HttpHeaders headers = new HttpHeaders();
        headers.add(&amp;amp;amp;quot;Accept&amp;amp;amp;quot;, &amp;amp;amp;quot;application/json&amp;amp;amp;quot;);
        headers.add(&amp;amp;amp;quot;Content-Type&amp;amp;amp;quot;, &amp;amp;amp;quot;application/json&amp;amp;amp;quot;);
 
        logger.info(&amp;amp;amp;quot;Add URL :&amp;amp;amp;quot;+addURI);
        String jsonBody = &amp;amp;amp;quot;{\&amp;amp;amp;quot;name\&amp;amp;amp;quot;:\&amp;amp;amp;quot;zozo100\&amp;amp;amp;quot;,\&amp;amp;amp;quot;salary\&amp;amp;amp;quot;:\&amp;amp;amp;quot;123\&amp;amp;amp;quot;,\&amp;amp;amp;quot;age\&amp;amp;amp;quot;:\&amp;amp;amp;quot;23\&amp;amp;amp;quot;}&amp;amp;amp;quot;;
        System.out.println(&amp;amp;amp;quot;\n\n&amp;amp;amp;quot; + jsonBody);
        HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt; entity = new HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt;(jsonBody, headers);
 
        //POST Method to Add New Employee
        response = this.restTemplate.postForEntity(addURI, entity, String.class);
        responseBodyPOST = response.getBody();
        // Write response to file
        responseBody = response.getBody().toString();
        System.out.println(&amp;amp;amp;quot;responseBody ---&amp;amp;amp;amp;gt;&amp;amp;amp;quot; + responseBody);
        // Get ID from the Response object
        employeeId = getEmpIdFromResponse(responseBody);
        System.out.println(&amp;amp;amp;quot;empId is :&amp;amp;amp;quot; + employeeId);
        // Check if the added Employee is present in the response body.
        Assert.assertTrue(responseBody.contains(employeeId));
        // System.out.println(propertyFile.get(&amp;amp;amp;quot;EmployeeAddResBody&amp;amp;amp;quot;));
        // Check if the status code is 201
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        logger.info(&amp;amp;amp;quot;Employee is Added successfully employeeId:&amp;amp;amp;quot;+employeeId);
    }
 
    /**
     * Method to get Employee ID from REsponse body
     * I have used Json Simple API for Parsing the JSON object
     *
     * @param json
     * @return
     */
   
    public static String getEmpIdFromResponse(String json) 
    {
        JSONParser parser = new JSONParser();
        JSONObject jsonResponseObject = new JSONObject();
        Object obj = new Object();
        try {
            obj = parser.parse(json);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        jsonResponseObject = (JSONObject) obj;
        String id = jsonResponseObject.get(&amp;amp;amp;quot;id&amp;amp;amp;quot;).toString();
        return id;
    }
    
    /**
     * Test Method to Update employee using HTTP PUT request
     *
     * Verifies PUT action Status Code
     * Verifies Updated Name exists in Response Body
     *
     * @throws IOException
     * @throws ParseException
     */
      
     @Test(dependsOnMethods = &amp;amp;amp;quot;addEmployee&amp;amp;amp;quot;, enabled = true)
      public void  updateEmployee() throws IOException, ParseException 
      {
          String updateURI = &amp;amp;amp;quot;http://dummy.restapiexample.com/api/v1/update/&amp;amp;amp;quot;+employeeId;
          logger.info(&amp;amp;amp;quot;Update URL :&amp;amp;amp;quot;+updateURI);
 
          String jsonBody = responseBodyPOST;
 
          jsonBody = jsonBody.replace(&amp;amp;amp;quot;zozo100&amp;amp;amp;quot;, &amp;amp;amp;quot;update_zozo100&amp;amp;amp;quot;);
 
          HttpHeaders headers = new HttpHeaders();
          headers.add(&amp;amp;amp;quot;Accept&amp;amp;amp;quot;, &amp;amp;amp;quot;application/json&amp;amp;amp;quot;);
          headers.add(&amp;amp;amp;quot;Content-Type&amp;amp;amp;quot;, &amp;amp;amp;quot;application/json&amp;amp;amp;quot;);
 
          HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt; entity = new HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt;(jsonBody, headers);
 
          //PUT Method to Update the existing Employee
          //NOTE that I have Not used restTemplate.put as it's void and we need response for verification
          response = restTemplate.exchange(updateURI, HttpMethod.PUT, entity, String.class);
          responseBody = response.getBody().toString();
          System.out.println(&amp;amp;amp;quot;Update Response Body :&amp;amp;amp;quot;+responseBody);          
 
          // Check if the updated Employee is present in the response body.
          Assert.assertTrue(responseBody.contains(&amp;amp;amp;quot;update_zozo100&amp;amp;amp;quot;));
 
          // Check if the status code is 200
          Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
 
          logger.info(&amp;amp;amp;quot;Employee Name is Updated successfully employeeId:&amp;amp;amp;quot;+employeeId);
 
      }
 
      /**
       * Test Method to Get employee using HTTP GET request
       *
       * Verifies GET action Status Code
       * Verifies Name exists in Response Body
       *
       * @throws IOException
       * @throws ParseException
       */
     
      @Test(dependsOnMethods = &amp;amp;amp;quot;updateEmployee&amp;amp;amp;quot;, enabled = true)
      void getEmployee() throws IOException, ParseException 
      {
          String getURI = &amp;amp;amp;quot;http://dummy.restapiexample.com/api/v1/employee/&amp;amp;amp;quot;+this.employeeId;
          logger.info(&amp;amp;amp;quot;Get URL :&amp;amp;amp;quot;+getURI);
 
          HttpHeaders headers = new HttpHeaders();
          HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt; entity = new HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt;(headers); 
 
          //GET Method to Get existing Employee
          response = restTemplate.getForEntity(getURI,String.class);
 
          // Write response to file
          responseBody = response.getBody().toString();
 
          //Suppressing for log diffs
          System.out.println(&amp;amp;amp;quot;GET Response Body :&amp;amp;amp;quot;+responseBody);
 
          // Check if the added Employee ID is present in the response body.
          Assert.assertTrue(responseBody.contains(&amp;amp;amp;quot;update_zozo100&amp;amp;amp;quot;));
 
          // Check if the status code is 200
          Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
 
          logger.info(&amp;amp;amp;quot;Employee is retrieved successfully employeeId:&amp;amp;amp;quot;+employeeId);
 
      }      
 
      /**
       * Test Method to Delete employee using HTTP DELETE request
       *
       * Verifies DELETE action Status Code
       * Verifies Success Message Text in Response Body
       *
       * @throws IOException
       * @throws ParseException
       */
        @Test(dependsOnMethods = &amp;amp;amp;quot;getEmployee&amp;amp;amp;quot;, enabled = true)
        public void deleteEmployee() throws IOException, ParseException 
        {
            String delURI = &amp;amp;amp;quot;http://dummy.restapiexample.com/api/v1/delete/&amp;amp;amp;quot;+this.employeeId;
            HttpHeaders headers = new HttpHeaders();
            HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt; entity = new HttpEntity&amp;amp;amp;amp;lt;String&amp;amp;amp;amp;gt;(headers); 
 
            //DELETE Method to Delete existing Employee
            response = restTemplate.exchange(delURI, HttpMethod.DELETE, entity, String.class);    
 
            // Check if the status code is 204
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);            
 
            responseBody = response.getBody();
 
            Assert.assertEquals(getMessageFromResponse(responseBody), &amp;amp;amp;quot;successfully! deleted Records&amp;amp;amp;quot;);
 
            logger.info(&amp;amp;amp;quot;Employee is Deleted successfully employeeId:&amp;amp;amp;quot;+employeeId);
        }
 
        /**
         * Gets &amp;amp;amp;quot;text&amp;amp;amp;quot; key value from Response body text for verification
         * I have used Json Simple API for Parsing the JSON object
         *
         * @param json
         * @return text string
         */
        public static String getMessageFromResponse(String json) 
        {
            String successMessageText = null;
            try 
            {
                JSONParser parser = new JSONParser();
                JSONObject jsonResponseObject = new JSONObject();
                jsonResponseObject = (JSONObject) (parser.parse(json));
                String successMessage = jsonResponseObject.get(&amp;amp;amp;quot;success&amp;amp;amp;quot;).toString();
 
                jsonResponseObject = (JSONObject) (parser.parse(successMessage));
                successMessageText = jsonResponseObject.get(&amp;amp;amp;quot;text&amp;amp;amp;quot;).toString();
            } 
            catch (org.json.simple.parser.ParseException e) 
            {
                e.printStackTrace();
            }
            return successMessageText;
        }
 
    @AfterTest
    public void afterTest() 
    {
        logger.info(&amp;amp;amp;quot;Clean up after test execution&amp;amp;amp;quot;);
        logger.info(&amp;amp;amp;quot;Creating RestTemplate object as Null&amp;amp;amp;quot;);
        this.restTemplate = new RestTemplate();
    }
}