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




}
