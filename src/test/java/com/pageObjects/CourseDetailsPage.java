package com.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseDetailsPage extends BasePage{
	
	public CourseDetailsPage(WebDriver driver)  {
		
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='css-1psltl0']//h1")
	WebElement courseName;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement ratings;
	
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement duration;
	
	
	
	public void switchToWindow(int i) {
		super.getWindows();
		driver.switchTo().window(winIds.get(i));
	}
	
	public String getCourseName() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		String s=courseName.getText();
		
		return s;
	}
	
	public String getCourseRatings() {
		return ratings.getText();
	}
	
	public String getCourseDuration() {
		return duration.getText();
	}
}
