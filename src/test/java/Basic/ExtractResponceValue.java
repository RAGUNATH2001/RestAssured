package Basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonFiles.payload1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExtractResponceValue {
	
	
	public static void extractPlaceIdFromResone() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		String responce = given()
				.queryParam("key","qaclick123")
				.headers("Content-Type","application/json")
		.body(jsonFiles.payload1.returnPayload1())
		.when().post("/maps/api/place/add/json")
		.then().extract().response().asString();
		
		JsonPath obj = new JsonPath(responce);
		String placeid = obj.getString("place_id");
		
		System.out.println(placeid);
		
		
		
	}
	
	public static void main(String[] args) {
		ExtractResponceValue.extractPlaceIdFromResone();
		
	}

}
