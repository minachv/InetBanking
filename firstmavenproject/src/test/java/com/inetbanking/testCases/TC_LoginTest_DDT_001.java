package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTest_DDT_001 extends BaseClass 
{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.ClickSubmit();
		               
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //Close alert when username/password wrong @login page
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else 
		{
			Assert.assertTrue(true);
			lp.Logout();
			logger.info("Login Passed");
			driver.switchTo().alert().accept(); //Close the alert after clicking log out link.
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

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int cellnum=XLUtils.getCellCount(path, "sheet1", rownum);
		
		String loginData[][]=new String [rownum][cellnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
