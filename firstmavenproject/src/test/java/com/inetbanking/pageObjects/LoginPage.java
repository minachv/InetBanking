package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//Syntax 1
	/*@FindBy(how=How.NAME, using="uid")
	WebElement username1;*/
	
	//Syntax 2
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
	
	
	public void setUserName(String uname)
	{
		username.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		btnLogin.click();
	}
	
	public void Logout()
	{
		logout.click();
	}
}
