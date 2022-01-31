package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class DragnDropBaseClass {
	protected WebDriver driver;
	@BeforeClass
	public void loadBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable/");
	}

}
