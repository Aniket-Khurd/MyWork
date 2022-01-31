package com.extent.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBasicDemo {
	
	static WebDriver driver;

	public static void main(String[] args) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".//ExtentReport.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		ExtentTest test = extent.createTest("OrangeHrm Site test");
		
		
		System.setProperty("webdriver.chrome.driver", ".//src//main/resources//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		test.log(Status.INFO, "Test Started");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		
		if(actual.equals(expected)) {
			test.pass("Website loaded correctly & title matches");
		}
		else {
			test.fail("Website loaded but title not matches with expected title");
		}
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		test.pass("Username entered in Username field");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		test.pass("Password entered in password field");
		
		driver.findElement(By.id("btnLogin"));
		test.pass("Login Button Clicked");
		
		//driver.quit();
		test.pass("Browser closed");
		
		test.info("Test completed");
		
		extent.flush();
		

	}

}
