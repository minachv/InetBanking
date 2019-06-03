package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer 
{
	WebDriver ldriver;
	public EditCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Edit Customer")
	WebElement lnkeditCustomer;
	
	@FindBy(name = "cusid")
	WebElement txtCustomerid;

	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;
	
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
	
	@FindBy(name="sub")
	WebElement btnsub;

	public void clickEditCustomer()
	{
		lnkeditCustomer.click();
	}
	
	public void enterCustomerID(String id)
	{
		txtCustomerid.sendKeys(id);
	}

	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void custAddress(String addr)
	{
			
		txtadd.clear();
		txtadd.sendKeys(addr);
	}
	
	public void custCity(String city)
	{
		txtcity.click();
		txtcity.sendKeys(city);
	}
	public void custState(String state)
	{
		txtstate.clear();
		txtstate.sendKeys(state);
	}
	public void custPIN(String pin)
	{
		txtpin.clear();
		txtpin.sendKeys(pin);
	}
	public void custMobileNumber(String mobno)
	{
		txtmobileno.clear();
		txtmobileno.sendKeys(mobno);
	}
	public void custEmail(String email)
	{
		txtemailid.clear();
		txtemailid.sendKeys(email);
	}
	public void clickSubmitAgain()
	{
		btnsub.click();
	}
	
	
	
}
