package com.sample.firstmavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	
	public static WebDriver driver=null;
	
	@BeforeClass
	public void testSetUp() 
	{
		// Set Browser Property
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\A643194\\Documents\\Selenium Training\\Selenium Repository\\Drivers\\chromedriver_win32\\chromedriver.exe");

		// Initialize browser
				driver=new ChromeDriver();
	}
		
	@Test
	public void getPageTitle() 
	{
		
		// Open Google
		driver.get("http://google.com");

		// Maximize browser
		driver.manage().window().maximize();
		
		//getTitle
		String appTitle = driver.getTitle();
		System.out.println("Application title is :: "+appTitle);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
