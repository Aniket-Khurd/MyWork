package com.extent.pages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersExtent  implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest tests;

	public void onTestStart(ITestResult result) {
		System.out.println("Test started: "+result.getName());
		tests = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//tests.generateLog(Status.INFO, result.getName());
		
		System.out.println("Test Successful "+result.getName());
		//tests.pass(result.getName()+"passed");
		
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		tests.log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName());
		tests.fail(result.getName());
		
		tests.log(Status.FAIL, result.getThrowable());
		String path = ExtentBaseClass.screenShot(result.getName());
		tests.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		tests.addScreenCaptureFromPath(path);
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		tests.log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: "+result.getName());
		tests.skip(result.getName());
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		tests.log(Status.SKIP, m);
	}

	public void onStart(ITestContext context) {
		System.out.println("Started: "+context.getName());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//output//OrangeHRMExtent.html");
		sparkReporter.config().setDocumentTitle("Htmlreport");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Tester Name", "Aniket");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Completed: "+context.getName());
		extent.flush();
	}

}
