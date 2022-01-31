package com.alertsactions.base;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
				
		
		driver.get("https://www.naukri.com");
		
		String mainWinId = driver.getWindowHandle();
		
		Set<String> allWinId=driver.getWindowHandles();
		
		for(String s:allWinId){
			System.out.println(s);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String s:allWinId){
			if(s.equals(mainWinId)){
				driver.switchTo().window(s);
			}
		}
		

	}

}
