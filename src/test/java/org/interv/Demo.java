package org.interv;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Demo {
	public static void main(String[] args) {

		Map<String, String> mp = new HashMap<String, String>();

		mp.put("name", "praveen");
		mp.put("job", "Senior Software Tester");
		

		Response response = RestAssured.given().header("content-Type", "application/json")

				.body(mp).when().post("https://reqres.in/api/users");

		
//		Map<String, String> mp2 = new HashMap<String, String>();
//
//		mp.put("name", "dinesh");
//		mp.put("id", "7845126413");
//		
//		
//		RestAssured.given().header("content-Type", "application/json")
//
//				.body(mp2).when().put("https://reqres.in/api/users");

		
		 int statusCode = response.getStatusCode();
		 ResponseBody body = response.getBody();
		 String asPrettyString = body.asPrettyString();
		 System.out.println(statusCode);
		 System.out.println(asPrettyString);
		 String object = response.jsonPath().get("createdAt");
		 System.out.println(object);
		 
		 Set<Entry<String, String>> entrySet = mp.entrySet();
		 
		 for (Entry<String, String> entry : entrySet) {
			 String value = entry.getValue();
			 if (value!="praveen") {
				 System.out.println(entry);
				
			} else {

			}
//			 String key = entry.getKey();
//			 if (key!="name") {
//				 
//				
//			} else {
//				System.out.println(entry);
//
//			}
			
		}

		// String s = "145678";
		// String even = "";
		// String odd = "";
		//
		// for (int i = 0; i < s.length(); i++) {
		// char c = s.charAt(i);
		//// int in =
		//
		//
		// if (c%2== 0) {
		// even = even + c;
		//
		//
		// } else {
		// odd = odd + c;
		//
		// }
		// }
		//
		// System.out.println("even numbers "+even);
		// System.out.println("odd numbers "+odd);

//		String s = "java";
//		String t = "";
//
//		for (int i = 0; i < s.length(); i++) {
//
//			char c = s.charAt(i);
//			t = c + t;
//
//		}
//		System.out.println(t);
		 

	}

}
