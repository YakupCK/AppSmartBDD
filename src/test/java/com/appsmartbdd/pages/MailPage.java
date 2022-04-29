package com.appsmartbdd.pages;

import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends BasePage {


	@FindBy(xpath = "//*[contains(normalize-space(text()), 'Enjoy+Pizza+Bremen')]/..//*[contains(normalize-space(text()), 'just now')]/..")
	private WebElement lastMail;

	@FindBy(xpath = "//*[contains(normalize-space(text()), 'Ihre Reservierung')]/..//*[contains(normalize-space(text()), 'just now')]/..")
	private WebElement lastMailForReservation;

	@FindBy(css = "td#message")
	private WebElement mailReservationConfirmation;

	@FindBy(css = "iframe#html_msg_body")
	private WebElement mailIframe;


	public void verifyReservationEmailReceived(){
		((JavascriptExecutor)driver).executeScript("window.open();");

		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		UtilityMethods.switchToWindow(1);
		driver.get(PropertyReader.getProperty("emailURL"));

		UtilityMethods.waitClickability(lastMailForReservation,3);
		lastMailForReservation.click();

		UtilityMethods.switchToFrame(mailIframe);

		UtilityMethods.waitForVisibility(mailReservationConfirmation,3);
		Assert.assertEquals(mailReservationConfirmation.getText(),"Ihre Tischreservierung wurde übermittelt");
	}

	public void verifyOrderEmailReceived(){
		UtilityMethods.wait(1);
		((JavascriptExecutor)driver).executeScript("window.open();");

		UtilityMethods.waitUntilNumberOfWindows(2);

		UtilityMethods.switchToWindow(1);
		driver.get(PropertyReader.getProperty("emailURL"));

		UtilityMethods.waitClickability(lastMail,3);
		lastMail.click();

		UtilityMethods.switchToFrame(mailIframe);

		String locator = "//*[text()='Wir haben Deine Bestellung erhalten. Die Bestellnummer lautet ']";
		WebElement successWE = driver.findElement(By.xpath(locator));

		UtilityMethods.waitForVisibility(successWE,3);
		Assert.assertTrue(successWE.isDisplayed());
	}


	public String getTotalPriceFromMail(){

		WebElement totalPrice = driver.findElement(By.xpath("(//tr[@id='total']//p)[2]"));
		UtilityMethods.scrollToElement(totalPrice);
		UtilityMethods.waitForVisibility(totalPrice,3);
		System.out.println("total price in the mail: " + totalPrice.getText());
		return totalPrice.getText();
	}


}
