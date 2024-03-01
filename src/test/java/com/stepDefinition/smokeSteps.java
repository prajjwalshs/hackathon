package com.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.factory.BaseClass;
import com.pageObjects.CoursesPage;
import com.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class smokeSteps extends BaseClass {
	HomePage hp;
	CoursesPage cp;
	public Logger logger=LogManager.getLogger(this.getClass());

	@Given("user should launch the browser")
	public void user_should_launch_the_browser() {
		
		logger.info("user should launch the browser");
		cp = new CoursesPage(driver);
		String s = driver.toString();
		boolean flag = false;
		if (s != "")
			flag = true;

		Assert.assertEquals(flag, true);

	}

	@When("user navigates to url")
	public void user_navigates_to_url() {
		logger.info("user navigates to url");
		driver.get("https://www.coursera.org/");
	}

	@Then("Web page should load")
	public void web_page_should_load() {
		logger.info("Web page should load");
		hp = new HomePage(driver);
		boolean flag = hp.pageLoaded();
		Assert.assertEquals(flag, true);
	}

	@Then("search box should displayed")
	public void search_box_should_displayed() {
		logger.info("search box should displayed");
		hp = new HomePage(driver);
		boolean flag = hp.searchBoxDisplay();
		Assert.assertEquals(flag, true);
	}

	@Given("user should be on courssera homepage")
	public void user_should_be_on_courssera_homepage() {
		logger.info("user should be on courssera homepage");
		hp = new HomePage(driver);
		hp.clickNav1();
		String s = driver.getTitle();
		// Assert.assertEquals(s, "Coursera | Degrees, Certificates, & Free Online
		// Courses");
	}

	@When("user search for {string} course")
	public void user_search_for_course(String string) {
		logger.info("user search for {string} course");
		hp = new HomePage(driver);
		hp.submitSearch(string);
		hp.clickSearchIcon();
	}

	@Given("user should see all courses")
	public void user_should_see_all_courses() {
		logger.info("user should see all courses");
		cp = new CoursesPage(driver);
	Boolean f = cp.checkResults();

	}
	@Given("user should see courses")
	public void user_should_see_courses() {
		logger.info("user should see courses");
		cp = new CoursesPage(driver);
	Boolean f = cp.checkResults();

	}
	
	
	@When("user clicks on for individual link")
	public void user_clicks_on_for_individual_link() {
		logger.info("user clicks on for individual link");
		hp = new HomePage(driver);
		hp.clickNav1();
	}

	@Then("user should see courseera homepage")
	public void user_should_see_courseera_homepage() {
		logger.info("user should see courseera homepage");
		hp.clickNav1();
		String s = driver.getTitle();
		Assert.assertEquals(s, "Coursera | Degrees, Certificates, & Free Online Courses");
	}

	@When("user clicks on for bussiness link")
	public void user_clicks_on_for_buiseness_link() {
		logger.info("user clicks on for bussiness link");
		hp = new HomePage(driver);
		hp.clickNav2();
	}

	@Then("user should see bussiness page.")
	public void user_should_see_buiseness_page() {
		logger.info("user should see bussiness page.");
		String s = driver.getTitle();
		Assert.assertEquals(s, "Employee Training and Development Programs | Coursera for Business");
	}

	@When("user clicks on for universities link")
	public void user_clicks_on_for_universities_link() {
		logger.info("user clicks on for universities link");
		hp = new HomePage(driver);
		hp.clickNav3();
	}

	@Then("user should see for campus page")
	public void user_should_see_for_campus_page() {
		logger.info("user should see for campus page");
		String s = driver.getTitle();
		Assert.assertEquals(s, "Online Learning Platform for Universities | Coursera");

	}

	@Given("user should see bussiness page")
	public void user_should_see_buieness_page() {
		logger.info("user should see bussiness page");
		hp = new HomePage(driver);
		hp.clickNav2();
		String s = driver.getTitle();
		Assert.assertEquals(s, "Employee Training and Development Programs | Coursera for Business");

	}

	@When("user should see  solutions options")
	public void user_should_see_solutions_options() {
		logger.info("user should see  solutions options");
		hp = new HomePage(driver);
		boolean flag = hp.solutionDisplay();
		hp.clickSolutions();
		Assert.assertEquals(flag, true);
	}

	@Given("user should click on solution dropdown")
	public void user_should_click_on_solution_dropdown() {
		logger.info("user should click on solution dropdown");
			hp=new HomePage(driver);
			hp.clickSolutions();
			boolean flag=hp.solutionClicked(); 
			
	}

	@When("user clicks on show more link")
	public void user_clicks_on_show_more_link() {
		logger.info("user clicks on show more link");
		cp = new CoursesPage(driver);
		cp.clickShowMore();
	}

	@Then("user should see all available language options")
	public void user_should_see_all_available_language_options() {
		logger.info("user should see all available language options");
		cp = new CoursesPage(driver);
		boolean flag = cp.getAllLanguage().size() > 0;
		Assert.assertEquals(flag, true);
	}

	@When("user clicks on Beginner level")
	public void user_clicks_on_beginner_level() {
		logger.info("user clicks on Beginner level");
		cp = new CoursesPage(driver);
		cp.selectLevel();
	}

	@Then("checkbox should be selected.")
	public void checkbox_should_be_selected() {
		logger.info("checkbox should be selected.");
		boolean flag = cp.checkChkBox();
		Assert.assertEquals(true, true);

	}

	@Then("user clicks on the solution dropdown")
	public void user_clicks_on_the_solution_dropdown() {
		logger.info("user clicks on the solution dropdown");
		hp=new HomePage(driver);
	    boolean flag=hp.solutionDisplay();
	    hp.clickSolutions();
	    Assert.assertEquals(flag, true);
	}

	@When("user clicks on For Campus option")
	public void user_clicks_on_for_campus_option() {
		logger.info("user clicks on For Campus option");
		hp.clickForCampus();
	}
	
	@When("user click on second course")
	public void user_click_on_second_course()
	{
		logger.info("user click on second course");
		cp = new CoursesPage(driver);
		cp.clicksecond();
	}
	
	@When("user click on first course")
	public void user_click_on_first_course()
	{
		logger.info("user click on first course");
		cp = new CoursesPage(driver);
		cp.clickfirst();
	}
	
	@Then("user get the details")
	public void user_get_the_details()
	{
		logger.info("user get the details");
		cp = new CoursesPage(driver);
		cp.detailscourses();
	}

}
