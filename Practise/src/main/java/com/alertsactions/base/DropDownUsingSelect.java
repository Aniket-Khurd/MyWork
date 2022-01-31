package com.alertsactions.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUsingSelect {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select sel = new Select(country);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sel.selectByValue("13");
		
		sel.selectByVisibleText("Germany");
		
		//sel.selectByIndex(5);

	}

}
