package com.supermarket.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

    public class ManageOffercodesPages extends LoginPages {
	HomePage Hpobj;
	GeneralUtilities  guobj1 = new GeneralUtilities();
	WaitUtility wait = new WaitUtility();
	ExcelUtility exobj = new ExcelUtility();
	FileUploadUtility fuobj= new FileUploadUtility();
	
	
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
	
	//TESTCASE 7
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newOffercode;
	@FindBy(xpath = "//input[@value ='yes']")
	WebElement yesButton;
	@FindBy(xpath = "//input[@value ='no']")
	WebElement noButton;
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement SaveButton;
	// input[@id='offer_code']
	@FindBy(xpath = "//input[@id='offer_code']")
	WebElement testOfferCode;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement Offercodenamecell;
	@FindBy(xpath = "//a[text()=\"Cancel\"]")
	WebElement Cancel;
	@FindBy(xpath = "//li[@class='breadcrumb-item']/a")
	WebElement home;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]//i[@class='fas fa-trash-alt']")
	WebElement deleteOffercode;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement offercodeChoosefile;

	// TESTCASE 8
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//span[text()=\"Active\"]")
	WebElement ActiveStatus;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]//span[text()=\"Inactive\"]")
	WebElement InactiveStatus;
	// TESTCASE 9
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[6]/a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement offercodeEdit;
	@FindBy(xpath = "//input[@id='offer_per']")
	WebElement percentage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]")
	WebElement percentageCell;

	// TESTCASE 10
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-slider']")
	WebElement sliderMoreinfo;

	// TESTCASE 11
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()='Active']")
	WebElement sliderStatusActive;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[3]//span[text()='Inactive']")
	WebElement sliderStatusInactive;

	// TESTCASE 12
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement Choosefile;
	@FindBy(xpath = "//input[@id='link']")
	WebElement updateLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newSlider;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[4]//i[@class='fas fa-trash-alt']")
	WebElement SliderDelete;
			
		
	public void ManageOfferCodemoreinfo() 
	{
	guobj1.clickCommand(ManageOfferCodemoreinfo);	
	}
		
	
	public boolean newOfferCode() throws AWTException, InterruptedException 
	{
	guobj1.clickCommand(newOffercode);
	guobj1.clickCommand(yesButton);
	testOfferCode.sendKeys(Constants.newOffercodeName);
	guobj1.scrolldown(driver);
	wait.eWToBeClickableCommand(driver, offercodeChoosefile);
	fuobj.fileUploadCommand(offercodeChoosefile, System.getProperty("user.dir")+"\\src\\main\\resources\\uploadFiles\\image.jpg");
    wait.eWToBeClickableCommand(driver, SaveButton);
	guobj1.enterKey();
	return successAlert.isDisplayed();
	}
		

	public String offercodeStatusCheck() throws InterruptedException 
	{
	guobj1.clickCommand(home);
	guobj1.clickCommand(ManageOfferCodemoreinfo);
	if (ActiveStatus.isDisplayed()) {
	guobj1.clickCommand(ActiveStatus);
	wait.eWToBeClickableCommand(driver, InactiveStatus);
	guobj1.clickCommand(InactiveStatus);
	}
	else if (InactiveStatus.isDisplayed()) 
	{
	guobj1.clickCommand(InactiveStatus);
	wait.eWToBeClickableCommand(driver, ActiveStatus);
	guobj1.clickCommand(ActiveStatus);
	}
	return ActiveStatus.getText();
	}
	

	public String editOffercode() throws AWTException, IOException 
	{
	guobj1.clickCommand(offercodeEdit);
	guobj1.clearCommand(percentage);
	guobj1.sendkeysCommand(percentage, Constants.editpercentage);
	guobj1.enterKey();
	return percentageCell.getText();
	}

	
	public boolean deleteOffercode() {
	guobj1.clickCommand(deleteOffercode);
	guobj1.AlertAcceptCommand(driver);
	return successAlert.isDisplayed();
	}

	public void ManagesliderMoreinfo() {
	guobj1.clickCommand(home);
	guobj1.clickCommand(sliderMoreinfo);
	}
	

	public String sliderStatus() throws InterruptedException 
	{
	if (sliderStatusActive.isDisplayed()) {
	guobj1.clickCommand(sliderStatusActive);
    wait.eWToBeClickableCommand(driver, sliderStatusInactive);
	guobj1.clickCommand(sliderStatusInactive);
    } 
	else if (sliderStatusInactive.isDisplayed()) 
	{
	guobj1.clickCommand(sliderStatusInactive);
	wait.eWToBeClickableCommand(driver, sliderStatusInactive);
	guobj1.clickCommand(sliderStatusInactive);
	}
	return sliderStatusActive.getText();
    }
	
	
	public boolean newSlider() throws AWTException 
	{
	guobj1.clickCommand(newSlider);
	Choosefile.sendKeys(System.getProperty("user.dir"), "\\src\\main\\resources\\uploadFiles\\testing.jpg");
	updateLink.sendKeys(Constants.newSliderLink);
	guobj1.enterKey();
	return successAlert.isDisplayed();
	}
	
	
	public boolean sliderDelete()
	{
	guobj1.clickCommand(sliderMoreinfo);
    guobj1.clickCommand(SliderDelete);
	guobj1.AlertAcceptCommand(driver);
	return successAlert.isDisplayed();
	}
	}
    
   
    
    
