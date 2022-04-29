package com.appsmartbdd.stepdefs;

import com.appsmartbdd.utils.PropertyReader;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Map;

public class ReservationAPIStepDef {

	private static Response response;
	private static RequestSpecification request;
	private static String expectedDate;
	private static String expectedTime;
	private static String expectedMessage;
	private JsonPath jsonPath;
	private final Gson gson = new Gson();

	@Given("I connected to Base URI")
	public void i_connected_to_Base_URI() {
		RestAssured.baseURI = PropertyReader.getProperty("base_URI");
	}

	@Given("Base Path is {string}")
	public void base_path_is(String endpoint) {
		RestAssured.basePath = endpoint;
	}

	@Given("Content-type is {string}")
	public void content_type_is(String contentType) {
		request = RestAssured.given();
		request.header("Content-Type", contentType);
	}

	@Given("Accept is {string}")
	public void accept_is(String string) {
		request.header("Accept", "application/json");
	}

	@When("I send a POST request with the following JSON model")
	public void i_send_a_POST_request_with_the_following_JSON_model(String requestBody) {
		Map requestBodyMap = gson.fromJson(requestBody, Map.class);
		expectedDate = (String) requestBodyMap.get("date");
		expectedTime = (String) requestBodyMap.get("time");
		response = request.body(requestBodyMap).post();
	}

	@Then("the status code is {int}")
	public void the_status_code_is(int statusCode) {
		Assert.assertEquals(statusCode, response.statusCode());
	}

	@Then("Success field in response body is {string}")
	public void success_field_in_response_body_is(String boolValue) {
		jsonPath = response.jsonPath();
		Assert.assertEquals(boolValue, jsonPath.getString("success"));
	}

	@Then("Datum field in response body includes the date and time")
	public void datum_field_in_response_body_includes_the_date_and_time() {
		jsonPath = response.jsonPath();
		System.out.println(jsonPath.getString("datum"));
		Assert.assertTrue(jsonPath.getString("datum").contains(expectedDate));

		String[] split = expectedTime.split(":");
		int hour = Integer.parseInt(split[0]) - 2;
		String expHour = String.valueOf(hour + ":" + split[1] + ":" + split[2]);
		Assert.assertTrue(jsonPath.getString("datum").contains(expHour));

	}

	@Then("the status code is NOT {int}")
	public void the_status_code_is_NOT(int statusCode) {
		Assert.assertNotEquals(statusCode, response.statusCode());
	}

	@Then("An error message is displayed")
	public void an_error_message_is_displayed() {
		jsonPath = response.jsonPath();
		Assert.assertTrue(jsonPath.getString("error").length() != 0);
	}

	@When("I send a POST request without a request body")
	public void i_send_a_POST_request_without_a_request_body() {
		response = request.body("").post();
	}


	@When("I send a GET request with the path parameter {int}")
	public void i_send_a_GET_request_with_the_path_parameter(int id) {
		response = request.pathParam("id", id)
				.when().get("{id}");
	}

	@Then("Product id field in response body is {int}")
	public void product_id_field_in_response_body_is(int id) {
		jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.getString("product_id"),String.valueOf(id));
	}
	@Then("Product id field in response body is {string}")
	public void product_id_field_in_response_body_is(String string) {

	}

	@Then("Name field in response body is {string}")
	public void name_field_in_response_body_is(String name) {
		jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.getString("d.name"),name);
	}


	@Then("Content-type in response is {string}")
	public void content_type_in_response_is(String contentType) {
		Assert.assertEquals(response.contentType(), contentType);
	}





}
