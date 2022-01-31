package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadUsingendKeys {
	public static void main(String[] args) {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver",".//src//main//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.monsterindia.com/seeker/registration");
		WebElement browse = driver.findElement(By.xpath("//input[@id='file-upload']"));
		browse.sendKeys("C:\\Users\\Admin123\\Downloads\\AutomationDoc.docx");
		System.out.println("File is Uploaded Successfully");
	}
}
