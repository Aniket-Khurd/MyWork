package com.javascript.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("alert('Welcome to Google')");

	}

}
