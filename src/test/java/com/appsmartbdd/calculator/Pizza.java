package com.appsmartbdd.calculator;

import com.appsmartbdd.pages.BasePage;
import com.appsmartbdd.utils.Driver;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pizza {

	protected WebDriver driver = Driver.getDriver();

	Map<String, Object> map1 = new LinkedHashMap<>();

	private String name;
	private double price;
	private int quantity;

	public void setName(String name) {
		this.name = name;
		map1.put("name", name);
	}

	public void setPrice(double price) {
		this.price = price;
		map1.put("price", price);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		map1.put("quantity", quantity);
	}

	Map<String, Map<String, Object>> ingredient1 = new LinkedHashMap<>();



	Map<String, Map<String, Object>> ingredientMap = new LinkedHashMap<>();


}
