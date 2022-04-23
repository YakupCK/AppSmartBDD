package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.InitialPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeliveryStepDef {

	InitialPage initialPage = new InitialPage();


	@When("The user selects a {string}")
	public void the_user_selects_a(String address) {
		initialPage.searchAddress(address);
	}

	@Then("The user should be able to proceed")
	public void the_user_should_be_able_to_proceed() {
		initialPage.ifAddressErrorNotDisplayed();
	}

	@Then("The user should NOT be able to proceed")
	public void the_user_should_NOT_be_able_to_proceed() {
		initialPage.ifAddressErrorDisplayed();
	}




}
