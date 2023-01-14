package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name = "LoginData")
	  public Object[][] GetData() {
	    return new Object[][] {
	      new Object[] { "user1", "password1" },
	      new Object[] { "user2", "password2" },
	    };
	  }

}
