package com.pom.pages;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ListenerITest implements ITestListener, IInvokedMethodListener{
	
	

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("beforeInvocation: "+testResult.getClass().getName()+
				"=>"+method.getTestMethod().getMethodName());
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("afterInvocation: "+testResult.getClass().getName()+
				"=>"+method.getTestMethod().getMethodName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test ran successfully: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: "+result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started: "+context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Ended: "+context.getName());
	}

	
	
	
	

	

}
