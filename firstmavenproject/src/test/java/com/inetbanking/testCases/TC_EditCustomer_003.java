package com.inetbanking.testCases;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomer;
import com.inetbanking.pageObjects.LoginPage;


public class TC_EditCustomer_003 extends BaseClass
{
	
	@Test
	public void editCustomer() throws IOException, AWTException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.ClickSubmit();
		logger.info("Logged in successfully");
		
		EditCustomer ec=new EditCustomer(driver);
		
		
		ec.clickEditCustomer();
		logger.info("Clicked in Edit Customer");
			
		ec.enterCustomerID("125645");
		logger.info("Entered CustomerID");
		
		ec.clickSubmit();
		logger.info("Clicked on Submit");
		
		
		if(isAlertPresent()==true)
		{
			//capturescreenshot(driver, "editCustomer");
			
			
			// create object to robot class
			Robot robot = new Robot();
			// create rectangle for full screenshot
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			// capture screen of the desktop
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			// save the screenshot to local system
			ImageIO.write(screenFullImage, "png", new File(".\\ScreenShots\\editCustomer.png"));
			
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept(); //Close alert when username/password wrong @login page
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Wrong Cutomer ID shared!");
		}
		
		logger.info("Editing customer details ................");
		
		
		ec.custAddress("Hinjewadi");
		//ec.custCity("pune");
		//ec.custState("maharashtra");
		//ec.custPIN("145237");
		//ec.custMobileNumber("1335649878");

		//String email = randomestring() + "@gmail.com";
		//ec.custEmail(email);
		ec.clickSubmitAgain();
		logger.info("Submitted customer details ................");
		
		boolean res = driver.getPageSource().contains("Customer details updated Successfully!!!");
		
				//System.out.println(res);

		if (res == true) 
		{
			Assert.assertTrue(true);
			logger.info("Customer details updated Successfully!!!...........");
					
		} 
		else 
		{
			//capturescreenshot(driver, "editCustomer");
			Assert.assertTrue(false);
			logger.info("TCs Failed...........");
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;	
		}
		
			
	}
	
}
