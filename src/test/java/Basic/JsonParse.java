package Basic;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;

public class JsonParse {

	static int coursecount = 0;
	static int purchaseAmount = 0;

	/*
	 * 
	 * 1. Print No of courses returned by API
	 * 
	 * 2.Print Purchase Amount
	 * 
	 * 3. Print Title of the first course
	 * 
	 * 4. Print All course titles and their respective Prices
	 * 
	 * 5. Print no of copies sold by RPA Course
	 * 
	 * 6. Verify if Sum of all Course prices matches with Purchase Amount
	 * 
	*/

	public static void gettotalCourse() {
		
		String name = jsonFiles.complexJsonPayload.payload();
		 
		
		JsonPath obj = new JsonPath(name);
		// 1. Print No of courses returned by API
		// JsonPath obj =
		// utility.readJson.readJsonResponce(jsonFiles.complexJsonPayload.payload());
		coursecount = obj.getInt("courses.size()");
		System.out.println("Total Course Count " + coursecount);
		// 2.Print Purchase Amount
		int purchaseAmount = obj.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount : " + purchaseAmount);
		// 3. Print Title of the first course
		String firstcourse = obj.get("courses[0].title");
		System.out.println("firstcourse " + firstcourse);

	}

	public static void printAllCourseAndPrize() {
		 JsonPath obj = utility.readJson.readJsonResponce(jsonFiles.complexJsonPayload.payload());
		// 4. Print All course titles and their respective Prices
		for (int i = 0; i < coursecount; i++) {
			String coursename = obj.getString("courses[" + i + "].title");
			int prize = obj.getInt("courses[" + i + "].price");

			System.out.println(coursename + " :" + prize);
		}

	}

	// 5. Print no of copies sold by RPA Course
	public static void printrecordspecifcondition() {
		 JsonPath obj = utility.readJson.readJsonResponce(jsonFiles.complexJsonPayload.payload());

		int copies = 0;

		for (int i = 0; i < coursecount; i++) {
			String coursename = obj.getString("courses[" + i + "].title");
			if (coursename.equalsIgnoreCase("RPA")) {
				copies = obj.getInt("courses[" + i + "].copies");
			}
		}

		System.out.println(copies);
	}

	// 6. Verify if Sum of all Course prices matches with Purchase Amount
	public static void sumofallCourse() {
		 JsonPath obj = utility.readJson.readJsonResponce(jsonFiles.complexJsonPayload.payload());
		int sum = 0;

		for (int i = 0; i < coursecount; i++) {
			sum = sum + obj.getInt("courses[" + i + "].price");

	}
		int purchaseAmount = obj.getInt("purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		

	}

	public static void main(String[] args) {
		
		JsonParse.gettotalCourse();
//		JsonParse.printAllCourseAndPrize();
//		JsonParse.printrecordspecifcondition();
//		JsonParse.sumofallCourse();

	}

}
