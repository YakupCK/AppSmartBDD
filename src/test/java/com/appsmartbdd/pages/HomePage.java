package com.appsmartbdd.pages;

import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {


	@FindBy(css = "svg.search-input-field-icon")
	private WebElement searchIcon;

	@FindBy(css = "input.ant-input.ant-input-sm.search-input.active")
	private WebElement searchBox;

	@FindBy(css = "div.productNameWrap h5")
	private List<WebElement> itemsDisplayed;

	@FindBy(css = "div.product-empty-list-message")
	private WebElement noItemFoundMessage;

	@FindBy(css = "button[type='submit'].button-order.positive-action")
	private WebElement confirmBtn;


	public void searchItem(String item) {
		UtilityMethods.waitClickability(By.cssSelector("svg.search-input-field-icon"), 5);
		searchIcon.click();
		UtilityMethods.waitForVisibility(searchBox, 2);
		searchBox.sendKeys(item);
	}

	public void verifyExactSearch(String item) {
		if (itemsDisplayed.size() == 0) {
			Assert.assertTrue(noItemFoundMessage.isDisplayed());
		} else {
			for (WebElement items : itemsDisplayed) {
				UtilityMethods.waitForVisibility(items, 1);
				Assert.assertTrue(items.getText().equals(item));
			}
		}
	}

	public void verifyPartialSearch(String item) {
		if (itemsDisplayed.size() == 0) {
			Assert.assertTrue(noItemFoundMessage.isDisplayed());
		} else {
			System.out.println(itemsDisplayed.size());
			for (WebElement items : itemsDisplayed) {
				UtilityMethods.waitForVisibility(items, 1);
				Assert.assertTrue(items.getText().toLowerCase().contains(item.toLowerCase()));
			}
		}
	}

	//pizza i.e
	public void selectMenu(String menu) {
		String menuLocator = "//span[text()='" + menu + "']";
		UtilityMethods.waitClickability(By.xpath(menuLocator), 2);
		driver.findElement(By.xpath(menuLocator)).click();
	}

	//click confirm
	public void clickConfirm(){
		UtilityMethods.waitClickability(confirmBtn,2);
		confirmBtn.click();
	}

}


//		foodGeneralMap.put(foodName, foodDetailsMap);