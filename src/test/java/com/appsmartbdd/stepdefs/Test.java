package com.appsmartbdd.stepdefs;

import com.appsmartbdd.utils.Driver;
import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
//		String size = "36";
//		String pizzaName = "Pizza Salami";

		driver.get("https://sandbox.crefopay.de/hosted-pages/6266bf0d03aa7a18a978a90c");
		WebElement dropdown1 = driver.findElement(By.id("ember9"));
		dropdown1.click();

		UtilityMethods.wait(1);
		WebElement option3 = driver.findElement(By.xpath("//div[@class='select-items']//div[text()='03']"));
		option3.click();


	}

}
