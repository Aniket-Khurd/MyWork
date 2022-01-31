package com.alert.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alertsactions.base.ClickActionsBaseClass;

public class ClickActionsTest extends ClickActionsBaseClass {
	Actions act;
	
	@Test
	public void rightClick() {
		act = new Actions(driver);
		WebElement element = driver.findElement(By.id("rightClickBtn"));
		
		act.contextClick(element).perform();
		
		String check = driver.findElement(By.id("rightClickMessage")).getText();
		String expected = "You have done a right click";
		System.out.println(check);
		Assert.assertEquals(check, expected);
			
		
	}
	
	@Test
	public void doubleClick() {
		act = new Actions(driver);
		WebElement element = driver.findElement(By.id("doubleClickBtn"));
		
		act.doubleClick(element).perform();
		
		String actual = driver.findElement(By.id("doubleClickMessage")).getText();
		String expected = "You have done a double click";
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test
	public void singleClick() {
		act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		act.click(element).perform();
		
		String actual = driver.findElement(By.id("dynamicClickMessage")).getText();
		String expected = "You have done a dynamic click";
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected);
		
	}

}
