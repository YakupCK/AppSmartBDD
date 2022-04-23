package com.appsmartbdd.pages;

import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PizzaPage extends BasePage {

	private List<Map<String, Object>> allOrders = new ArrayList<>();
	private Map<String, Object> individualOrder;

	private BigDecimal quantity;
	private String name;
	private BigDecimal itemSinglePrice;
	private BigDecimal itemTotalPrice;
	private BigDecimal menuTotalPrice;

	private BigDecimal discountRate = new BigDecimal("0.1");
	private BigDecimal allTotalWithoutDiscount = new BigDecimal(0);
	;
	private BigDecimal allTotalWithDiscount = new BigDecimal(0);

	//---"pizza salami" i.e---
	public void selectPizza(String name, String size) {
		//select pizza
		String menuNameLocator = "//div[@class='product-small-picture-container']//h5[text()='" + name + "']";
		UtilityMethods.waitClickability(By.xpath(menuNameLocator), 2);
		driver.findElement(By.xpath(menuNameLocator)).click();

		//select size
		String sizeLocator = "//div[@class='size-text'][contains(text(),'" + size + "')]";
		UtilityMethods.waitClickability(By.xpath(sizeLocator), 2);
		driver.findElement(By.xpath(sizeLocator)).click();

		//get the price
		menuTotalPrice = new BigDecimal(0);
		String priceString = driver.findElement(By.xpath(sizeLocator + "/..//div[@class='price']")).getText();

		//assign all values and put to the map
		setValues(1, name, priceString);
		individualOrder.put("size", size);
	}

	//---"Extrazutaten 1 (0)" i.e---
	public void selectExtraZutaten(String zutatenHeader) {
		//ingredient main menu name click
		String zutatenHeaderLocator = "//div[@data-testid='extra-group']//*[contains(text(), '" + zutatenHeader + "')]";
		UtilityMethods.waitClickability(By.xpath(zutatenHeaderLocator), 2);
		driver.findElement(By.xpath(zutatenHeaderLocator)).click();
	}

	//---add ananas i.e---
	public void addIngredient(String ingredientName, int quantity) {
		//click on + buttuon
		String addIngredientBtn = "//*[text()='" + ingredientName + "']";
		for (int i = 0; i < quantity; i++) {
			UtilityMethods.waitClickability(By.xpath(addIngredientBtn), 2);
			driver.findElement(By.xpath(addIngredientBtn)).click();
		}

		//single ingredient price
		String ingredientPriceLocator = addIngredientBtn + "/..//div[contains(@class,'price')]";
		String priceString = driver.findElement(By.xpath(ingredientPriceLocator)).getText();

		//assign all values and put to the map
		setValues(quantity, ingredientName, priceString);
	}

	//---remove ananas i.e---
	public void removeIngredient(String ingredientName, int quantity) {
		//click on - buttuon
		String removeIngredientBtn = "(//*[text()='" + ingredientName + "']/../../div/i)[1]";
		for (int i = 0; i < quantity; i++) {
			UtilityMethods.waitClickability(By.xpath(removeIngredientBtn), 2);
			driver.findElement(By.xpath(removeIngredientBtn)).click();
		}

		//update the values
		for (Map<String, Object> individualOrder : allOrders) {
			if (individualOrder.get("name").equals(ingredientName)) {
				individualOrder.put("quantity", ((BigDecimal) individualOrder.get("quantity")).subtract(new BigDecimal(quantity)));
				individualOrder.put("itemTotalPrice", ((BigDecimal) individualOrder.get("quantity")).multiply(((BigDecimal) individualOrder.get("singlePrice"))));
				individualOrder.put("menuTotalPrice", ((BigDecimal) individualOrder.get("menuTotalPrice")).subtract(new BigDecimal(quantity).multiply((BigDecimal) individualOrder.get("singlePrice"))));
//				allTotalWithoutDiscount = allTotalWithDiscount.subtract(new BigDecimal(quantity).multiply(((BigDecimal) individualOrder.get("singlePrice"))));
			}
		}

	}

	//convert the price from String into double
	public BigDecimal priceConverter(String priceString) {
		priceString = priceString.replaceAll("[^\\d,]", "");
		priceString = priceString.replace(",", ".");
		System.out.println(Double.parseDouble(priceString));
//		return Double.parseDouble(priceString);
		return new BigDecimal(priceString);
	}

	//set all the values
	public void setValues(int quantity, String name, String singlePrice) {
		individualOrder = new LinkedHashMap<>();

		this.quantity = new BigDecimal(quantity);
		this.name = name;
		this.itemSinglePrice = priceConverter(singlePrice);
		this.itemTotalPrice = this.itemSinglePrice.multiply(this.quantity);
		this.menuTotalPrice = this.menuTotalPrice.add(this.itemTotalPrice);
		this.allTotalWithoutDiscount = allTotalWithDiscount.add(this.menuTotalPrice);

		individualOrder.put("name", this.name);
		individualOrder.put("quantity", this.quantity);
		individualOrder.put("singlePrice", this.itemSinglePrice);
		individualOrder.put("itemTotalPrice", this.itemTotalPrice);

		//update the values
		for (Map<String, Object> individualOrder : allOrders) {
			if (individualOrder.get("menuTotalPrice") == null) {
				individualOrder.put("menuTotalPrice", this.menuTotalPrice);
			} else {
//				individualOrder.put("quantity", ((BigDecimal) individualOrder.get("quantity")).subtract(new BigDecimal(quantity)));
//				individualOrder.put("itemTotalPrice", ((BigDecimal) individualOrder.get("quantity")).multiply(((BigDecimal) individualOrder.get("singlePrice"))));
//				individualOrder.put("menuTotalPrice", ((BigDecimal) individualOrder.get("menuTotalPrice")).subtract(new BigDecimal(quantity).multiply((BigDecimal) individualOrder.get("singlePrice"))));
				individualOrder.put("menuTotalPrice", ((BigDecimal) individualOrder.get("menuTotalPrice")).add(this.menuTotalPrice));
//				allTotalWithoutDiscount = allTotalWithDiscount.subtract(new BigDecimal(quantity).multiply(((BigDecimal) individualOrder.get("singlePrice"))));
			}
		}

//		if (individualOrder.get("menuTotalPrice") == null) {
//			individualOrder.put("menuTotalPrice", this.menuTotalPrice);
//		} else {
//			individualOrder.put("menuTotalPrice", ((BigDecimal) individualOrder.get("menuTotalPrice")).add(this.menuTotalPrice));
//		}

		allOrders.add(individualOrder);

	}

	//get allOrder list
	public List<Map<String, Object>> getAllOrders() {
		return allOrders;
	}

	public void setTotalOrderDiscount() {
		individualOrder = new LinkedHashMap<>();
		individualOrder.put("allTotalWithoutDiscount", this.allTotalWithoutDiscount);
		individualOrder.put("allTotalWithDiscount", this.allTotalWithoutDiscount.subtract(this.allTotalWithoutDiscount.multiply(discountRate)));
		allOrders.add(individualOrder);
	}


}
