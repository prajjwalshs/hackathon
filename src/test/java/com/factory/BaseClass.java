package com.factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pageObjects.CourseDetailsPage;
import com.pageObjects.CoursesPage;
import com.pageObjects.HomePage;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public  HomePage hp;
	public  CoursesPage cp;
	public  CourseDetailsPage cdp;
	public static  WebDriver setupDriver() {
		
		
		
		String browser=getProperties().getProperty("browser");
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			 }
			
			
			if(browser.equals("Chrome"))
				capabilities.setBrowserName("chrome");
				
			else if(browser.equals("Edge"))
				capabilities.setBrowserName("MicrodoftEdge");
			else
				System.out.println("No matching Browser...");
			
			 try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			} catch (MalformedURLException e) {}
				
			
		}
			
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	driver=new EdgeDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.manage().window().maximize();
	 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	 
	 return driver;
	}

	private static Properties getProperties() {
		 
		FileReader file;
		try {
			file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");	
			p=new Properties();
			p.load(file);
			return p;
	}
		catch (IOException e) {
		
		}
		return p;
}
	
	
	public void takeScreenshot(String name) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"//screenshots//"+name+".png");
	try {
		FileUtils.copyFile(src, target);
	} catch (IOException e) {}
		
	}
}
