package com.extent.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentBaseClass {
	public static WebDriver driver;
//	public ExtentSparkReporter sparkReporter;
//	public ExtentReports extent;
//	public ExtentTest tests;
	
	
	@BeforeTest
	public void extentSetup() {
//		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//output//OrangeHRMExtent.html");
//		sparkReporter.config().setDocumentTitle("Htmlreport");
//		sparkReporter.config().setReportName("Functional Report");
//		sparkReporter.config().setTheme(Theme.DARK);
//		
//		extent = new ExtentReports();
//		extent.attachReporter(sparkReporter);
//		
//		extent.setSystemInfo("Tester Name", "Aniket");
//		extent.setSystemInfo("Browser", "Chrome");
		
		
		
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		//tests = extent.createTest("OrangeHRMTest");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//tests.log(Status.INFO, "Test started");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		//tests.info("Website loaded correctly & Actual title matches with Expected title");
		//tests.pass("OrangHRM.com");
		//screenShot("OrangeHRM");
		
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
		//tests.info("Driver closed");
	}
	
	@AfterTest
	public void endReporter() {
		//extent.flush();
	}
	
	public static String screenShot(String fileName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//output//"+fileName+dateName+".png"; 
		try {
			FileUtils.copyFile(f1, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;

		//tests.pass(MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		//tests.addScreenCaptureFromPath(destination);
	}
//	public static void main(String[] args) {
//		launchBrowser();
//	}

}
