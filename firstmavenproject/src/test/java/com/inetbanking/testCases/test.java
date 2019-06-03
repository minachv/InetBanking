package com.inetbanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test 
{
	WebDriver driver;
	
	@Test
	public void test1()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\A643194\\Documents\\Vardhaman-BackUp\\Selenium Training\\eclipse-workspace\\firstmavenproject\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
		
		driver.findElement(By.name("uid")).sendKeys("mngr196563");
		driver.findElement(By.name("password")).sendKeys("YqezAve");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.linkText("New Customer")).click();
		
		driver.findElement(By.name("name")).sendKeys("abcd");
		driver.findElement(By.xpath("input[contains(@value,'m')]")).click();
		
	}

}
