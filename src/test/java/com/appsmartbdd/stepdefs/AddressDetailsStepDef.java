package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.AddressFormPage;
import com.appsmartbdd.pages.HomePage;
import com.appsmartbdd.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressDetailsStepDef {

	private HomePage homePage = new HomePage();
	private AddressFormPage addressFormPage = new AddressFormPage();


	@Then("Address & personal details form must appear")
	public void address_personal_details_form_must_appear() {
		addressFormPage.verifyAddressDetailsText();
	}

	@When("The user enters valid {string} to {string} field")
	public void the_user_enters_valid_to_field(String expValue, String field) {
		addressFormPage.setInputField(expValue, field);
		addressFormPage.veriyValuesEqual(expValue, field);
	}

	@When("The user enters invalid {string} to {string} field")
	public void the_user_enters_invalid_to_field(String expValue, String field) {
		addressFormPage.setInputField(expValue, field);
//		addressFormPage.verifyErrorMessage(field);
	}


	@Then("All inputs must be accepted and the user can proceed to checkout")
	public void allInputsMustBeAcceptedAndTheUserCanProceedToCheckout() {
		addressFormPage.clickCheckout();
		addressFormPage.verifyOrderConfirmationText();
	}

	@Then("A warning message should be displayed under each field")
	public void a_warning_message_should_be_displayed_under_each_field() {

	}

	@Then("The user shouldn't proceed to checkout")
	public void the_user_shouldn_t_proceed_to_checkout() {
		addressFormPage.verifyAddressDetailsText();
		addressFormPage.verifyNotOrderConfirmationText();
	}



}
