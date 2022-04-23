package com.appsmartbdd.stepdefs;

import com.appsmartbdd.pages.HomePage;
import com.appsmartbdd.pages.PizzaPage;
import com.appsmartbdd.pages.ShoppingChartPage;
import com.appsmartbdd.utils.Driver;
import com.appsmartbdd.utils.UtilityMethods;
import com.sun.javafx.webkit.UtilitiesImpl;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectMenuStepDef {

	HomePage homePage = new HomePage();
	PizzaPage pizzaPage = new PizzaPage();
	ShoppingChartPage shoppingChartPage = new ShoppingChartPage();


	@When("The user chooses {string} from {string} with the size of {string}")
	public void the_user_chooses_from_with_the_size_of(String foodName, String menu, String size) {
		homePage.selectMenu(menu);
		pizzaPage.selectPizza(foodName, size);
	}

	@When("adds {string} from {string} by {int} times")
	public void adds_from_by_times(String ingredient, String ingredientMenu, int quantity) {
		pizzaPage.selectExtraZutaten(ingredientMenu);
		pizzaPage.addIngredient(ingredient, quantity);
	}

	@When("The user reduces {string} from {string} by {int} times")
	public void the_user_reduces_from_by_times(String ingredient, String ingredientMenu, int quantity) {
		pizzaPage.selectExtraZutaten(ingredientMenu);
		pizzaPage.removeIngredient(ingredient,quantity);
	}

	@When("clicks on Confirm Btn")
	public void clicks_on_Confirm_Btn() {
		pizzaPage.setTotalOrderDiscount();
		homePage.clickConfirm();
		System.out.println(pizzaPage.getAllOrders());
	}

	@Then("All the choices must be seen in Shopping Chart with the correct amount and price")
	public void all_the_choices_must_be_seen_in_Shopping_Chart_with_the_correct_amount_and_price() {
		shoppingChartPage.getBasketItems();


//		System.out.println(Driver.getDriver().findElement(By.xpath("//div[@id='basket-item']//div[@class='product-name']")).getText());
//		System.out.println("--------------");
//		System.out.println(Driver.getDriver().findElement(By.xpath("//div[@id='basket-item']")).getText());
//		System.out.println("--------------");
//		System.out.println(Driver.getDriver().findElement(By.xpath("//div[@id='basket-item']//*[@class='item-ingredient']")).getText());
//
//		System.out.println("--------------");
//		List<WebElement> allBasketItems = Driver.getDriver().findElements(By.xpath("//div[@id='basket-item']"));
//		System.out.println(allBasketItems.get(0).findElement(By.xpath("//div[@class='product-name']")).getText());

	}






}
