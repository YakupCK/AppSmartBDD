package com.appsmartbdd.pages;

import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
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

	@FindBy(css = "input[value='PAYPAL']")
	private WebElement paypalBtn;

	@FindBy(css = "button#createAccount")
	private WebElement paypalBtn2;

	@FindBy(xpath = "//span[text()='Kreditkarte']/..")
	private WebElement kreditKarteBtn;

	@FindBy(id = "cardNumber")
	private WebElement cardNumberPaypal;

	@FindBy(id = "cardExpiry")
	private WebElement cardExpiryPaypal;

	@FindBy(id = "cardCvv")
	private WebElement cvvPaypal;

	@FindBy(id = "phone")
	private WebElement phonePaypal;

	@FindBy(xpath = "//label[text()='Nein danke.']")
	private WebElement neinDankeBtn;

	@FindBy(xpath = "//button[text()='Weiter']")
	private WebElement weiterContinueBtn;

	@FindBy(css = "input#code")
	private WebElement smsInputField;

	@FindBy(css = "input[value='Confirm']")
	private WebElement smsConfirmBtn;


	public void enterVisaCardInfo() {
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
		UtilityMethods.scrollToElement(paypalBtn2);
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

	public void clickPaypalAndProceed(){
		UtilityMethods.waitClickability(paypalBtn, 2);
		paypalBtn.click();

		UtilityMethods.waitClickability(proceedBtn,2);
		proceedBtn.click();
	}

	public void verifySandboxPage(){
		UtilityMethods.wait(1);
		UtilityMethods.waitForURLContains("https://sandbox.crefopay.de/",20);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://sandbox.crefopay.de/"));
	}

	public void enterPayPalInfo(){
		//select paypal option
		UtilityMethods.waitClickability(paypalBtn2, 3);
		paypalBtn2.click();

		//select kredit card
		UtilityMethods.wait(1);
		UtilityMethods.waitClickability(kreditKarteBtn, 3);
		UtilityMethods.clickWithJSExe(kreditKarteBtn);

		//set card number
		UtilityMethods.waitClickability(cardNumberPaypal, 3);
		cardNumberPaypal.sendKeys(PropertyReader.getProperty("paypalCardNumber"));

		//set exp date
		UtilityMethods.waitClickability(cardExpiryPaypal, 3);
		cardExpiryPaypal.sendKeys(PropertyReader.getProperty("paypalExpDate"));

		//set cvv
		UtilityMethods.waitClickability(cvvPaypal, 3);
		cvvPaypal.sendKeys(PropertyReader.getProperty("paypalCvv"));

		//set phone
		UtilityMethods.scrollToElement(phonePaypal);
		UtilityMethods.waitClickability(phonePaypal, 3);
		phonePaypal.sendKeys(PropertyReader.getProperty("paypalPhoneNumber"));

		//click nein danke
		UtilityMethods.waitClickability(neinDankeBtn, 3);
		neinDankeBtn.click();

		//click continue btn
		UtilityMethods.waitClickability(weiterContinueBtn, 3);
		weiterContinueBtn.click();
	}

	public void enterSMScode(){
		UtilityMethods.waitClickability(smsInputField, 2);
		smsInputField.sendKeys("1234");

		UtilityMethods.waitClickability(smsConfirmBtn, 2);
		smsConfirmBtn.click();
	}



}
