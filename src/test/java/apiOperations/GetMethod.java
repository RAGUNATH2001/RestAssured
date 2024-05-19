package apiOperations;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class GetMethod {
	
	
	@Test
	public static void getOperation() {
		
		System.out.println(apiOperations.PostMethod.placeid);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123")
		.queryParam("place_id",apiOperations.PostMethod.placeid).get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200);
	}
	
	
	
	

}
