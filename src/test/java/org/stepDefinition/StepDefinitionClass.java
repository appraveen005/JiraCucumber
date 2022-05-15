package org.stepDefinition;

import org.base.BaseClass;
import org.dep.CreateIssueOutput;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class StepDefinitionClass extends BaseClass {
	Response response;
	 public static String keys;
	@Given("User should add header {string}, {string}")
	public void user_should_add_header(String key, String value) {
		header(key, value);
	}

	@When("User should add basic Auth {string}, {string}")
	public void user_should_add_basic_Auth(String username, String password) {
		basicAuth(username, password);
	}

	@When("User should add body")
	public void user_should_add_body(String docString) {
		reqBody(docString);
	}

	@When("User should add {string} to send request {string}")
	public void user_should_add_to_send_request(String type, String endpoint) {
		response = methodType(type, endpoint);
		CreateIssueOutput output = response.as(CreateIssueOutput.class);
		keys = output.getKey();
	}

	@Then("user should verify {string}")
	public void user_should_verify(String s) {
		int responseCode = responseCode(response);
		Assert.assertEquals(responseCode, Integer.parseInt(s));
		System.out.println(getBodyAsPrettyString());
	}
	
	@Then("User should verify {string} contains {string}")
	public void user_should_verify_contains(String key, String value) {
		ResponseBody body = response.getBody();
		String actValue = getValueByJsonPath(body, key);
		boolean b = actValue.contains(value);
		Assert.assertTrue(b);
	}

	@Given("User should add header {string}, {string} for modify")
	public void user_should_add_header_for_modify(String key, String value) {
		header(key, value);
	}

	@When("User should add basic Auth {string}, {string} for modify")
	public void user_should_add_basic_Auth_for_modify(String username, String password) {
		basicAuth(username, password);
	}

	@When("User should add body for modify")
	public void user_should_add_body_for_modify(String docString) {
		reqBody(docString);
	}

	@When("User should add {string} to send request {string} for modify")
	public void user_should_add_to_send_request_for_modify(String type, String endpoint) {
		response = methodType(type, endpoint+keys);
	}

	@Then("user should verify {string} for modify")
	public void user_should_verify_for_modify(String s) {
		int responseCode = responseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, Integer.parseInt(s));
		System.out.println(getBodyAsPrettyString());
	}

	@Given("User should add header {string}, {string} for delete")
	public void user_should_add_header_for_delete(String key, String value) {
		header(key, value);
	}

	@When("User should add basic Auth {string}, {string} for delete")
	public void user_should_add_basic_Auth_for_delete(String username, String password) {
		basicAuth(username, password);
	}

	@When("User should add {string} to send request {string} for delete")
	public void user_should_add_to_send_request_for_delete(String type, String endpoint) {
		response = methodType(type, endpoint+keys);
	}

	@Then("user should verify {string} for delete")
	public void user_should_verify_for_delete(String s) {
		int responseCode = responseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, Integer.parseInt(s));
	}

	@Given("User should add header {string}, {string} for get")
	public void user_should_add_header_for_get(String key, String value) {
		header(key, value);
	}

	@When("User should add basic Auth {string}, {string} for get")
	public void user_should_add_basic_Auth_for_get(String username, String password) {
		basicAuth(username, password);
	}

	@When("User should add {string} to send request {string} for get")
	public void user_should_add_to_send_request_for_get(String type, String endpoint) {
		response = methodType(type, endpoint);
	}

	@Then("user should verify {string} for get")
	public void user_should_verify_for_get(String s) {
		int responseCode = responseCode(response);
		System.out.println(responseCode);
//		System.out.println(getBodyAsPrettyString());
		Assert.assertEquals(responseCode, Integer.parseInt(s));
	}

}
