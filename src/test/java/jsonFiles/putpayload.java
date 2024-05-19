package jsonFiles;

public class putpayload {
	
	public static String returnputpayload(String placeid , String address ,String[] query) {
		return "{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\""+query[0]+"\":\""+query[1]+"\"\r\n"
				+ "}";
	}

}
