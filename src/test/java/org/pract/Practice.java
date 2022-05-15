package org.pract;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Practice {
	
	public static void main(String[] args) {
		
//		Map<String, String> map = new HashMap<String, String>();
//		
//		map.put("id", "2727");
//		map.put("petId", "2727");
//		map.put("quantity", "2");
//		map.put("shipDate", "2022-04-13T09:29:18.899Z");
//		map.put("status", "placed");
//		map.put("complete", "true");
//		
//		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order";
//		Response response = given().header("content-Type","application/json")
//		.body(map)
//		.when().post();
//		System.out.println(response.getStatusCode());
//		ResponseBody body = response.getBody();
//		System.out.println(body.asString());
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order/2727";
		
		Response response = given().header("content-Type","application/json")
		.when()
//		.get();
		.delete();
		
		String s = response.jsonPath().get("type");
		System.out.println(response.getStatusCode());
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		
		Assert.assertEquals(response.getStatusCode(), 404);
		Assert.assertEquals(body.asString().contains("Order Not Found"), true);
		
		
		
		
	}
	

}
