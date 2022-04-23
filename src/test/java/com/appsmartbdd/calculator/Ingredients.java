package com.appsmartbdd.calculator;

import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.By;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ingredients extends Pizza {

	Map<String, Map<String, Object>> allIngredients = new LinkedHashMap<>();
	Map<String, Object> individualIngredients = new LinkedHashMap<>();

	private String name;
	private double price;

	public void setName(String name) {
		this.name = name;
		allIngredients.put(name, individualIngredients);
	}

	public void setPrice() {
//		String ingredientPriceLocator = addIngredientBtn + "/..//div[contains(@class,'price')]";
//		String priceString = driver.findElement(By.xpath(ingredientPriceLocator)).getText();
//		priceString = priceString.replaceAll("[^\\d.]", "");
//		System.out.println(priceString);
//		double price = Double.parseDouble(priceString) * quantity;
	}

	//add ananas i.e
	public void addIngredientName(int quantity) {
		String addIngredientBtn = "(//*[text()='" + name + "']/../../div/i)[2]";
		for (int i = 0; i < quantity; i++) {
			UtilityMethods.waitClickability(By.xpath(addIngredientBtn), 2);
			driver.findElement(By.xpath(addIngredientBtn)).click();
		}

		String ingredientPriceLocator = addIngredientBtn + "/..//div[contains(@class,'price')]";
		String priceString = driver.findElement(By.xpath(ingredientPriceLocator)).getText();
		priceString = priceString.replaceAll("[^\\d.]", "");
		System.out.println(priceString);
		double price = Double.parseDouble(priceString) * quantity;

//		foodDetailsMap.put("name", ingredientName);
//		foodDetailsMap.put("price", price);
//		foodDetailsMap.put("quantity", quantity);
//		foodGeneralMap.put(foodName, foodDetailsMap);

	}

	//remove ananas i.e
	public void removeSubExtraMenu(int quantity) {
		String removeIngredientBtn = "(//*[text()='" + name + "']/../../div/i)[1]";
		for (int i = 0; i < quantity; i++) {
			UtilityMethods.waitClickability(By.xpath(removeIngredientBtn), 2);
			driver.findElement(By.xpath(removeIngredientBtn)).click();
		}

		String ingredientPriceLocator = removeIngredientBtn + "/..//div[contains(@class,'price')]";
		String priceString = driver.findElement(By.xpath(ingredientPriceLocator)).getText();
		priceString = priceString.replaceAll("[^\\d.]", "");
		System.out.println(priceString);
		double price = Double.parseDouble(priceString) * quantity * -1;

//		foodDetailsMap.put("price", price);
//		foodDetailsMap.put("quantity", quantity);
//		foodGeneralMap.put(foodName, foodDetailsMap);
	}


}
