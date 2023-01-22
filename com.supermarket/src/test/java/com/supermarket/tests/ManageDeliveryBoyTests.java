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
  public void manageDeliveryBoyMoreinfo() throws IOException 
  {
   Hmobj = new HomePage(driver);
   Mdbobj=new ManageDeliveryBoyPages(driver);
   Hmobj.navigateToHomePage();
   Mdbobj.manageDeliveryBoyMoreinfo();
   Assert.assertEquals(Mdbobj.getpageTitle(), Constants.deliverboymoreinfo);
  }
  @Test(priority=2)
  public void newDeliveryBoy() throws AWTException 
  {
   Mdbobj.newDeliverBoy();
   Assert.assertEquals(Mdbobj.namecellDeliveryBoy(),Constants.EditedUsernamecell);
  }
   
  @Test(priority=3)
  public void searchDeliveryBoy() 
  {
  String nameCellaftersearch=Mdbobj.searchDeliveryBoy();
  Assert.assertEquals(nameCellaftersearch, Constants.EditedUsernamecell);
  }
  
  @Test(priority=4)
  public void passwordDeliveryBoy() throws InterruptedException
  {
  String DeliveryBoyPassword= Mdbobj.passwordDoubleButton();
  Assert.assertEquals(DeliveryBoyPassword, Constants.DeliveryBoypassword);
  }
  
  
  @Test(priority=5)
  public void deliveryBoystatus() throws InterruptedException 
  {
  String DeliverBoyActive = Mdbobj.deliveryBoystatus();
  Assert.assertEquals(DeliverBoyActive, Constants.Activestatus);
  }
  
  @Test(priority=6)
  public void deleteDeliveryBoy() 
  {
  boolean deletedsuccessfullyAlert= Mdbobj.deleteDeliveryBoy();
  Assert.assertTrue(deletedsuccessfullyAlert);
  }
  

  @Test(priority=7)
  public void hamburgerButton() 
  {
  String HamburgerTitle=Mdbobj.HamburgerButton();
  Assert.assertEquals(HamburgerTitle, Constants.HamburgerbuttonTitle);
  }
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
