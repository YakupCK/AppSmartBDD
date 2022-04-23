package com.appsmartbdd.pages;

import com.appsmartbdd.stepdefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	protected WebDriver driver;

	//to initialize @FindBy annotations with PageFactory class
	BasePage() {
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}






}
