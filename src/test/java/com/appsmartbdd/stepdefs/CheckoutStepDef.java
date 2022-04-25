package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.*;
import com.appsmartbdd.utils.UtilityMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CheckoutStepDef {

	private String totalPrice;

	private final MenuPage menuPage = new MenuPage();
	private final HomePage homePage = new HomePage();
	private final CheckoutPage checkoutPage = new CheckoutPage();
	private final AddressFormPage addressFormPage = new AddressFormPage();
	private final MailPage mailPage = new MailPage();
	private final SandBoxPage sandBoxPage = new SandBoxPage();
	private final ConfirmPaymentPage confirmPaymentPage = new ConfirmPaymentPage();


	@When("The user clicks on Order Button")
	public void the_user_clicks_on_Order_Button() {
		homePage.clickOrderNow();
	}

	@Given("The user fills out the address form with followings and proceed to checkout")
	public void the_user_fills_out_the_address_form_with_followings_and_proceed_to_checkout(List<String> list) {
		menuPage.clickConfirm();
		this.totalPrice = menuPage.getTotalPriceFromShoppingCart();
		homePage.clickOrderNow();
		checkoutPage.fillOutAddressForm(list);
		addressFormPage.clickCheckout();
	}


	@Then("Total price on the confirmation menu is the same as shopping chart menu")
	public void total_price_on_the_confirmation_menu_is_the_same_as_shopping_chart_menu() {
		Assert.assertEquals(this.totalPrice,checkoutPage.getTotalPriceFromOrderConfirmation() );
	}

	@When("The user clicks on inform me check box")
	public void the_user_clicks_on_inform_me_check_box() {
		checkoutPage.clickInformMeCheckbox();
	}

	@Then("inform me check box gets clicked")
	public void inform_me_check_box_gets_clicked() {
		checkoutPage.verifyCheckboxClicked();
	}

	@Then("available payment methods are as listed below")
	public void available_payment_methods_are_as_listed_below(List<String> expPayments) {
		Assert.assertEquals(expPayments,checkoutPage.getPaymentMethods());
	}

	@When("The user selects {string} payment method and proceed")
	public void the_user_selects_payment_method_and_proceed(String paymentMethod) {
		checkoutPage.clickPaymentMethodAndProceed(paymentMethod);
	}

	@Then("The user should see a success message")
	public void the_user_should_see_a_success_message() {
		checkoutPage.getSuccessPaymentMessage();
	}

	@Then("The user gets a confirmation email for order")
	public void the_user_gets_a_confirmation_email_for_order() {
		mailPage.verifyOrderEmailReceived();
	}

	@Then("Total price on the email is the same as confirmation menu")
	public void total_price_on_the_email_is_the_same_as_confirmation_menu() {
		Assert.assertEquals(this.totalPrice, mailPage.getTotalPriceFromMail() );
	}

	@Then("The user is on the visa page")
	public void the_user_is_on_the_visa_page() {
		UtilityMethods.waitForURLContains("https://sandbox.crefopay.de/",5);
	}

	@When("The user enters valid credit card numbers and proceed")
	public void the_user_enters_valid_credit_card_numbers_and_proceed() {
		sandBoxPage.enterCardInfo();
	}

	@Then("The user lands on the confirm payment page")
	public void the_user_lands_on_the_confirm_payment_page() {
		UtilityMethods.waitForURLContains("https://dev.delivery-app.app-smart.services/api3/",6);
	}

	@Then("The total amount on the confirm payment page is the same as shopping chart menu")
	public void the_total_amount_on_the_confirm_payment_page_is_the_same_as_shopping_chart_menu() {
		Assert.assertEquals(this.totalPrice, confirmPaymentPage.getTotalPriceFromPaymentConfirmation() );
	}

	@When("The user clicks on confirm button and enters the received sms code")
	public void the_user_clicks_on_confirm_button_and_enters_the_received_sms_code() {
	}

	@Then("The order is successful")
	public void the_order_is_successful() {
	}

}
