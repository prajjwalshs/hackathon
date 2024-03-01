package com.testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {
		".\\src\\test\\resources\\FeatureFiles\\" }, glue = "com.stepDefinition", plugin = {
				"pretty", "html:reports/report.html", "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}