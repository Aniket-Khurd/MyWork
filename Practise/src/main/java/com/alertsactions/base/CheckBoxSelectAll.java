package com.alertsactions.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxSelectAll {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int sizeofcheckbox = checkbox.size();
		System.out.println(sizeofcheckbox);

		for(WebElement ch:checkbox){
			if(!ch.isSelected()){
				ch.click();
			}
		}
	}
}
