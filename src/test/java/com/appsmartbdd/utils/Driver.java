package com.appsmartbdd.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	private Driver() {};

	private static WebDriver driver;

	//returns regular driver object
	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = PropertyReader.getProperty("browser");
			switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "safari":
					WebDriverManager.getInstance(SafariDriver.class).setup();
					driver = new SafariDriver();
					break;
			}
		}
		return driver;
	}

	//just for the scenarios requiring different chrome profile
	public static WebDriver getDriverChromeProfile() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:/Users/yakup/AppData/Local/Google/Chrome/User Data");
			options.addArguments("--profile-directory=Profile 3");
			options.addArguments("--disable-notifications");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	//quit and null the driver
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}


}