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






}
