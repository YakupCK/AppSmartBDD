package com.appsmartbdd.pages;

import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.rmi.CORBA.Util;
import java.util.List;

public class ReservationPage extends BasePage {

	@FindBy(partialLinkText = "Table reservation")
	private WebElement reservationBtn;

	@FindBy(xpath = "//div[text()='Table reservation']")
	private WebElement reservationMenuText;

	@FindBy(xpath = "//*[text()='Send']/..")
	private WebElement sendBtn;

	@FindBy(partialLinkText = "Today")
	private WebElement todayBtn;

	@FindBy(xpath = "//*[contains(@placeholder,'Date')]")
	private WebElement dateBtn;

	@FindBy(xpath = "//*[text()='Time']")
	private WebElement timeBtn;

	@FindBy(xpath = "//*[@class='plus']")
	private WebElement plusBtn;

	@FindBy(xpath = "//*[@type='checkbox']")
	private WebElement iAgreeCheckbox;

	@FindBy(xpath = "//a[@title='Previous month (PageUp)']")
	private WebElement previousMonthBtn;



	public void clickReservationBtn(){
		reservationBtn.click();
	}

	public void verifyReservationMenuOpen(){
		UtilityMethods.waitForVisibility(reservationMenuText,2);
		Assert.assertTrue(reservationMenuText.isDisplayed());
	}

	public void setFields(String value, String field){
		String locator = "//*[contains(@placeholder,'" + field + "')]";
		WebElement fieldWE = driver.findElement(By.xpath(locator));
		UtilityMethods.waitClickability(By.xpath(locator),2);
		fieldWE.sendKeys(value);
	}

	public void setDate(String date){
		if (date.equals("Today")) {
			clickDate();

			UtilityMethods.waitClickability(todayBtn,2);
			todayBtn.click();
		}
	}

	public void setTime(String time){
		UtilityMethods.waitClickability(timeBtn,2);
		timeBtn.click();

		String locator = "//*[text()='"+time+"']";
		WebElement timeWE = driver.findElement(By.xpath(locator));
		UtilityMethods.waitClickability(By.xpath(locator),2);
		timeWE.click();
	}

	public void setPeople(int people){
		for (int i = 1; i < people-1; i++) {
			plusBtn.click();
		}
	}

	public void clickIAgreeBtn(){
		UtilityMethods.waitClickability(iAgreeCheckbox,2);
		iAgreeCheckbox.click();
	}

	public void clickSendBtn(){
		UtilityMethods.waitClickability(sendBtn,2);
		sendBtn.click();
	}

	public void verifyConirmationMessage(){
		String locator = "//*[text()='Thank you! Your table reservation request has been sent successfully.']";
		WebElement messageWE = driver.findElement(By.xpath(locator));
		UtilityMethods.waitForVisibility(By.xpath(locator),2);
		Assert.assertTrue(messageWE.isDisplayed());
	}

	public void verifySendBtnDisabled(){
		Assert.assertFalse(sendBtn.isEnabled());
	}

	public void verifyPreviousDateDisabled(){
		UtilityMethods.waitClickability(previousMonthBtn, 2);
		previousMonthBtn.click();

		UtilityMethods.wait(1);
		String locator = "//div[@class='ant-calendar-date']/..";
		WebElement dateWE = driver.findElement(By.xpath(locator));

		UtilityMethods.waitClickability(dateWE, 2);
		dateWE.click();
		Assert.assertFalse(dateWE.isSelected());
	}

	public void clickDate(){
		UtilityMethods.waitClickability(dateBtn,2);
		dateBtn.click();
	}





}
