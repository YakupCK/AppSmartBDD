package com.appsmartbdd.stepdefs;

import com.appsmartbdd.utils.Driver;
import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {

	static Map<String, Map<String, Object>> allShoppingChartItems = new LinkedHashMap<>();

	public static void main(String[] args) {

		WebDriver driver = Driver.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String size = "36";
		String pizzaName = "Pizza Salami";

		driver.get(PropertyReader.getProperty("url"));
		driver.findElement(By.xpath("(//button)[2]")).click();

		String menuNameLocator = "//div[@class='product-small-picture-container']//h5[text()='" + pizzaName + "']";
		UtilityMethods.waitClickability(By.xpath(menuNameLocator), 2);
		driver.findElement(By.xpath(menuNameLocator)).click();

		//size selector
		String sizeLocator = "//div[@class='size-text'][contains(text(),'" + size + "')]";
		UtilityMethods.waitClickability(By.xpath(sizeLocator), 2);
		driver.findElement(By.xpath(sizeLocator)).click();

		//price getter
		String priceString = driver.findElement(By.xpath(sizeLocator + "/..//div[@class='price']")).getText();
		priceString = priceString.replaceAll("[^\\d,]", "");
		priceString = priceString.replace(",", ".");
		System.out.println(priceString);
		System.out.println(Double.parseDouble(priceString));



		//1st---------------------------
		String name1 = "pizza margarita";
		double count1 = 2;
		double price1 = 5.0;

		Map<String, Object> shoppingItem1 = new LinkedHashMap<>();
		shoppingItem1.put("name", name1);
		shoppingItem1.put("count", count1);
		shoppingItem1.put("price", price1);

		allShoppingChartItems.put((String) shoppingItem1.get("name"), shoppingItem1);

		//2st-------------------------
		String name2 = "pizza salami";
		double count2 = 1;
		double price2 = 7.0;

		Map<String, Object> shoppingItem2 = new LinkedHashMap<>();
		shoppingItem2.put("name", name2);
		shoppingItem2.put("count", count2);
		shoppingItem2.put("price", price2);

		allShoppingChartItems.put((String) shoppingItem2.get("name"), shoppingItem2);

		//result---------------------

		System.out.println(allShoppingChartItems.get(name1).toString());
		System.out.println(allShoppingChartItems.get(name2).toString());




	}

}
