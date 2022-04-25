package com.appsmartbdd.pages;

import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SandBoxPage extends BasePage {

	@FindBy(xpath = "//*[text()='Kreditkartennummer']/..//input")
	private WebElement cardNumberField;

	@FindBy(xpath = "//*[contains(text(),'Karteninhaber ')]/..//input")
	private WebElement cardHolderField;

	@FindBy(xpath = "(//*[text()='MM'])[2]")
	private WebElement monthDropdown;

	@FindBy(xpath = "(//*[text()='YYYY'])[2]")
	private WebElement yearDropdown;

	@FindBy(xpath = "//*[text()='Kartenprüfnummer']/..//input")
	private WebElement cvv;

	@FindBy(css = "input[name='select-payment-method-continue-button']")
	private WebElement proceedBtn;

	@FindBy(css = "a[class='delete']")
	private WebElement removeExistingCardInfo;

	@FindBy(css = "input[value='Kreditkarte hinzufügen']")
	private WebElement addNewCard;


	public void enterCardInfo() {
		removeExistingCard();
		setCardNumberField();
		setCardHolderField();
		setCardMonth();
		setCardYear();
		setCardCVV();
		proceedBtn.click();
	}


	public void setCardNumberField() {
		String cardNumber = PropertyReader.getProperty("cardNumber");
		cardNumberField.sendKeys(cardNumber);
	}

	public void setCardHolderField() {
		String cardHolder = PropertyReader.getProperty("cardHolder");
		cardHolderField.sendKeys(cardHolder);
	}

	public void setCardMonth() {
		String expDateMonth = PropertyReader.getProperty("expDateMonth");
		monthDropdown.click();
		driver.findElement(By.xpath("//div[@class='select-items']//div[text()='" + expDateMonth + "']")).click();
	}

	public void setCardYear() {
		String expDateYear = PropertyReader.getProperty("expDateYear");
		yearDropdown.click();
		driver.findElement(By.xpath("//div[@class='select-items']//div[text()='" + expDateYear + "']")).click();
	}

	public void setCardCVV() {
		String cvvNumber = PropertyReader.getProperty("cvv");
		cvv.sendKeys(cvvNumber);
	}

	public void removeExistingCard() {
		try {
			UtilityMethods.waitForVisibility(removeExistingCardInfo, 2);
			if (removeExistingCardInfo.isDisplayed()) {
				removeExistingCardInfo.click();

				UtilityMethods.wait(1);
				UtilityMethods.waitForVisibility(addNewCard, 2);
				addNewCard.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
