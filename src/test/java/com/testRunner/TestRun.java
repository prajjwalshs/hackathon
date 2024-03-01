package com.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".\\src\\test\\resources\\FeatureFiles\\esmoke.feature",
							".\\src\\test\\resources\\FeatureFiles\\Regression.feature",
							".\\src\\test\\resources\\FeatureFiles\\sEnd2End.feature"
							},
				//features={"@target/rerun.txt"}
				glue = "com.stepDefinition", 
				plugin = 	{ "pretty",
							"html:reports/myreport.html", "rerun:target/rerun.txt",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"rerun:target/rerun.txt"}, 
				dryRun = false, 
				monochrome = true, 
				publish = true)


public class TestRun{

}
