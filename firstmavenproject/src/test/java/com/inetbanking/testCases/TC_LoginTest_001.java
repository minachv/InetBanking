package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		logger.info("url opned");
		
		LoginPage lpg=new LoginPage(driver);
		lpg.setUserName(username);
		logger.info("Entered Username");
		
		lpg.setPassword(password);
		logger.info("Entered Password");
		
		lpg.ClickSubmit();
		logger.info("Clicked Submit");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Logged in Successfully");
		}
		else
		{
			capturescreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Log in Failed");
		}	
			
				
	}
	

}
