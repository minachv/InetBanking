package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCutomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomer_004 extends BaseClass {

	@Test
	public void deleteCustomer() {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.ClickSubmit();
		logger.info("Logged in successfully");
		
		DeleteCutomer dc=new DeleteCutomer(driver);
		
		dc.clickDeleteCustomer();
		dc.enterCustomerID("40438");
		dc.clickSubmit();
		
		
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	}
}
