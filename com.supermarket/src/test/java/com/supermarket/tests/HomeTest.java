package com.supermarket.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.supermarket.pages.HomePage;

public class HomeTest extends BaseClass {
	HomePage Hmobj;
  @Test(groups="sanity")
  public void home() throws IOException {
	  System.out.println("Home Page Loading.......");
	  Hmobj = new HomePage(driver);
	  Hmobj.navigateToHomePage();
  }
}
