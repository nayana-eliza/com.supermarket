package com.supermarket.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreport.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPages;
import com.supermarket.pages.ManageDeliveryBoyPages;
import com.supermarket.utilities.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ManageDeliveryBoyTests extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	HomePage Hmobj;
	LoginPages Lpobj;
	ExcelUtility exobj = new ExcelUtility();
	ManageDeliveryBoyPages Mdbobj;
	
  @Test(priority=1)
  public void manageDeliveryBoyMoreinfo() throws IOException {
	  Hmobj = new HomePage(driver);
	  Mdbobj=new ManageDeliveryBoyPages(driver);
	  Hmobj.navigateToHomePage();
	  Mdbobj.manageDeliveryBoyMoreinfo();
	  Assert.assertEquals(Mdbobj.getpageTitle(), Constants.deliverboymoreinfo);
  }
  @Test(priority=2)
  public void newDeliveryBoy() throws AWTException {
	  Mdbobj.newDeliverBoy();
  }
   
  @Test(priority=3)
  public void searchDeliveryBoy() {
	  Mdbobj.searchDeliveryBoy();  
  }
  
  @Test(priority=4,enabled = false)
  public void passwordDeliveryBoy() throws InterruptedException
  {
	  Mdbobj.passwordDoubleButton();
  }
  
  
  @Test(priority=5)
  public void deliveryBoystatus() throws InterruptedException {
	  Mdbobj.deliveryBoystatus();
  }
  
  @Test(priority=6)
  public void deleteDeliveryBoy() {
	  Mdbobj.deleteDeliveryBoy();
  }
  

  @Test(priority=7)
  public void hamburgerButton() {
	  Mdbobj.HamburgerButton();
  }
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
