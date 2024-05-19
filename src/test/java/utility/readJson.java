package utility;

import io.restassured.path.json.JsonPath;

public class readJson {
	
	public static JsonPath readJsonResponce(String responce) {
		
		JsonPath obj = new JsonPath(responce);
		return obj;
		
		
		
	}

}
