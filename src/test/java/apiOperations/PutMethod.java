package apiOperations;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PutMethod {
	
	
	
	@Test
	public static void putOperation() {
		
		String placeid = "7ba9c769d382ee2dea17e19bd25af669";
		
		
		Random obj = new Random();
		
		
		String[] query = {"key" ,"qaclick123"};
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String wholeResponce =	given().queryParam("key", "qaclick123").queryParam("place_id", placeid)
			.headers("Content-Type","application/json")
			.body(jsonFiles.putpayload.returnputpayload(placeid
					, utility.random.generateRndomAddress(),query ))
			.when().post("/maps/api/place/update/json").then().extract().response().asString();
		
		System.out.println(wholeResponce);
		
		JsonPath readJsonResponce = utility.readJson.readJsonResponce(wholeResponce);
		String meg = readJsonResponce.getString("msg");
		
		Assert.assertEquals(meg, "Address successfully updated");
		
	}

}
