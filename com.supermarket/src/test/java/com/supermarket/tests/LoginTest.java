package com.supermarket.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreport.TestListener;
import com.supermarket.pages.LoginPages;
import com.supermarket.utilities.DataProviderUtility;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.RetryAnalyserUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterTest;

public class LoginTest extends BaseClass {
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	LoginPages Lpobj;
	ExcelUtility exobj = new ExcelUtility();
	//String url ="https://groceryapp.uniqassosiates.com/admin/login";
	
  @Test(retryAnalyzer=RetryAnalyserUtility.class,groups="sanity")
  public void loginwithValidCredentials() throws IOException 
  {
  Lpobj = new LoginPages(driver);    //should write this ine first
  Lpobj.clearDetails();
  Lpobj.login(exobj.readStringData(1,0),exobj.readStringData(1,1));
  Assert.assertTrue(Lpobj.isDisplayedValue());  
  }
  
  
  @Test(dataProvider="LoginData",dataProviderClass=DataProviderUtility.class)
  public void loginwithInValidCredentials(String username , String password) throws IOException
  {
		  //excelUtility exobj = new excelUtility();
  Lpobj = new LoginPages(driver);    //sould write this ine first
  Lpobj.clearDetails();
  Lpobj.login(username,password);
  Assert.assertEquals(Lpobj.getErrorMsg(), Constants.expected);
  }
   
 
  @AfterTest
  public void afterTest() {
  }

}
