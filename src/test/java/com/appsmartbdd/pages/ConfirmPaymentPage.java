package com.appsmartbdd.pages;

import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPaymentPage extends BasePage {

	@FindBy(css = "div.total-amount-description")
	private WebElement totalPrice;


	public String getTotalPriceFromPaymentConfirmation(){
		UtilityMethods.scrollToElement(totalPrice);
		String rawTotalPrice = totalPrice.getText().trim();
		System.out.println(rawTotalPrice);
		return rawTotalPrice;
	}


}
