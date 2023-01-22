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
  Boolean newUserValue= Adobj.newUserAdd();
  Assert.assertTrue(newUserValue);  
  }
  
  
  @Test(priority=3,enabled=false)
  public void passworddoubleDropdown() {
  String AdminUserPassword= Adobj.passworddoubleDropdown();
  Assert.assertEquals(AdminUserPassword, Constants.AdminUserspassword); 
  }
  
  
  @Test(priority=4)
  public void statusCheck() throws InterruptedException {
  String StatusActive = Adobj.statusCheck(); 
  Assert.assertEquals(StatusActive, Constants.Activestatus);
  }
  
  @Test(priority=5)
  public void editUser() throws IOException {
  boolean editUserValue = Adobj.editUser(); 
  Assert.assertTrue(editUserValue);
  }
  
  
  @Test(priority=6)
  public void deleteButton() {  
  boolean deleteButtonValue= Adobj.deleteUser();
  Assert.assertTrue(deleteButtonValue);
  }
  }
