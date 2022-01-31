package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameHandeling {
	WebDriver driver;
	
	@BeforeClass
	public void loadWebsite() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/frames");
	}
	
	@Test(enabled = false)
	public void frameDemonstration() throws Exception {
		driver.switchTo().frame("frame1");
		Thread.sleep(5000);
		String frameHeader = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(frameHeader);
	}
	
	@Test
	public void frameDemonstrationWebElement() throws Exception {
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		Thread.sleep(5000);
		String frameHeader = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(frameHeader);
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
