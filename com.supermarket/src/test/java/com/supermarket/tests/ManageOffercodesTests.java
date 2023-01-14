package com.supermarket.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreport.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPages;
import com.supermarket.pages.ManageOffercodesPages;
import com.supermarket.pages.ManageProductsPages;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ManageOffercodesTests extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPages Lpobj;
	HomePage Hmobj;
	ExcelUtility exobj = new ExcelUtility();
	GeneralUtilities  guobj1 = new GeneralUtilities();
    ManageOffercodesPages MOCobj;
    
  
  @Test(priority=1)
  public void offercodeMoreinfo() throws IOException {

	  Hmobj=new HomePage(driver);
	  MOCobj=new ManageOffercodesPages(driver);
      Hmobj.navigateToHomePage();
	  MOCobj.ManageOfferCodemoreinfo();
	  Assert.assertEquals(MOCobj.getpageTitle(), Constants.offecrcodemoreinfo);
  }
  
  @Test(priority=2)
  public void newOfferCode() throws AWTException, InterruptedException{
	  MOCobj.newOfferCode();  
  }
	  
  @Test(priority=3)
  public void offerCodeStatusCheck() throws InterruptedException
  {
	  MOCobj.offercodeStatusCheck();  
  }
  
  @Test(priority=4)
  public void editElement() throws AWTException
  {
	  MOCobj.editOffercode();
  }
  
  @Test(priority=5)
  public void sliderMoreinfo() {
	  MOCobj.ManagesliderMoreinfo();
	  Assert.assertEquals(MOCobj.getpageTitle(), Constants.slidermoreinfo);
  }
  
  @Test(priority=6)
  public void sliderStatus() throws InterruptedException {
	  MOCobj.sliderStatus(); 
  }
  
  @Test(priority=7)
  public void newSliderAddition() throws AWTException {
	  MOCobj.newSlider();  
	  
  }
  
  @Test(priority=8)
  public void home() {
	  Hmobj.navigateBack();
  }
 
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
