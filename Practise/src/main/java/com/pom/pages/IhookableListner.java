package com.pom.pages;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class IhookableListner implements IHookable{

	public void run(IHookCallBack callBack, ITestResult testResult) {
		// TODO Auto-generated method stub
		Object[] parameterValues = callBack.getParameters();
		if (parameterValues[0].equals("userName")) {
		System.out.println("Skip the required parameter");
		} else {
		callBack.runTestMethod(testResult);
		System.out.println("I'm here");
		}
		
		callBack.runTestMethod(testResult);
	}

}
