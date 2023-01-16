package com.supermarket.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;


public class ManageProductsPages {
	
	WebDriver driver;
	GeneralUtilities  guobj1 = new GeneralUtilities();
	WaitUtility wait = new WaitUtility();
	Constants constants = new Constants();
	
	

	public  ManageProductsPages(WebDriver driver) 
	{                 //constructor
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath="//li[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement error;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
    WebElement MPMoreinfo;
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement ListProducts;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[text()=\"Yes\"]")
	WebElement MPStockYes;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[@class='badge bg-warning']")
	WebElement MPStockNo;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[text()=\"Limited\"]")
	WebElement MPStocklimited;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[@class='badge bg-danger']")
	WebElement MPStockUnlimited;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement MPDelete;
	

	
	public boolean isDisplayedValue( ) 
	{
	boolean Display =dashboard.isDisplayed();
	return Display;
	}
	
	
	public boolean isDisplayed1() 
	{
	boolean value=guobj1.isDisplayedCommand(ListProducts);
	return value;
	}
	 
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[9]//i[@class='fas fa-edit']")
	WebElement MPEdit;
	//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[9]//i[@class='fas fa-trash-alt']
	@FindBy(xpath="//input[@class='form-control']")
	WebElement Titleinput;
	@FindBy(xpath="//button[@type='submit']")
	WebElement EditSubmit;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement editedCell;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement succesfullyUpdated;
	
	public void clickEdit() throws AWTException
	{
	MPEdit.click();
	Titleinput.clear();
	Titleinput.sendKeys("Non-Veg Puffs");
	guobj1.enterKey();
	Assert.assertTrue(succesfullyUpdated.isDisplayed(),"Test Passed for Product edit button");	
	}
	
	
	public boolean isEnabled()
	{
	boolean value= MPStockYes.isEnabled();
	return value;
	}
	
	public boolean isEnabledstockStaus()
	{
	boolean value= MPStockUnlimited.isEnabled();
	return value;
	}
	
	public void stock() throws InterruptedException
	{
	if(MPStockYes.isDisplayed()) 
	{
	MPStockYes.click();	
	Thread.sleep(5000);
	MPStockNo.click();
	Assert.assertEquals(MPStockYes.getText(), "Yes");
	}
	else if(MPStockNo.isDisplayed())
	{
	MPStockNo.click();
	MPStockYes.click();	
	Assert.assertEquals(MPStockNo.getText(), "No");
	}}
	
	public void stockstatus() throws InterruptedException
	{
	if(MPStockUnlimited.isDisplayed()) 
	{
	MPStockUnlimited.click();
	wait.eWToBeClickableCommand(driver, MPStocklimited);
	MPStocklimited.click();
	Assert.assertEquals(MPStockUnlimited.getText(), "Unlimited");
	}
	else if(MPStocklimited.isDisplayed()) 
	{
	MPStocklimited.click();
	wait.eWToBeClickableCommand(driver, MPStockUnlimited);
	MPStockUnlimited.click();
	Assert.assertEquals(MPStocklimited.getText(), "Limited");
	}
		
		
	}
	
	public boolean isEnabledDelete()
	{
	boolean value= MPDelete.isEnabled();
	return value;
	}
	
	public void clickMP()
	{
	guobj1.clickCommand(MPMoreinfo);
	}
	
	public String getpageTitle()
	{
	String title = driver.getTitle();
	return title;
	}
	
	public void values() 
	{
	System.out.println(MPStockYes.getText());
	System.out.println(MPStockNo.getText());
	System.out.println(MPStockUnlimited.getText());
	System.out.println(MPStocklimited.getText());
	}
	
	@FindBy(xpath="//li[@class='breadcrumb-item']/a")
	WebElement home;
	public void home()
	{
	if(home.isDisplayed())
	{
	home.click();	
	}
	}
	
	
	
	
	
}
