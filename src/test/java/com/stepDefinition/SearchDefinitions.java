package com.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.factory.BaseClass;
import com.pageObjects.*;

import io.cucumber.java.en.*;

public class SearchDefinitions extends BaseClass{
	//sWebDriver driver = BaseClass.setupDriver();
	public Logger logger=LogManager.getLogger(this.getClass());
	HomePage hp;
	CoursesPage cp;
	CourseDetailsPage cdp;
    
	@Given("user should be on courseera homepage")
	public void user_should_be_on_courseera_homepage() {
		logger.info("user should be on courseera homepage");
		takeScreenshot("HomePage");	
	    
	}

	@When("user search for {string} courses")
	public void user_search_for_courses(String string) {
		logger.info("user should be on courseera homepage");
		hp=new HomePage(driver);
		hp.submitSearch(string);
		takeScreenshot("SearchQuery");
		hp.clickSearchIcon();
	}
	
	
	@When("user select English language")
	public void user_select_english_language() {
		logger.info("user should be on courseera homepage");
		cp=new CoursesPage(driver);
		cp.selectLanguage();
		takeScreenshot("SelectLanguage");
	   
	}
	@When("user select beginners level")
	public void user_select_beginners_level() {
		logger.info("user should be on courseera homepage");
		cp.selectLevel();
		takeScreenshot("SelectLevel");  
	}

	@Then("user should click on top two courses")
	public void user_should_click_on_top_two_courses() {
		logger.info("user should be on courseera homepage");
		cp.selectCourse();
		
	}


}