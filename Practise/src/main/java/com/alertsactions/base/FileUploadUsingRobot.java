package com.alertsactions.base;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadUsingRobot {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Robot robot = new Robot();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("submitbtn"))));
		
		WebElement element = driver.findElement(By.xpath("//input[@id='imagesrc']"));
		boolean flag = element.isDisplayed();
		System.out.println(flag);
		element.sendKeys("C:\\Users\\Admin123\\Pictures\\Ganesha11.jpg");
		//element.click();
		
		boolean select = element.isSelected();
		System.out.println(select);
		
	
		
		
		

	}

}
