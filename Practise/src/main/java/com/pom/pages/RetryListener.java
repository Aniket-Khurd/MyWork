package com.pom.pages;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
	int count = 0;
	int retryLimit = 2;

	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		System.out.println("Retry count is: "+count);
		return false;
	}

}
