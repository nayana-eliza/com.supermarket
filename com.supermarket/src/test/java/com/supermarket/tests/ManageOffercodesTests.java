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
  public void offercodeMoreinfo() throws IOException 
  {
  Hmobj=new HomePage(driver);
  MOCobj=new ManageOffercodesPages(driver);
  Hmobj.navigateToHomePage();
  MOCobj.ManageOfferCodemoreinfo();
  Assert.assertEquals(MOCobj.getpageTitle(), Constants.offecrcodemoreinfo);
  }
  
  @Test(priority=2)
  public void newOfferCode() throws AWTException, InterruptedException{
  Assert.assertTrue(MOCobj.newOfferCode());
  }
	  
  @Test(priority=3)
  public void offerCodeStatusCheck() throws InterruptedException
  {
  Assert.assertEquals(MOCobj.offercodeStatusCheck(), Constants.Activestatus);
  }
  
  @Test(priority=4)
  public void editOfferCode() throws AWTException, IOException
  {
  Assert.assertEquals(MOCobj.editOffercode(), Constants.percentage);
  }
  
  @Test(priority=5)
  public void offerCodeDeleteButton() throws AWTException { 
  Assert.assertTrue(MOCobj.deleteOffercode());  
  }
  
  @Test(priority=6)
  public void sliderMoreinfo() {  
  MOCobj.ManagesliderMoreinfo();
  Assert.assertEquals(MOCobj.getpageTitle(), Constants.slidermoreinfo);
  }
  
  @Test(priority=7)
  public void sliderStatus() throws InterruptedException {
  String sliderStatus =MOCobj.sliderStatus(); 
  Assert.assertEquals(sliderStatus, Constants.Activestatus);
  }
  
  @Test(priority=8)
  public void newSliderAddition() throws AWTException {
  boolean newSlider= MOCobj.newSlider(); 
  Assert.assertTrue(newSlider);  
  }
  
  
  @Test(priority=9)
  public void home() {
  Hmobj.navigateBack();
  Assert.assertTrue(Hmobj.isDisplayedValue());
  }
 
  @Test(priority=10)
  public void sliderDeleteButton() throws AWTException {
  boolean sliderDeletestatus= MOCobj.sliderDelete(); 
  Assert.assertTrue(sliderDeletestatus);  
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  }
