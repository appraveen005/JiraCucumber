package org.base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	public void header(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void querryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void reqBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public void basicAuth(String username, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}

	public Response methodType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endpoint);

			break;
		case "POST":
			response = reqSpec.post(endpoint);
			break;
		case "PUT":
			response = reqSpec.put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}
	public int responseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
		
	}
	
	public String getBodyAsString() {
		String asString = response.asString();
		return asString;
	}
	
	public String getBodyAsPrettyString() {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
	public String getValueByJsonPath(ResponseBody body, String key) {
		JsonPath jsonPath = body.jsonPath();
		String s = (String)jsonPath.get(key);
		return s;
	}
}
