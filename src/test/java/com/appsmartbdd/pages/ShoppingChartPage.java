package com.appsmartbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShoppingChartPage extends BasePage {

	@FindBy(id = "basket-item")
	private List<WebElement> allBasketItems;

	@FindBy(css = "div#shopping-card div.order-price div.value")
	private WebElement allTotalWithoutDiscount;

	@FindBy(css = "div#shopping-card div.discount div.title")
	private WebElement discountRate;

	@FindBy(css = "div#shopping-card div.total-price div.value")
	private WebElement allTotalWithDiscount;

	List<Map<String,String>> allBasketItemsAsList;


	public void getBasketItems(){
		allBasketItemsAsList = new ArrayList<>();
		Map<String, String> values = new LinkedHashMap<>();

		for (int i = 0; i < allBasketItems.size(); i++) {
			values.put("name", allBasketItems.get(i).findElement(By.cssSelector("div[class='product-name']")).getText());
			values.put("quantity", allBasketItems.get(i).findElement(By.cssSelector("div[class='count-label-wrapper']")).getText());
			values.put("size", allBasketItems.get(i).findElement(By.cssSelector("div[class='item-size']")).getText());
			values.put("itemTotalPrice", allBasketItems.get(i).findElement(By.cssSelector("div[class='item-price']")).getText());
			values.put("menuTotalPrice", allBasketItems.get(i).findElement(By.cssSelector("div[class='total-price']")).getText());
			allBasketItemsAsList.add(values);

			List<WebElement> allIngredients = allBasketItems.get(i).findElements(By.cssSelector("div[class='item-ingredient']"));
			for (int j = 0; j < allIngredients.size(); j++) {
				values = new LinkedHashMap<>();
				values.put("ingredientName", allIngredients.get(j).findElement(By.cssSelector("div[class='product-price']")).getText());
				values.put("itemTotalPrice", allIngredients.get(j).findElement(By.cssSelector("div[class='price-value']")).getText());
				allBasketItemsAsList.add(values);
			}
		}

		values = new LinkedHashMap<>();
		values.put("allTotalWithoutDiscount", allTotalWithoutDiscount.getText());
		values.put("discountRate", discountRate.getText());
		values.put("allTotalWithDiscount", allTotalWithDiscount.getText());
		allBasketItemsAsList.add(values);

		System.out.println("\n shoping chart is:");
		for (int i = 0; i < allBasketItemsAsList.size(); i++) {
			System.out.println(allBasketItemsAsList.get(i).toString());
		}

	}



//		System.out.println("--------------");
//		System.out.println(Driver.getDriver().findElement(By.xpath("//div[@id='basket-item']")).getText());
//		System.out.println("--------------");
//		System.out.println(Driver.getDriver().findElement(By.xpath("//div[@id='basket-item']//*[@class='item-ingredient']")).getText());




}
