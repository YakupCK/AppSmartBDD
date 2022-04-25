package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.MailPage;
import com.appsmartbdd.pages.ReservationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ReservationStepDef {

	private final ReservationPage reservationPage = new ReservationPage();
	private final MailPage mailPage = new MailPage();

	@When("The user clicks on Table reservation")
	public void the_user_clicks_on_Table_reservation() {
		reservationPage.clickReservationBtn();
	}

	@Then("The user should be able reservation menu shows up")
	public void the_user_should_be_able_reservation_menu_shows_up() {
		reservationPage.verifyReservationMenuOpen();
	}

	@When("The user enters {string} into {string} field")
	public void the_user_enters_into_field(String value, String field) {
		reservationPage.setFields(value,field);
	}

	@When("The user selects {string} as a date")
	public void the_user_selects_as_a_date(String date) {
		reservationPage.setDate(date);
	}

	@When("The user selects {string} as a time")
	public void the_user_selects_as_a_time(String time) {
		reservationPage.setTime(time);
	}

	@When("The user selects {int} people")
	public void the_user_selects_people(int people) {
		reservationPage.setPeople(people);
	}

	@When("The user clicks on I agree check box")
	public void the_user_clicks_on_I_agree_check_box() {
		reservationPage.clickIAgreeBtn();
	}

	@When("The user clicks on send button")
	public void the_user_clicks_on_send_button() {
		reservationPage.clickSendBtn();
	}

	@Then("The following confirmation message should be displayed")
	public void the_following_confirmation_message_should_be_displayed(List<String> message) {
		reservationPage.verifyConirmationMessage(message);
	}

	@Then("The user gets a confirmation email for reservation")
	public void the_user_gets_a_confirmation_email_for_reservation() {
		mailPage.verifyReservationEmailReceived();
	}

	@When("The user attempt to reserve without filling the form")
	public void the_user_attempt_to_reserve_without_filling_the_form() {
		reservationPage.clickSendBtn();
	}

	@Then("The user shouldn't reserve a table")
	public void the_user_shouldn_t_reserve_a_table() {
		reservationPage.verifySendBtnDisabled();
	}

	@When("The user attempt to reserve a previous date")
	public void the_user_attempt_to_reserve_a_previous_date() {
		reservationPage.clickDate();
	}

	@Then("The user shouldn't reserve a previous date")
	public void the_user_shouldn_t_reserve_a_previous_date() {
		reservationPage.verifyPreviousDateDisabled();
	}






}
