package com.supermarket.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUsersPage {
	WebDriver driver;
	
	ExcelUtility exobj=new ExcelUtility();
	GeneralUtilities guobj=new GeneralUtilities();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getpageTitle()
	{
		String title = driver.getTitle();
				return title;
				}

	//TESTCASE 21
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreInfo;
	public void adminUsers() throws IOException {
		guobj.clickCommand(adminUsersMoreInfo);
		
	}
	
	//TESTCASE 22
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newUser;
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password ;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement dropDown ;
//	@FindBy(xpath="")
//	WebElement ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlert ;
	
	public void newUserAdd() throws IOException, AWTException {
		guobj.clickCommand(newUser);
		username.sendKeys(exobj.readStringData(4,1));
		password.sendKeys(exobj.readStringData(5,1));
		Select obj = new Select(dropDown);
		obj.selectByVisibleText("Admin");
		guobj.enterKey();
		Assert.assertTrue(successAlert.isDisplayed(),"new user created");
		driver.switchTo().alert().accept();	
		
	}
	
	//TESTCASE 23
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[4]//i[@class='fa fa-angle-double-down']")
    WebElement passworddoubleDropdown;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]")
	WebElement passwordDisplay;
	public void passworddoubleDropdown() {
		guobj.clickCommand(passworddoubleDropdown);
		Assert.assertEquals(passwordDisplay.getText(), "Password :Password@123 ");
	}
	
	//TESTCASE 24
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()=\"Active\"]")
    WebElement statusActive;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()=\"Inactive\"]")
    WebElement statusInactive;
	public void statusCheck() throws InterruptedException {
		if(statusActive.isDisplayed()) {
			statusActive.click();
			Thread.sleep(5000);
			statusInactive.click();
			Thread.sleep(5000);
			Assert.assertEquals(statusActive.getText(), "Active");
		}
		else if(statusInactive.isDisplayed()) {
			statusInactive.click();
			Thread.sleep(5000);
			statusActive.click();
			Thread.sleep(5000);
			Assert.assertEquals(statusInactive.getText(), "Inactive");
		}
	}
		//TESTCASE 25
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//i[@class='fas fa-edit']")
		WebElement editButton;
		@FindBy(xpath="//button[@name='Update']")
  		WebElement updateButton ;
		//div[@class='alert alert-success alert-dismissible']
		public void editUser() throws IOException {
			guobj.clearCommand(username);
			username.sendKeys(exobj.readStringData(6, 1));
			guobj.clickCommand(updateButton);
			Assert.assertTrue(successAlert.isDisplayed());
		}
		
		//TESTCASE 26
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//i[@class='fas fa-trash-alt']")
		WebElement deleteButton;
		public void deleteUser() {
			guobj.clickCommand(deleteButton);
			driver.switchTo().alert().accept();
			Assert.assertTrue(successAlert.isDisplayed());
		}
}
