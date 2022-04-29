package com.appsmartbdd.pages;

import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPaymentPage extends BasePage {

	@FindBy(css = "div.total-amount-description")
	private WebElement totalPrice;

	@FindBy(xpath = "//*[contains( normalize-space(text()), 'Kaufen' ) ]")
	private WebElement kaufen;

	public String getTotalPriceFromPaymentConfirmation(){
		UtilityMethods.scrollToElement(totalPrice);
		String rawTotalPrice = totalPrice.getText().trim();
		System.out.println(rawTotalPrice);
		return rawTotalPrice;
	}

	public void verifyConfirmationPage(){
		UtilityMethods.waitForURLContains("https://dev.delivery-app.app-smart.services/api3/",20);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://dev.delivery-app.app-smart.services/api3/"));
	}

	public void confirm(){
		UtilityMethods.scrollToElement(kaufen);
		UtilityMethods.waitClickability(kaufen,2);
		kaufen.click();
	}


}
