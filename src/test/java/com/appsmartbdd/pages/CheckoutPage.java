package com.appsmartbdd.pages;

import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutPage extends BasePage {

	@FindBy(css = "div#order-total div.total-price div.value")
	private WebElement totalPrice2;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;

	@FindBy(css = "div.description span")
	private List<WebElement> paymentMethods;

	@FindBy(css = "button.button-order.positive-action")
	private WebElement placeMyOrderBtn;



	public String getTotalPriceFromOrderConfirmation() {
		System.out.println(totalPrice2.getText());
		return totalPrice2.getText();
	}

	public void fillOutAddressForm(List<String> list) {
		List<String> fields = new ArrayList<>(Arrays.asList("First name", "Last name", "Company", "Street", "Number", "Postal Code", "City", "Email", "Phone", "Additional directions"));

		for (int i = 0; i < fields.size(); i++) {
			WebElement element = driver.findElement(By.xpath("//*[contains(@placeholder,'" + fields.get(i) + "')]"));
			UtilityMethods.waitClickability(element, 2);
			element.sendKeys(list.get(i));
		}
	}

	public void clickInformMeCheckbox(){
		checkBox.click();
	}

	public void verifyCheckboxClicked(){
		Assert.assertTrue(checkBox.isSelected());
	}

	public List<String> getPaymentMethods(){
		List<String> paymentMethodsString = new ArrayList<>();
		for (int i = 0; i < paymentMethods.size(); i++) {
			paymentMethodsString.add(paymentMethods.get(i).getText());
		}
		return paymentMethodsString;
	}

	public void clickPaymentMethodAndProceed(String paymentMethod){
		String locator = "//span[text()='" + paymentMethod + "']";
		WebElement paymentWE = driver.findElement(By.xpath(locator));

		UtilityMethods.waitForVisibility(paymentWE,2);
		paymentWE.click();

		UtilityMethods.waitForVisibility(placeMyOrderBtn,2);
		placeMyOrderBtn.click();
	}

	public void getSuccessPaymentMessage(){
		String locator = "//p[text()='Your order was successful!']";
		WebElement successWE = driver.findElement(By.xpath(locator));
		UtilityMethods.waitForVisibility(successWE,4);
		Assert.assertTrue(successWE.isDisplayed());
	}








}
