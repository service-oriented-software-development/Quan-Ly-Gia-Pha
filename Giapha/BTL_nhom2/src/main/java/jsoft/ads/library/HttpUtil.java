package jsoft.ads.library;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HttpUtil(String value){
		this.value = value;
	}
	
	public <T> T toModel(Class<T> Class) {
		try {
			return new ObjectMapper().readValue(value, Class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder sb =  new StringBuilder();
		
		String line;
		try {
			while((line=reader.readLine())!=null) 
			{
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new HttpUtil(sb.toString());
	}
//	public static String of (BufferedReader reader) {
//		StringBuilder sb =  new StringBuilder();
//		
//		String line;
//		try {
//			while((line=reader.readLine())!=null) 
//			{
//				sb.append(line);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return sb.toString();
//	}
}
