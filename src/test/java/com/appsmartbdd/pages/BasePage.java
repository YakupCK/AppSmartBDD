package com.appsmartbdd.pages;

import com.appsmartbdd.stepdefs.Hooks;
import com.appsmartbdd.utils.PropertyReader;
import com.appsmartbdd.utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

	protected WebDriver driver;

	//to initialize @FindBy annotations with PageFactory class
	BasePage() {
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}

	//--See all your saved items btn --
	@FindBy(linkText = "See all your saved items ›")
	private WebElement seeAllSavedItems;

	//--log out btn --
	@FindBy(id = "logout-button")
	private WebElement logOutBtn;

	//--account btn--
	@FindBy(css = "span.plButton-label.v-ellipsis")
	private WebElement accountBtn;

	//--sign in btn after clicking account menu--
	@FindBy(linkText = "Sign In")
	private WebElement signInBtn;


	//*****************************************


	//navigate through menu options
	public void navigateToMenuOptions(List<String> modules){
		for (int i = 0; i < modules.size(); i++) {
			String locator = "//*[text()='" + modules.get(i) + "']";
			UtilityMethods.waitClickability(By.xpath(locator),5);
			WebElement menu = driver.findElement(By.xpath("//*[text()='" + modules.get(i) + "']"));
			menu.click();
		}
	}

	//navigate through dropdown menus at the right top of the page
	public void navigateToRightTopMenus(String menuName) {
		String locator = "//button//*[text()='" + menuName + "']";
		UtilityMethods.waitClickability(By.xpath(locator), 5);
		WebElement menu = driver.findElement(By.xpath(locator));
		menu.click();
	}

	//go to all saved items
	public void goToAllSavedItems(){
		UtilityMethods.waitClickability(seeAllSavedItems, 3);
		seeAllSavedItems.click();
	}

	//go to sign in page
	public void goToSignInPage() {
		navigateToRightTopMenus("Account");
		UtilityMethods.waitClickability(signInBtn,5);
		signInBtn.click();
	}

	//verify if login is successful
	public void verifyLogin(){
		UtilityMethods.waitForVisibility(accountBtn,7);
		Assert.assertTrue(accountBtn.getText().toLowerCase().contains(PropertyReader.getProperty("username").toLowerCase()));
	}

	//log out
	public void logOut(){
		UtilityMethods.waitClickability(accountBtn,4);
		accountBtn.click();
		UtilityMethods.waitClickability(logOutBtn, 3);
		logOutBtn.click();
		UtilityMethods.waitForText(accountBtn,"Account");
	}

}
