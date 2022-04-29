package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.HomePage;
import com.appsmartbdd.pages.InitialPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef {

	private InitialPage initialPage = new InitialPage();
	private HomePage homePage = new HomePage();

	@Given("The user is on the initial page")
	public void the_user_is_on_the_initial_page() {
		initialPage.goInitialPage();
	}

	@Given("The user clicks {string}")
	public void the_user_clicks_(String company) {
		initialPage.clickCompany(company);
	}

	@When("The user search for {string}")
	public void the_user_search_for(String item) {
		homePage.searchItem(item);
	}

	@Then("{string} should appear on the page")
	public void should_appear_on_the_page(String item) {
		homePage.verifyExactSearch(item);
	}

	@Then("Items on the page must contain {string}")
	public void items_on_the_page_must_contain(String item) {
		homePage.verifyPartialSearch(item);
	}

	@Then("No item is shown on the page")
	public void no_item_is_shown_on_the_page() {
		homePage.verifyNoItemFound();
	}

}
