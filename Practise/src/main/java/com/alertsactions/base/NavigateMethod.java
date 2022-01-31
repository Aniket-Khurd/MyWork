package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.rediff.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Rediffmail")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Thread.sleep(5000);

		//driver.navigate().back();

		driver.findElement(By.id("login1")).sendKeys("Hello");


		Thread.sleep(5000);

		driver.navigate().refresh();
		Thread.sleep(15000);

		driver.navigate().back();


		Thread.sleep(5000);

		driver.navigate().forward();

	}

}
