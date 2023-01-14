package com.supermarket.utilities;

import org.testng.IRetryAnalyzer;    //has a method called Retry so dont use that name 
import org.testng.ITestResult;

public class RetryAnalyserUtility implements IRetryAnalyzer {
	private int retryCount=0;
	private static final int maxRetryCount=3;
	public boolean retry(ITestResult result)
	{
		if (retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
		}
		 return false;
	}

}
