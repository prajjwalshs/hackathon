package com.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.factory.BaseClass;
import com.pageObjects.CourseDetailsPage;
import com.pageObjects.CoursesPage;
import com.pageObjects.HomePage;

import io.cucumber.java.en.*;
import utilities.ExcelUtils;

public class DetailsSteps extends BaseClass {
	public Logger logger=LogManager.getLogger(this.getClass());
	
	String courseName;
	String courseRating;
	String courseDuration;
	ExcelUtils eu=new ExcelUtils();
	
	List<String> arr1=new ArrayList<>();
	List<String> arr2=new ArrayList<>();
	

	@Given("user should be on first course page")
	public void user_should_be_on_first_course_page() {
		logger.info("user should be on first course page");
		cdp=new CourseDetailsPage(driver);
		cdp.switchToWindow(1);
	}

	@When("user capture the first course details")
	public void user_capture_the_first_course_details() {
		logger.info("user capture the first course details");
		courseName=cdp.getCourseName();
		courseRating=cdp.getCourseRatings();
		courseDuration=cdp.getCourseDuration();
		arr1.add(courseName);
		arr1.add(courseRating);
		arr1.add(courseDuration);
		try {
			ExcelUtils.setCellData("courseDetails","courses", 1, arr1);
		} catch (IOException e) {}
		takeScreenshot("Course1");
	}

	@Then("display the first course details")
	public void display_the_first_course_details() {
		logger.info("display the first course details");
		System.out.println(courseName);
		System.out.println(courseRating);
		System.out.println(courseDuration);	
		 
	}

	@Given("user should be on second course page")
	public void user_should_be_on_second_course_page() {
		logger.info("user should be on second course page");
		cdp.switchToWindow(2);
	    
	}

	@When("user capture the second course details")
	public void user_capture_the_second_course_details() {
		logger.info("user capture the second course details");
		courseName=cdp.getCourseName();
		courseRating=cdp.getCourseRatings();
		courseDuration=cdp.getCourseDuration();
		arr2.add(courseName);
		arr2.add(courseRating);
		arr2.add(courseDuration);
		takeScreenshot("Course2");
	}

	@Then("display the second course details")
	public void display_the_secind_course_details() {
		logger.info("display the second course details");
		System.out.println(courseName);
		System.out.println(courseRating);
		System.out.println(courseDuration);
		try {
			ExcelUtils.setCellData("courseDetails","courses", 2, arr2);
		} catch (IOException e) {}
			
		
	}

}
