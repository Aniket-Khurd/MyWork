package com.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.internal.thread.ThreadUtil;

public class BaseClass2 {
	//public WebDriver driver1;
	
	ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();
	
	@BeforeClass//(groups = {"checkin","functional"})
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		driver.set(new ChromeDriver()); //=new ChromeDriver();
		//driver1 = getDriver();
		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get("https://opensource-demo.orangehrmlive.com/");
		String actualTitle = getDriver().getTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
//	
//	@AfterMethod
//	public void quitBrowser() {
//		getDriver().quit();
//	}
	
//	public static void main(String[] args) {
//		launchBrowser();
//	}

}
