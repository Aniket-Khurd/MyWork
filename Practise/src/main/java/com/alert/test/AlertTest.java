package com.alert.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.alertsactions.base.AlertBaseClass;

public class AlertTest extends AlertBaseClass   {
	

	
	@Test(priority = 1)
	public void simpleAlert() {
		//AlertBaseClass.loadToolsQA();
		driver.findElement(By.id("alertButton")).click();

		Alert simpleAlert = driver.switchTo().alert();
		String alertMessage = simpleAlert.getText();
		System.out.println("Simple alert message: "+alertMessage);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		simpleAlert.accept();

		
	}
	
	@Test(priority = 2)
	public void timerAlert() {
		driver.findElement(By.id("timerAlertButton")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert timerAlert = driver.switchTo().alert();

		String alertMessage = timerAlert.getText();
		System.out.println("Tmer alert message: "+alertMessage);
		
		timerAlert.accept();
	}
	
	@Test(priority = 3)
	public void confirmAlert() {
		driver.findElement(By.id("confirmButton")).click();

		Alert simpleAlert = driver.switchTo().alert();
		String alertMessage = simpleAlert.getText();
		System.out.println("Confirm alert message: "+alertMessage);
		
		simpleAlert.dismiss();;
		
		String selection = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(selection);
	}
	
	@Test(priority = 4)
	public void promptAlert() {
		driver.findElement(By.id("promtButton")).click();

		Alert promptAlert = driver.switchTo().alert();
		String alertMessage = promptAlert.getText();
		System.out.println("Prompt alert message: "+alertMessage);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		promptAlert.sendKeys("Testing Alerts");
		
		promptAlert.accept();
		
		String text = driver.findElement(By.id("promptResult")).getText();
		System.out.println("Text entered in prompt alert: "+text);
		
	}

}
