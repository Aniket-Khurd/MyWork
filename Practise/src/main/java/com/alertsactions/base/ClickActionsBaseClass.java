package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ClickActionsBaseClass {
	protected WebDriver driver;
	
	@BeforeClass
	public void clickActions() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/buttons");
	}
	
	@AfterClass
	public void tearDown() {
		
	}

}
