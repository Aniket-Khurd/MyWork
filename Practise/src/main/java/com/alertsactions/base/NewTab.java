package com.alertsactions.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewTab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.rediff.com");
		String rediffTitle = driver.getTitle();
		System.out.println("Rediff pag titl: "+rediffTitle);
		String mainWindowId = driver.getWindowHandle();
		System.out.println("Main window: "+mainWindowId);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.linkText("Rediffmail")).sendKeys(newTab);

		Set<String> allWinId=driver.getWindowHandles();

		for(String s:allWinId){
			System.out.println(s);
		}
		
		for(String s:allWinId) {
			if(!s.equals(mainWindowId)) {
				driver.switchTo().window(s);
			}
		}
		
		String newTitle = driver.getTitle();
		System.out.println("Title after switching: "+newTitle);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='proceed']"))));
		
		driver.findElement(By.id("login1")).sendKeys("User123");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		driver.switchTo().window(mainWindowId);
		String checkTitle = driver.getTitle();
		System.out.println("Title after closing new tab: "+checkTitle);
		Assert.assertEquals(rediffTitle, checkTitle);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		System.out.println("completed");
	}

}
