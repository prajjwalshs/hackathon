package com.stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.BaseClass;
import com.pageObjects.*;

import io.cucumber.java.en.*;
import utilities.ExcelUtils;


public class languageSteps extends BaseClass {
	public Logger logger=LogManager.getLogger(this.getClass());
	List<String> arr;
	List<String> arr2;
	
		@Given("user should be on homepage")
		public void user_should_be_on_homepage() {
			logger.info("user should be on homepage");
			hp=new HomePage(driver);
			hp.clickNav1();
		}

		@When("User look for {string}")
		public void user_look_for(String string) {
			logger.info("User look for {string}");
			hp.submitSearch(string);
			hp.clickSearchIcon();  
		}

		@When("user extract all languages")
		public void user_extract_all_languages() {
			logger.info("user extract all languages");
			cp=new CoursesPage(driver);
			arr=cp.getAllLanguage();
			ExcelUtils.setCellData("courseDetails", "languages",arr);
			
		}

		@When("user extract all levels")
		public void user_extract_all_levels() {	
			logger.info("user extract all levels");
			arr2 = cp.getAllLevels(); 
			ExcelUtils.setCellData("courseDetails", "levels",arr2);
		}

		@Then("user display langauge and level information")
		public void user_display_langauge_and_level_information() {
			logger.info("user display langauge and level information");
			for(String s:arr) {
				System.out.println(s.substring(0, s.indexOf("user display langauge and level information")));
			}
			for(String s:arr2) {
				System.out.println(s);
			}
		   
		}

}
