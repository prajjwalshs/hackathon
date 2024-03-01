package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form extends BasePage{

	public Form(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="form")
	WebElement formDiv;
	
	@FindBy(xpath="//form[@id='mktoForm_1512']")
	WebElement form;
	
	@FindBy(id="FirstName")
	WebElement firstname;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Phone")
	WebElement phone;
	
	@FindBy(id="Institution_Type__c")
	WebElement instType;
	
	@FindBy(id="Company")
	WebElement instName;
	
	@FindBy(id="Title")
	WebElement jobRole;
	
	@FindBy(id="Department")
	WebElement department;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	WebElement description;
	
	@FindBy(id="rentalField5")
	WebElement needs;
	
	@FindBy(id="Self_reported_employees_to_buy_for__c")
	WebElement learnersNo;
	
	@FindBy(id="Country")
	WebElement country;
	
	@FindBy(id="State")
	WebElement states;
	
	@FindBy(id="mktoCheckbox_87452_0")
	WebElement chkBox;
	
	@FindBy(xpath="//*[@id='mktoForm_1512']/div[50]/span/button")
	WebElement submitBtn;
	
	@FindBy(xpath="//h1[@data-testid='how_module_hero_heading']")
	WebElement successMsg;

	@FindBy(xpath="//div[@class='mktoError']")
	WebElement errorMsg;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	public void scrolltoForm() {

		scroll(form);
		
	}
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPhone(String num) {
		phone.sendKeys(num);
		
	}
	
	public void setInstType() {
		selectOption(instType);
	}
	
	public void setInstName(String instname) {
		instName.sendKeys(instname);
	}
	
	public void setJobRole() {
		selectOption(jobRole);
	}
	
	public void setDepartment() {
		try {
			
			if(department.isDisplayed())
		selectOption(department);
		}catch(NoSuchElementException E) {}
	}
	
	public void setDescription() {
		selectOption(description);
	}
	
	public void setNeeds(String details) {
		try {
			if(needs.isDisplayed())
				needs.sendKeys(details);
		}
		catch(NoSuchElementException E) {}
	}
	
	public void setLearners() {
		try {
			
			if(learnersNo.isDisplayed())
				selectOption(learnersNo);
		}catch(NoSuchElementException E) {}
		
	}
	
	public void setCountry() {
		selectOption(country);
	}
	
	public void setState() {
		try {
			if(states.isDisplayed())
				selectOption(states);
		}
		catch(NoSuchElementException e) {}
		
	}
	
	public void clickChkBox() {
		try {
			if(chkBox.isDisplayed())
				chkBox.click();
		}
		catch(NoSuchElementException e) {
		}
	}
	
	public void clickSubmit() {
		scroll(country);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		
	}
	
	public String getMsg() {
		String msg=null;
		
		try {
			Thread.sleep(5000);
			if(driver.getTitle().equals("Thank You | Coursera"))
				msg=successMsg.getText();
			else if(errorMsg.isDisplayed())
				 msg=errorMsg.getText();
			
			}
		catch(Exception e) {}
		driver.navigate().back();
		return msg;
		
	}

}
