package com.supermarket.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

    public class ManageOffercodesPages extends LoginPages {
	HomePage Hpobj;
	GeneralUtilities  guobj1 = new GeneralUtilities();
	WaitUtility wait = new WaitUtility();
	
	public ManageOffercodesPages(WebDriver driver) 
	{
	super(driver);
	}
	 
	public String getpageTitle()
	{
	String title = driver.getTitle();
	return title;
	}
	
	
	//TESTCASE 6
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']")
	WebElement ManageOfferCodemoreinfo;
		
	public void ManageOfferCodemoreinfo() 
	{
	guobj1.clickCommand(ManageOfferCodemoreinfo);	
	}
		
	//TESTCASE 7
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newOffercode;
	@FindBy(xpath="//input[@value ='yes']")
	WebElement yesButton;
	@FindBy(xpath="//input[@value ='no']")
	WebElement noButton;
	@FindBy(xpath="//button[text()=\"Save\"]")
	WebElement SaveButton;
	//input[@id='offer_code']
	@FindBy(xpath="//input[@id='offer_code']")
	WebElement testOfferCode;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement Offercodenamecell;
	@FindBy(xpath="//a[text()=\"Cancel\"]")
	WebElement Cancel;
	@FindBy(xpath="//li[@class='breadcrumb-item']/a")
	WebElement home;
//	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
//	WebElement successAlert;
		
	public void newOfferCode() throws AWTException, InterruptedException 
	{
	guobj1.clickCommand(newOffercode);
	guobj1.clickCommand(yesButton);
	testOfferCode.sendKeys("testOfferCode");
	guobj1.enterKey();
	Assert.assertTrue(successAlert.isDisplayed());
	}
		
	// TESTCASE 8
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//span[text()=\"Active\"]")
	WebElement ActiveStatus;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//span[text()=\"Inactive\"]")
	WebElement InactiveStatus;

	public void offercodeStatusCheck() throws InterruptedException 
	{
	guobj1.clickCommand(home);
	guobj1.clickCommand(ManageOfferCodemoreinfo);
	if (ActiveStatus.isDisplayed()) {
	guobj1.clickCommand(ActiveStatus);
	wait.eWToBeClickableCommand(driver, InactiveStatus);
	guobj1.clickCommand(InactiveStatus);
	wait.eWToBeClickableCommand(driver, ActiveStatus);
	Assert.assertEquals(ActiveStatus.getText(), "Active");
	} else if (InactiveStatus.isDisplayed()) 
	{
	guobj1.clickCommand(InactiveStatus);
	wait.eWToBeClickableCommand(driver, ActiveStatus);
	guobj1.clickCommand(ActiveStatus);
	wait.eWToBeClickableCommand(driver, InactiveStatus);
	Assert.assertEquals(InactiveStatus.getText(), "Inactive");
	}
	}
		
	// TESTCASE 9
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]/a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement offercodeEdit;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement percentage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]")
	WebElement percentageCell;

	public void editOffercode() throws AWTException 
	{
	guobj1.clickCommand(offercodeEdit);
	guobj1.clearCommand(percentage);
	guobj1.sendkeysCommand(percentage, "40");
	guobj1.enterKey();
	Assert.assertEquals(percentageCell.getText(), "40%");
	}

	// TESTCASE 10
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-slider']")
	WebElement sliderMoreinfo;

	public void ManagesliderMoreinfo() {
	guobj1.clickCommand(home);
	guobj1.clickCommand(sliderMoreinfo);
	}
		
	// TESTCASE 11
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()='Active']")
	WebElement sliderStatusActive;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()='Inactive']")
	WebElement sliderStatusInactive;

	public void sliderStatus() throws InterruptedException 
	{
	if (sliderStatusActive.isDisplayed()) {
	guobj1.clickCommand(sliderStatusActive);
    wait.eWToBeClickableCommand(driver, sliderStatusInactive);
	guobj1.clickCommand(sliderStatusInactive);
	wait.eWToBeClickableCommand(driver, sliderStatusActive);
	Assert.assertEquals(sliderStatusActive.getText(), "Active");
    } else if (sliderStatusInactive.isDisplayed()) {
	guobj1.clickCommand(sliderStatusInactive);
	wait.eWToBeClickableCommand(driver, sliderStatusInactive);
	guobj1.clickCommand(sliderStatusInactive);
	wait.eWToBeClickableCommand(driver, sliderStatusActive);
	Assert.assertEquals(sliderStatusInactive.getText(), "Inactive");
	}
    }
	
	// TESTCASE 12
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement Choosefile;
	@FindBy(xpath = "//input[@id='link']")
	WebElement updateLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newSlider;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	public void newSlider() throws AWTException 
	{
	guobj1.clickCommand(newSlider);
	Choosefile.sendKeys("E:\\eclipse-workspace\\com.supermarket\\src\\main\\resources\\uploadFiles\\testing.jpg");
	updateLink.sendKeys("https://www.amazon.in/");
	guobj1.enterKey();
	Assert.assertTrue(successAlert.isDisplayed());
	}	
	}
