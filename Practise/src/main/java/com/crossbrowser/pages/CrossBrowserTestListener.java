package com.crossbrowser.pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.remote.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CrossBrowserTestListener extends CrossBrowserBaseClass implements ITestListener {
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test; 
	//WebDriver driver;
	
	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Executing test:  "+result.getName()+" in ");//+browserName);
		test = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		
		ExtentFactory.getInstance().setExtent(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Object browserName1=null;
		String nameofBrowser = null;
//		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
//		String name = cap.getBrowserName();
//		System.out.println("NAME: "+name);
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
			Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
			nameofBrowser = cap.getBrowserName();
			System.out.println("NAME: "+nameofBrowser);
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
		}
		try {
			 	browserName1 =  result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			System.out.println("Exception occured: "+e);
			e.printStackTrace();
		}
		
		System.out.println("Test Executed Successfully: "+result.getName()+" in "+browserName1);
		System.out.println("Test Executed Successfully: "+result.getName()+" in "+nameofBrowser);
		String logText = "Test Method "+result.getMethod().getMethodName()+" Executed Successfully in: "+nameofBrowser;
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentFactory.getInstance().getExtent().log(Status.PASS, m);
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName()+" in ");//+browserName);
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: "+result.getName()+" in ");//+browserName);
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, m);
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Started: "+context.getName());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//output//CrossBrowserExtent.html");
		sparkReporter.config().setDocumentTitle("Htmlreport");
		sparkReporter.config().setReportName("CrossBrowserReport");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Tester", "Aniket");
		//extent.setSystemInfo("Browser", browserName);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Completed: "+context.getName());
		extent.flush();
	}

}
