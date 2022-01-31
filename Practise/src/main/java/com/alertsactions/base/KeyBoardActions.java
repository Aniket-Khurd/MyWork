package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyBoardActions {
	WebDriver driver;
	Actions act;
	
	@BeforeClass
	public void loadWebsite() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/text-box");
	}
	
	@Test
	public void copyPasteByKeyboard() {
		act = new Actions(driver);
		
		driver.findElement(By.id("userName")).sendKeys("Aniket");
		
		driver.findElement(By.id("userEmail")).sendKeys("test@actions.com");
		
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Magarpatta City");
		
		//to select current address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		
		//to copy current address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		
		//to switch focus to permanent address
		act.sendKeys(Keys.TAB);
		act.build().perform();
		
		//to paste address
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
		Assert.assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
