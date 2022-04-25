package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.MenuPage;
import com.appsmartbdd.pages.ShoppingChartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectMenuStepDef {

	MenuPage menuPage = new MenuPage();
	ShoppingChartPage shoppingChartPage = new ShoppingChartPage();


	@When("The user chooses {string} from {string} with the size of {string}")
	public void the_user_chooses_from_with_the_size_of(String foodName, String menu, String size) {
		menuPage.selectMenu(menu);
		menuPage.selectFoodItem(foodName, size);
	}

	@When("adds {string} from {string} by {int} times")
	public void adds_from_by_times(String ingredient, String ingredientMenu, int quantity) {
		menuPage.selectExtraZutaten(ingredientMenu);
		menuPage.addIngredient(ingredient, quantity);
	}

	@When("The user reduces {string} from {string} by {int} times")
	public void the_user_reduces_from_by_times(String ingredient, String ingredientMenu, int quantity) {
		menuPage.selectExtraZutaten(ingredientMenu);
		menuPage.removeIngredient(ingredient,quantity);
	}

	@When("clicks on Confirm Btn")
	public void clicks_on_Confirm_Btn() {
		menuPage.clickConfirm();
	}

	@Then("All the choices must be seen in Shopping Chart with the correct amount and price")
	public void all_the_choices_must_be_seen_in_Shopping_Chart_with_the_correct_amount_and_price() {
		System.out.println(menuPage.getAllOrders());
		System.out.println("-----------------");
		shoppingChartPage.getShoplistText();
		shoppingChartPage.verifyOrders(shoppingChartPage.getShoplistText(), menuPage.getAllOrders());
	}



}
