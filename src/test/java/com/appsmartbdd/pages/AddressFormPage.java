package com.appsmartbdd.pages;

import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddressFormPage extends BasePage {

	@FindBy(css = "div.heading--name")
	private WebElement addressDetailsText;

	@FindBy(css = "div.heading")
	private WebElement orderConfirmationText;

	//set any input field with desired value
	public void setInputField(String expValue, String field){
		String locator = "//*[contains(@placeholder,'"+field+"')]";
		WebElement fieldWE = driver.findElement(By.xpath(locator));
		UtilityMethods.waitClickability(By.xpath(locator),2);
		fieldWE.sendKeys(expValue);
	}

	//verify any input field with desired value
	public void veriyValuesEqual(String expValue, String field ){
//		WebElement fieldWE = driver.findElement(By.cssSelector("[placeholder='" + field + "']"));
		String locator = "//*[contains(@placeholder,'"+field+"')]";
		WebElement fieldWE = driver.findElement(By.xpath(locator));
		String actValue = fieldWE.getAttribute("value");
		Assert.assertEquals(expValue,actValue);
	}

	public void verifyAddressDetailsText(){
		UtilityMethods.waitForVisibility(addressDetailsText,2);
		Assert.assertTrue(addressDetailsText.isDisplayed());
	}

	public void verifyOrderConfirmationText(){
		Assert.assertTrue(orderConfirmationText.getText().equals("Order Confirmation"));
	}

	public void verifyNotOrderConfirmationText(){
		Assert.assertFalse(orderConfirmationText.getText().equals("Order Confirmation"));
	}

	public void clickCheckout(){
		try {
			String locator = "//button[contains(text(),'Checkout')] | //button//p[contains(text(),'Checkout')]";
			UtilityMethods.waitClickability(By.xpath(locator),3);
			driver.findElement(By.xpath(locator)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}
