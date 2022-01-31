package com.alertsactions.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RobotDemo {
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit. SECONDS);
		driver.get("https://www.grammarly.com/plagiarism-checker");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit. SECONDS);
		System.out.println("A1");

		JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll operation using Js Executor
		js.executeScript("window.scrollBy(0,200)"); // Scroll Down(+ve) upto browse option
		Thread.sleep(5000); 
		System.out.println("A2");
		WebElement browse = driver.findElement(By.xpath("//div[text()='Upload a file']"));
		
		System.out.println("A3");
		browse.click(); 
		Thread.sleep(2000); 

		
		Robot rb = new Robot();

		
		StringSelection str = new StringSelection("C:\\Users\\Admin123\\Downloads\\AutomationDoc.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

}
