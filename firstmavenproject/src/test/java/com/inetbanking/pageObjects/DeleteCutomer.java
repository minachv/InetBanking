package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCutomer 
{

	WebDriver ldriver;
	public DeleteCutomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(linkText = "Delete Customer")
	WebElement lnkdeleteCustomer;
	
	@FindBy(name = "cusid")
	WebElement txtCustomerid;
	
	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;
	
	public void clickDeleteCustomer()
	{
		lnkdeleteCustomer.click();
	}
	
	public void enterCustomerID(String id)
	{
		txtCustomerid.sendKeys(id);
	}

	public void clickSubmit()
	{
		btnSubmit.click();
		
	}
	
}
