package com.supermarket.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class HomePage extends LoginPages{
	LoginPages Lpobj;
	ExcelUtility exobj = new ExcelUtility();
	GeneralUtilities  guobj1 = new GeneralUtilities();
	
	public HomePage(WebDriver driver) 
	{
    super(driver);
	}
	
	public void navigateToHomePage() throws IOException
	{
	Lpobj= new LoginPages(driver);
	Lpobj.clearDetails();
	Lpobj.login(exobj.readStringData(1,0),exobj.readStringData(1,1));
	Assert.assertTrue(Lpobj.isDisplayedValue());
	}
	 
	@FindBy(xpath="//li[@class='breadcrumb-item']/a")
	WebElement home;
	
	public void navigateBack() 
	{
	home.click();
		
	}
	
	public String getpageTitle()
	{
    String title = driver.getTitle();
	return title;
	}
	
	
	
	
	
}
