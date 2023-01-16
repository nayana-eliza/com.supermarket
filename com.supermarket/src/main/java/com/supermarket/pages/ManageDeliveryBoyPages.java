package com.supermarket.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPages {
	WebDriver driver;
	GeneralUtilities guobj = new GeneralUtilities();
	HomePage Hmobj;
	WaitUtility wait = new WaitUtility();
	
	public ManageDeliveryBoyPages(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public String getpageTitle()
	{
	String title = driver.getTitle();
	return title;
	}
	
	//TESTCASE 1
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement ManageDeliverBoy;
	public void manageDeliveryBoyMoreinfo() 
	{
	guobj.clickCommand(ManageDeliverBoy);	
	}
	
	//TESTCASE 2
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newDeliverBoy;
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement nameCell;
	
	public void newDeliverBoy() throws AWTException 
	{
	guobj.clickCommand(newDeliverBoy);
	guobj.sendkeysCommand(name, "Naina");
	guobj.sendkeysCommand(username, "Naina@123");
	guobj.sendkeysCommand(password, "password@123");
	guobj.enterKey();
	Assert.assertEquals(nameCell.getText(), "Naina");
	}
	
	
	//TESTCASE 3
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	WebElement nameCellBeforeSearch;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchname;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement nameCellaftersearch;
	public void searchDeliveryBoy()
	{
	guobj.clickCommand(searchButton);
	guobj.sendkeysCommand(nameCellBeforeSearch, "Naina");
	guobj.clickCommand(searchname);
	Assert.assertEquals(nameCellaftersearch.getText(),"Naina");
	}
	
	//TESTCASE 4
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[7]//a")
	WebElement passwordDoubledown;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
	WebElement passwordBar;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement reset;
	
	public void passwordDoubleButton() throws InterruptedException
	{
	guobj.clickCommand(reset);
	wait.eWToBeClickableCommand(driver, passwordDoubledown);
	guobj.clickCommand(passwordDoubledown);
	Assert.assertEquals(passwordBar.getText(), Constants.DeliveryBoypassword);	
	}

	
	//TESTCASE 5
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[8]/a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement	deletedSuccessfully;
	
	public void deleteDeliveryBoy()
	{	
	guobj.clickCommand(deleteButton);
	guobj.AlertAcceptCommand(driver);
	Assert.assertTrue(deletedSuccessfully.isDisplayed());
	}
	
	
	//TESTCASE 6
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[text()=\"Active\"]")
	WebElement DeliveryBoyActive;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//span[text()=\"Inactive\"]")
	WebElement DeliveryBoyInactive;
	
	public void deliveryBoystatus() throws InterruptedException
	{
	guobj.clickCommand(reset);
	if(DeliveryBoyActive.isDisplayed()) 
	{
	DeliveryBoyActive.click();
	wait.eWToBeClickableCommand(driver, DeliveryBoyInactive);
	DeliveryBoyInactive.click();
	wait.eWToBeClickableCommand(driver, DeliveryBoyActive);
	Assert.assertEquals(DeliveryBoyActive.getText(), "Active");
	}
	else if(DeliveryBoyInactive.isDisplayed()) 
	{
	DeliveryBoyInactive.click();
	wait.eWToBeClickableCommand(driver, DeliveryBoyActive);
	DeliveryBoyActive.click();
	wait.eWToBeClickableCommand(driver, DeliveryBoyInactive);
	Assert.assertEquals(DeliveryBoyInactive.getText(), "Inactive");
	}
	}
	
	//TESTCASE 7
	@FindBy(xpath="//i[@class='fas fa-bars']")
	WebElement Hamburger;
	@FindBy(xpath="//a[@class='brand-link navbar-dark']")
	WebElement Heading;
	public void HamburgerButton() 
	{
	guobj.clickCommand(Hamburger);
	Assert.assertEquals(Heading.getText(), Constants.HamburgerbuttonTitle);
	}
    }
