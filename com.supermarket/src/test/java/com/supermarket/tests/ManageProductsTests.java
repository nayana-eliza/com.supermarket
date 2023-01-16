package com.supermarket.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreport.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPages;
import com.supermarket.pages.ManageProductsPages;
import com.supermarket.utilities.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ManageProductsTests  extends BaseClass{
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPages Lpobj;
	ManageProductsPages MLpobj;
	ExcelUtility exobj = new ExcelUtility();
	HomePage hmobj;
	
  @Test(priority=1)
  public void loginHomePage() throws IOException {
	  Lpobj = new LoginPages(driver);
	  MLpobj = new ManageProductsPages(driver);
	  Lpobj.clearDetails();
	  Lpobj.login(exobj.readStringData(1,0),exobj.readStringData(1,1)); 
	  System.out.println(driver.getTitle());
	  MLpobj.clickMP();
	  System.out.println(MLpobj.getpageTitle());
	  Assert.assertEquals(MLpobj.getpageTitle(),Constants.moreinfopage);
  }
	 
	  @Test(priority=2)
	  public void manageProductsEditButton() throws IOException, AWTException, InterruptedException {
      MLpobj = new ManageProductsPages(driver);
	  MLpobj.clickEdit();
	  MLpobj.values();
	  }
	  
	  @Test(priority=3)
	  public void stockStatusButton() throws IOException, AWTException, InterruptedException {
      MLpobj = new ManageProductsPages(driver);
	  MLpobj.stock();
	  }

	  @Test(priority=4)
	  public void stockQuantityButton() throws IOException, AWTException, InterruptedException {
      MLpobj = new ManageProductsPages(driver);
	  MLpobj.stockstatus();
	  }
	  
	  @Test(priority=5)
	  public void homePage()
	  {
		  MLpobj.home();
		  Assert.assertTrue(MLpobj.isDisplayedValue());
	  }
	  
	  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
