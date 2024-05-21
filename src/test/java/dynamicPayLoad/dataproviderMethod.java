package dynamicPayLoad;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class dataproviderMethod {
	
	
	@Test(dataProvider = "data" )
	public void iterater(String housedetails , String loactiondetails , String phonenumberdeta) {
		
		System.out.println(housedetails);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String wholeresponce  = given().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body(jsonFiles.payload1.postpayload(housedetails, loactiondetails, phonenumberdeta
				))
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(wholeresponce);
		
		
	}
	
	
	@DataProvider(name = "data")
	public static Object[][] datapayload() {
		
		return  new Object[][] {{"shollinganallur"," chennai","600119"},{"nalroad","palani","24617"}};
		
	}

}
