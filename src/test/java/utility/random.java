package utility;

import java.util.Random;

public class random {
	
	public static  String generateRndomAddress() {
		
		String[] address = {"chennai" ,"Bangalore" ,"coimbatore"};
		
		Random obj = new Random();
		int nextInt = obj.nextInt(address.length-1);
		return  address[nextInt];
		
	}

}
