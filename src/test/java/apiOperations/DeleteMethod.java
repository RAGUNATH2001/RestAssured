package apiOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteMethod {
	
	/*
	 * https://rahulshettyacademy.com
key=qaclick123
/maps/api/place/add/json
Content-Type=application/json
	 */
	@Test
	public void deleteOperation() throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body(Files.readAllBytes(Paths.get("./src/test/java/jsonFiles/deleteAPIPayload.json")))
		.delete("/maps/api/place/delete/json").then().log().all().assertThat().statusCode(200);
		
	}

}
