package utility;

import java.util.Random;

import org.testng.annotations.Test;

public class random {
	
	public static  String generateRndomAddress() {
		
		String[] address = {"chennai" ,"Bangalore" ,"coimbatore"};
		
		Random obj = new Random();
		int nextInt = obj.nextInt(address.length-1);
		return  address[nextInt];
		
	}
	

	public static String generatePhoneNumber() {
		
		String phonum = "+91 ";
		
		int i =0 ;
		while( i<=10) {
			Random obj = new Random();
			 phonum += obj.nextInt(10);
			i++;
		}
		return phonum;
		
	}

}
