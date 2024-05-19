package Basic;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class PassJsonFromAnotherFile {
	
	
	public static void addPlaceRequest() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all()
		.queryParam("key", "qaclick123")
		.headers("Content-Type", "application/json")
		.body(jsonFiles.payload1.returnPayload1())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	public static void main(String[] args) {
		PassJsonFromAnotherFile.addPlaceRequest();
		
		
		
	}

}
