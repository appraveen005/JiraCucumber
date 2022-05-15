package org.interv;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APIDemo {

//	@Test
	public void createIssue() {

		RequestSpecification reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "application/json");

		reqSpec = reqSpec.auth().preemptive().basic("appraveen005@gmail.com", "pl8LNoik58l1u9Hier3N2BE2");

		reqSpec = reqSpec.body("{\r\n" + "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
				+ "          \"key\": \"JIR\"\r\n" + "       },\r\n"
				+ "       \"summary\": \"Raising bug for login funcionality\",\r\n"
				+ "       \"description\": \"User logining in with invalid username\",\r\n"
				+ "       \"issuetype\": {\r\n" + "          \"name\": \"Bug\"\r\n" + "       }\r\n" + "   }\r\n"
				+ "}");

		Response response = reqSpec.post("https://appraveen005.atlassian.net/rest/api/2/issue/");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(201, statusCode);

		ResponseBody body = response.getBody();

		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);

		String object = response.jsonPath().get("self");

		boolean contains = object.contains("appraveen005");
		Assert.assertTrue(contains);

		Map<Object, Object> map = response.jsonPath().getMap("$");

		System.out.println(map);

	}

//	@Test
	public void modifyIssue() {
		given().header("Content-Type","application/json").auth()
		.preemptive().basic("appraveen005@gmail.com", "pl8LNoik58l1u9Hier3N2BE2").body("{\r\n" + "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
				+ "          \"key\": \"JIR\"\r\n" + "       },\r\n"
				+ "       \"summary\": \"Modified with PUT\",\r\n"
				+ "       \"description\": \"User logining as modified\",\r\n"
				+ "       \"issuetype\": {\r\n" + "          \"name\": \"Bug\"\r\n" + "       }\r\n" + "   }\r\n"
				+ "}").when().put("https://appraveen005.atlassian.net/rest/api/2/issue/JIR-32").then().assertThat().statusCode(204);
//		int statusCode = response.getStatusCode();
		
//		Assert.assertEquals(204, statusCode);
//		System.out.println(statusCode);
		
	}
	@Test
	public void deleteIssue() {
		
		given().auth().preemptive().basic("appraveen005@gmail.com", "pl8LNoik58l1u9Hier3N2BE2").when().delete("https://appraveen005.atlassian.net/rest/api/3/issue/JIR-31").then().assertThat().statusCode(204);
		
		
		
		
	}
}
