package MobileAppAutomatePackage;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.awt.PageAttributes.MediaType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.response.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class SMC_App_PTax 
{
	//SMC mobile App code 	
	AndroidDriver driver;
	
	//@BeforeClass
	@Test(priority=1)
	public void configure() throws MalformedURLException
	{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities MobCapabilities = new DesiredCapabilities();
		//UiAutomator2Options MobCapabilities = new UiAutomator2Options();
		
		MobCapabilities.setCapability("automationName", "uiautomator2");
		MobCapabilities.setCapability("platformNameVersion", "14.0.0"); 
		MobCapabilities.setCapability("deviceName","Pixel7Device");
		MobCapabilities.setCapability("platformName","Android");
		MobCapabilities.setCapability("appPackage", "in.smc");
		
		MobCapabilities.setCapability("AccessId","2");
		MobCapabilities.setCapability("UserId","825116");
		// Inject token capability if supported
		MobCapabilities.setCapability("accessToken", "ZsDweIpfKTUHzC0WJe2GLbljX/k14KBcNFu7RiNyKNOaciY5vHl+0Y67AAehBRMwvEdBHjlx5/2fPNKDiDjUZ/lsCD4DO6BX20iFfREsr0q7tTYq3NtUzFMShH7u2v86");
		
		MobCapabilities.setCapability("appActivity","in.smc.Module.Home.Activity.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
				
		//Create RemoteWebDriver instance and connect to the Appium server
	 	//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), MobCapabilities);
	}
	
	  @Test
	  public void loginAPI() 
	  {
		  	getResponseBody();    
	  }
	  
	  public static void getResponseBody()
	  {
		    String url="https://www.suratmunicipal.gov.in/";
	    	given().when().get(url).then().log().body();

			given().queryParam("MOBILE_NUMBER","8905252328")
			 		   .queryParam("PASSWORD","Ajay@123")
			 		  //.queryParam("Account_No","1")
			 		   .when()
			 		   .get("https://www.suratmunicipal.gov.in/OnlineServices/Home/Login")
			 		   .then().log().body();			 	
			 	System.out.println("========================================");
	   	}
	
	/*
	@Test(priority=2)
	private static String getTokenFromBackend() 
	{
		OkHttpClient client = new OkHttpClient().newBuilder().build();
        
		// Create the request body
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "response_type=token&client_id=ClientId&username=user&password=userpassword&scope=process&grant_type=password");
        
        // Build the request object, with method, headers
        Request request = new Request.Builder()
                .url("https://oauth2.url/oauth/token")
                .method("POST", body)
                .addHeader("Authorization", createAuthHeaderString("ClientId", "Clientaccesskey"))
                .addHeader("Content-Type", "text/plain")
                .build();
        
        // Perform the request, this potentially throws an IOException
        Response response = client.newCall(request).execute();
        
        // Read the body of the response into a hashmap
        Map<String,Object> responseMap = new ObjectMapper().readValue(response.body().byteStream(), HashMap.class);
        
        // Read the value of the "access_token" key from the hashmap 
        String accessToken = (String)responseMap.get("access_token");
       
        // Return the access_token value
        return accessToken;
    }
	*/
	
	
	
	@Test(priority=2)
	public void loginUser() throws InterruptedException
	{
		 //Click on Property Tax menu 
		   WebElement PropertyTaxIcon = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.smc:id/dash_text' and @text='Property Tax']"));
		   PropertyTaxIcon.click();
		   Thread.sleep(3000);
		   
		   //Enter WARD number 
		   WebElement WardNumber = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/spnWard']"));
		   WardNumber.sendKeys("065");
		   Thread.sleep(3000);
		   
		   //Select Alphabetics   
		   WebElement TaxView = driver.findElement(By.xpath(" //android.widget.TextView[@resource-id='android:id/text1']"));
		   TaxView.click();
		   WebElement selD = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='D']"));
		   selD.click();
		   Thread.sleep(2000);
		   
		   //Enter LOCATION number--------------------------------------------- 	   
		   WebElement Location = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/spnLocation']"));
		   Location.sendKeys("19");
		   Thread.sleep(2000);
		   
		   //Enter OWNER 
		   WebElement OwnerNum = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/spnOwner']"));
		   OwnerNum.sendKeys("7871");
		   Thread.sleep(2000);
		   
		   //Enter SUB OWNER 
		   WebElement SubOwner = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/spnSubOwner']"));
		   SubOwner.sendKeys("0");
		   Thread.sleep(2000);
		   
		   //Enter OCCUOPENCIE
		   WebElement Occupencie = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/spnOccupience']"));
		   Occupencie.sendKeys("001");
		   Thread.sleep(2000);
		   
		   //Enter GET PENDING TAX AMOUNT
		   WebElement GetTax = driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc:id/btnSubmit']"));
		   GetTax.click();
		   Thread.sleep(2000);
		   
		    //Scroll down app down 
			Actions act = new Actions(driver);
	        act.sendKeys(Keys.PAGE_DOWN).build().perform();    //Page Down
	        System.out.println("SCROLLED DOWN WORKING");
	        Thread.sleep(3000);	        	
		}
	
		@Test(priority=3)
		public void c_loginProteryTax() throws InterruptedException
		{
				 //Location access 
				   WebElement AccessDevice = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']"));
				   AccessDevice.click();
				   Thread.sleep(3000);
				   
				 //CLick on Sandwich menu  
				   WebElement Sandwichmenu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
				   Sandwichmenu.click();
				   Thread.sleep(3000);
				   
				   //CLick on LOGIN button 
				   WebElement LoginButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc:id/btnLogin']"));
				   LoginButton.click();
				   Thread.sleep(3000);
				   
				   //CLick on MOBILE Number or Email  
				   WebElement MobileNum = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/edtUserName']"));
				   MobileNum.sendKeys("8905252328");
				   Thread.sleep(3000);
				 
				   //CLick on Password 
				   WebElement MyPassword = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='in.smc:id/edtPassword']"));
				   MyPassword.sendKeys("Ajay@123");
				   Thread.sleep(3000);
				   
				   //CLick on LOGIN 
				   WebElement Login = driver.findElement(By.xpath("//android.widget.Button[@resource-id='in.smc:id/btnLogin']"));
				   													//android.widget.Button[@resource-id='in.smc:id/btnLogin']
				   Login.click();
				   Thread.sleep(3000);		  	  				 
			}
		
		/*@Test(priority=3)
		public void AuthTokenUser() throws InterruptedException
		{
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.example.com/login"))
			    .header("Authorization", "Bearer your_jwt_token")
			    .build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		
		}*/
		
				
	}
