package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomer;

public class TC_AddNewCustomer_002 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.ClickSubmit();
		logger.info("Logged in successfully");

		NewCustomer nc = new NewCustomer(driver);

		Thread.sleep(3000);

		nc.ClickAddNewCustomer();
		logger.info("Clicked on New Customer");
		nc.custName("vardhaman");
		nc.custGender("male");
		nc.custDob("04", "24", "1987");
		nc.custAddress("Talwade");
		nc.custCity("pune");
		nc.custState("maharashtra");
		nc.custPIN("145237");
		nc.custMobileNumber("1335649878");

		String email = randomestring() + "@gmail.com";
		nc.custEmail(email);
		nc.custPassword("14164");

		logger.info("Entered required customer details");
		nc.clickSubmit();
		logger.info("Submitted customer information");

		logger.info("Validation Started...........");

		// Thread.sleep(40000);
		// driver.switchTo().alert().accept();

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		//System.out.println(res);

		if (res == true) 
		{
			Assert.assertTrue(true);
			logger.info("TCs passed...........");
			
		} 
		else 
		{
			capturescreenshot(driver, "AddNewCustomer");
			Assert.assertTrue(false);
			logger.info("TCs Failed...........");
		}

	}

}
