package com.supermarket.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	ExcelUtility exobj=new ExcelUtility();
	GeneralUtilities guobj=new GeneralUtilities();
	WaitUtility wait = new WaitUtility();
	
	//TESTCASE 21
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreInfo;
	// TESTCASE 22
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newUser;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement dropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	// TESTCASE 23
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[4]//i[@class='fa fa-angle-double-down']")
	WebElement passworddoubleDropdown;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]")
	WebElement passwordDisplay;
	// TESTCASE 24
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()=\"Active\"]")
	WebElement statusActive;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()=\"Inactive\"]")
	WebElement statusInactive;
	// TESTCASE 25
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//i[@class='fas fa-edit']")
	WebElement editButton;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	WebElement rowxpath;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	WebElement columnxpath;

	// div[@class='alert alert-success alert-dismissible']
	// TESTCASE 26
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
		
	public AdminUsersPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public String getpageTitle()
	{
	String title = driver.getTitle();
	return title;
	}

	
	public void adminUsers() throws IOException 
	{
	guobj.clickCommand(adminUsersMoreInfo);	
	}
	
	
	public boolean newUserAdd() throws IOException, AWTException 
	{
	guobj.clickCommand(newUser);
	username.sendKeys(exobj.readStringData(4,1));
	password.sendKeys(exobj.readStringData(5,1));
	Select obj = new Select(dropDown);
	obj.selectByVisibleText("Admin");
	guobj.clickCommand(saveButton);
	return successAlert.isDisplayed();		
	}
	
	
	public String passworddoubleDropdown() 
	{
	guobj.clickCommand(passworddoubleDropdown);
	return passwordDisplay.getText();
	}
	
	
	public String statusCheck() throws InterruptedException 
	{
	if(statusActive.isDisplayed()) 
	{
	statusActive.click();
	wait.eWToBeClickableCommand(driver, statusInactive);
	statusInactive.click();
	wait.eWToBeClickableCommand(driver, statusActive);
	}
	else if(statusInactive.isDisplayed()) 
	{
	statusInactive.click();
	wait.eWToBeClickableCommand(driver, statusActive);
	statusActive.click();
	}
	return statusActive.getText();
	}
	
	public boolean editUser() throws IOException {
	guobj.clickCommand(editButton);
	guobj.clearCommand(username);
	username.sendKeys(exobj.readStringData(6, 1));
	guobj.clickCommand(updateButton);
	return successAlert.isDisplayed();
	}
		

	public boolean deleteUser() {
	guobj.clickCommand(deleteButton);
	driver.switchTo().alert().accept();
	return successAlert.isDisplayed();
	}
    }
