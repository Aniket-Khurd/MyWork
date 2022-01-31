package com.javascript.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.twoplugs.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement joinFree = driver.findElement(By.xpath("//span[text()='Join now for free']/ancestor::li/child::a[@class='btn green']"));
		
		//JavaScriptUtil.flash(joinFree, driver);
		
		//JavaScriptUtil.drawBorder(joinFree, driver);
		
//		System.out.println(driver.getTitle());
//		
//		String title = JavaScriptUtil.getTitleByJavaScript(driver);
//		System.out.println("Title using JavaScriptExecutor: "+title);
		
//		WebElement loginButtn = driver.findElement(By.xpath("//a[@class='btn border']"));
//		JavaScriptUtil.clickElementByJS(loginButtn, driver);
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JavaScriptUtil.refreshBrowserByJS(driver);
		
//		WebElement image = driver.findElement(By.xpath("//img[@src='/newlayout/images/screen.png']"));
//		JavaScriptUtil.scrollIntoView(image, driver);
		
		JavaScriptUtil.scrollPageDown(driver);
	}

}
