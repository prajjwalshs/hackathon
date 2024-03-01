package com.stepDefinition;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.BaseClass;

import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	@BeforeAll
	public static void setup() {
		driver=BaseClass.setupDriver();
		driver.get("https://www.coursera.org");
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//this is for cucumber junit report
//			System.out.println(scenario.getName());
//			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
	}
}
