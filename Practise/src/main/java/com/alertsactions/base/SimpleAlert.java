package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleAlert {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//canvas[@class='flot-overlay']"))));
	
	Alert simpleAlert = driver.switchTo().alert();
	simpleAlert.accept();
	
}
}