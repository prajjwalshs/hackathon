package com.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage extends BasePage {

	public CoursesPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h1[@class='cds-119 cds-Typography-base css-1xy8ceb cds-121']")
	WebElement heading;
	
	@FindBy(xpath="(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[1]")
	WebElement rate;
	
	@FindBy(xpath="(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[3]")
	WebElement time;
	
	@FindBy(xpath="//span[contains(text(),'Beginner')]")
	WebElement level;
	
	@FindBy(xpath="//*[@data-testid='search-filter-group-Language']//span[contains(text(),'Show more')]")
	WebElement showmore;
	
	@FindBy(xpath="//*[@data-testid='active-filter-items']/following-sibling::ul/li[1]")
	WebElement firstCourse;
	
	@FindBy(xpath="//*[@data-testid='active-filter-items']/following-sibling::ul/li[2]")
	WebElement secondCourse;
	
	@FindBy(xpath="//div[@data-e2e='NumberOfResultsSection']/span")
	WebElement result;
	
	By allLanguages=By.xpath("//div[starts-with(@id, 'checkbox-group')]/div");
	By allLevels=By.xpath("//*[@data-testid='search-filter-group-Level']//label[@class='cds-checkboxAndRadio-label']");
	
	@FindBy(xpath = "//div[starts-with(@id, 'checkbox-group')]/div/label/div/span/span")
	WebElement language;
	
	@FindBy(xpath = "//a[@id='cds-react-aria-182-product-card-title']")
	WebElement firstlink;
	
	@FindBy(xpath ="//a[@id='cds-react-aria-184-product-card-title']")
	WebElement secondlink;
	
	@FindBy(xpath="//div[starts-with(@class,'css-1hllf5q')]/button[1]")
	WebElement applyBtn;
	
	@FindBy(xpath="//div[@class='css-jyd7rb']//span[contains(text(),'Close')]")
	WebElement closeBtn;
		
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	public void selectLevel() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", level);
		
	}
	public void selectLanguage() {
		showmore.click();
		language.click();
		applyBtn.click();
	}
	
	public void selectCourse(){
		scroll(firstCourse);
		hover(firstCourse);
		firstCourse.click();
		scroll(secondCourse);
		hover(secondCourse);
		secondCourse.click();
	}
	
	public void detailscourses()
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    String head =heading.getText();
	    String rating =rate.getText();
	    String t = time.getText();
	    
	    System.out.println(head+"  "+rating+"  "+t);
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	}
	
	
	public List<String> getAllLanguage() {
		
		WebElement showmore =driver.findElement(By.xpath("(//span[@class='cds-button-label'])[11]"));
		showmore.click();
		List<WebElement>languages=driver.findElements(allLanguages);
		List<String>arr=new ArrayList<>();
		for(WebElement ele:languages)
		{
			arr.add(ele.getText());
		}
		
		closeBtn.click();
		return arr;
	}
	
	public List<String>getAllLevels(){
		List<WebElement>levels=driver.findElements(allLevels);
		List<String>arr=new ArrayList<>();
		for(WebElement ele:levels)
		{
			arr.add(ele.getText());
		}
		return arr;
		
	}
	public void clicksecond() {
		WebElement element = driver.findElement(By.xpath("//*[@data-testid='active-filter-items']/following-sibling::ul/li[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); element.click();
	}
	public void clickfirst() {
		WebElement element = driver.findElement(By.xpath("//*[@data-testid='active-filter-items']/following-sibling::ul/li[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); element.click();
	}
	
	public void clickShowMore() {
		showmore.click();
	}
	
	public boolean checkChkBox() {
		return level.isSelected();
	}
	
	public boolean checkResults() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-e2e='NumberOfResultsSection']/span")));
		String s=result.getText();
		if(s.contains("No results"))
		{
			return false;
		}
		return true;
		
	}
}
