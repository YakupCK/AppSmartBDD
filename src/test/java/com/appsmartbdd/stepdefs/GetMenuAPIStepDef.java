package com.appsmartbdd.stepdefs;

import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMenuAPIStepDef {

	private static Response response;
	private static RequestSpecification request;
	private JsonPath jsonPath;
	private final Gson gson = new Gson();


	@When("I send a GET request with {string} endpoint")
	public void i_send_a_GET_request_with_endpoint(String endpoint) {
		response = request.get(endpoint);
	}

	@Then("Product id field in response body is {int}")
	public void product_id_field_in_response_body_is(int int1) {

	}

	@Then("Name field in response body is {string}")
	public void name_field_in_response_body_is(String string) {

	}

	@Then("Price of {string} is {double}")
	public void price_of_is(String string, double double1) {

	}

}
