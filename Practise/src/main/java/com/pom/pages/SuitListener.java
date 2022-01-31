package com.pom.pages;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuitListener implements ISuiteListener {

	public void onStart(ISuite suite) {
		System.out.println("On Suite Start: "+suite.getName());
	}

	public void onFinish(ISuite suite) {
		System.out.println("On Suite Finish: "+suite.getName());
	}

}
