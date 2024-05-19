package apiOperations;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.readJson;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PostMethod {
	
	/*
	 * https://rahulshettyacademy.com
key=qaclick123
/maps/api/place/add/json
Content-Type=application/json
	 */
	
	public static String placeid = "";
	
	
	@Test
	public static void postOperation() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String wholeResponce =	given().queryParam("key", "qaclick123")
		.headers("Content-Type","application/json")
		.body(jsonFiles.payload1.returnPayload1())
		.when().post("/maps/api/place/add/json").then().extract().response().asString();
	
	JsonPath readJsonResponce = readJson.readJsonResponce(wholeResponce);
	placeid = readJsonResponce.getString("place_id");
	
	System.out.println(placeid);
	

		
	}

}
