package com.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.factory.BaseClass;
import com.pageObjects.Form;
import com.pageObjects.HomePage;

import io.cucumber.java.en.*;

public class formSteps extends BaseClass{
	public Logger logger=LogManager.getLogger(this.getClass());
	HomePage hp;
	//WebDriver driver=BaseClass.setupDriver();
	public Form f=new Form(driver);
	@Given("user should be on For Enterprise page")
	public void user_should_be_on_for_enterprise_page() {
		logger.info("user should be on For Enterprise page");
		//driver.get("https://www.coursera.org/business");
		hp=new HomePage(driver);
		hp.clickNav2();
		takeScreenshot("EnterPrisePage");
	   
	}

	@When("user clicks on solution dropdown")
	public void user_clicks_on_solution_dropdown() {
		logger.info("user clicks on solution dropdown");
		hp.clickSolutions();
		takeScreenshot("Solutions Option");
	    
	}

	@When("user click on For Campus option")
	public void user_click_on_for_campus_option() {
		logger.info("user click on For Campus option");
		hp.clickForCampus();
		takeScreenshot("ForCampusPage");
	   
	}

	@Given("user should scroll down to the form")
	public void user_should_scroll_down_to_the_form() {
		logger.info("user should scroll down to the form");
		f.scrolltoForm();
		takeScreenshot("form");
	   
	}

	@When("user fills the form with {string},{string},{string},{string},{string},{string},{string}")
	public void user_fills_the_form(String fname,String lname,String email,String phone,String iname,String needs,String status) {
		logger.info("user fills the form with {string},{string},{string},{string},{string},{string},{string}");
		f.setFirstName(fname);
		f.setLastName(lname);
		f.setEmail(email);
		f.setPhone(phone);
		f.setInstType();
		f.setInstName(iname);
		takeScreenshot(status+"FormData1");
		f.setJobRole();
		f.setDepartment();
		f.setDescription();
		f.setNeeds(needs);
		f.setLearners();
		f.setCountry();
		f.setState();
		f.clickChkBox();
		takeScreenshot(status+"FormData2");
		
	}

	@When("user submits the form")
	public void user_submits_the_form() {
		logger.info("user submits the form");
		f.clickSubmit();  
	}

	@Then("user captures {string} message")
	public void user_captures_the_message(String str) {
		logger.info("user captures {string} message");
		System.out.print("Message after submiting "+str+" data:-");
		String s=f.getMsg();
		takeScreenshot(str+"Message");
		System.out.print(s);
		
	    
	}
	
//	@Then("user should close the browser")
//	public void user_should_close_the_browser() {
//		//driver.quit();
//	}
	
	
	

}
