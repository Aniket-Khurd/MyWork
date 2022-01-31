package com.alert.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.alertsactions.base.MouseHoverBaseClass;

public class MouseHoverTest extends MouseHoverBaseClass {
	Actions act;
	@Test
	public void mouseHover() {
		act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Main Item 2']"))).perform();
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"))).perform();
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"))).perform();
	}

}
