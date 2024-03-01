package com.pageObjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;
	List<String> winIds;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void scroll(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void hover(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	}
	
	public void getWindows() {
		Set<String>windows=driver.getWindowHandles();
		winIds=new ArrayList<String>(windows);
		
		
	}
	
	public void selectOption(WebElement ele) {
	Select sel=new Select(ele);
	int range=sel.getOptions().size();
	
	sel.selectByIndex(randNumber(range-1));
	}
	
	public int randNumber(int range) {
		Random rand = new Random();
		
		int num=rand.nextInt(range)+1;
		return num;
	}

}
