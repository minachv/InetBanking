package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer 
{
	WebDriver ldriver;
	public NewCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "New Customer")
	WebElement lnkNewCustomer;
	
	@FindBy(name = "name")
	WebElement txtcustomername;
	
	@FindBy(name="rad1")
	WebElement rdgender;
	
	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtadd;
	

	@FindBy(name="city")
	WebElement txtcity;
	

	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpin;
	
	@FindBy(name="telephoneno")
	WebElement txtmobileno;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement btnsub;
	
	public void ClickAddNewCustomer()
	{
		lnkNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtcustomername.sendKeys(cname);
	}
	
	public void custGender(String gender)
	{
		rdgender.click();
	}
	
	public void custDob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custAddress(String addr)
	{
		txtadd.sendKeys(addr);
	}
	
	public void custCity(String city)
	{
		txtcity.sendKeys(city);
	}
	public void custState(String state)
	{
		txtstate.sendKeys(state);
	}
	public void custPIN(String pin)
	{
		txtpin.sendKeys(pin);
	}
	public void custMobileNumber(String mobno)
	{
		txtmobileno.sendKeys(mobno);
	}
	public void custEmail(String email)
	{
		txtemailid.sendKeys(email);
	}
	public void custPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnsub.click();
	}
	
}

