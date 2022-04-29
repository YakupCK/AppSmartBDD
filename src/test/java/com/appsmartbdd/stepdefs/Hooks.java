package com.appsmartbdd.stepdefs;

import com.appsmartbdd.utils.Driver;
import com.appsmartbdd.utils.PropertyReader;
import com.google.gson.Gson;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    private static Response response;
    private static RequestSpecification request;
    private JsonPath jsonPath;
    private Gson gson;

    @Before()
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyReader.getProperty("implicitWait")), TimeUnit.SECONDS);
    }


    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.quitDriver();
    }



}
