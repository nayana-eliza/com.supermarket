package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPages;
import com.supermarket.utilities.ExcelUtility;

public class AdminUsersTests extends BaseClass{
	HomePage Hmobj;
	AdminUsersPage Adobj;
	LoginPages Lpobj;
	ExcelUtility exobj=new ExcelUtility();
	
  @Test(priority=1)
  public void adminUsersMoreInfo() throws IOException {
	  Hmobj= new HomePage(driver);
	  Lpobj= new LoginPages(driver);
	  Adobj = new AdminUsersPage(driver);
	  Hmobj.navigateToHomePage();
	  Adobj.adminUsers();
	  Assert.assertEquals(Adobj.getpageTitle(), Constants.AdminUsersmoreinfo);
  }
	
	
  @Test(priority=2)
  public void newUser() throws IOException, AWTException {
	  Adobj.newUserAdd();	  
  }
  
  
  @Test(priority=3,enabled=false)
  public void passworddoubleDropdown() {
	   Adobj.passworddoubleDropdown();  
  }
  
  
  @Test(priority=4)
  public void statusCheck() throws InterruptedException {
	  Adobj.statusCheck();  
  }
  
  @Test(priority=5)
  public void editUser() throws IOException {
	  Adobj.editUser(); 	  
  }
  
  
  @Test(priority=6)
  public void deleteButton() {  
	  Adobj.deleteUser();
  }
}
