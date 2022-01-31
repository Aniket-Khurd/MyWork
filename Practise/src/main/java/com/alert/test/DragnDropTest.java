package com.alert.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alertsactions.base.DragnDropBaseClass;

public class DragnDropTest extends DragnDropBaseClass {
	Actions act;
	@Test(enabled = false)
	public void dragDrop() {
		act = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(draggable, dropable).perform();
		
		String actual = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		String expected = "Dropped!";
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void dragDropOffset() {
		act = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		
		//act.dragAndDrop(draggable, dropable).perform();
		int xOffsetDrag = draggable.getLocation().getX();
		int yOffsetDrag = draggable.getLocation().getY();
		System.out.println("xOffsetDrag: "+xOffsetDrag+" yOffsetDrag: "+yOffsetDrag);
		
		int xOffsetDrop = dropable.getLocation().getX();
		int yOffsetDrop = dropable.getLocation().getY();
		System.out.println("xOffsetDrop: "+xOffsetDrop+" yOffsetDrop: "+yOffsetDrop);
		
		int xPosition = (xOffsetDrop - xOffsetDrag)+10;
		int yPosition = (xOffsetDrag - yOffsetDrag)-120;
		System.out.println("X: "+xPosition+" Y: "+yPosition);
		
		act.dragAndDropBy(draggable, xPosition, yPosition).perform();
		String actual = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		String expected = "Dropped!";
		System.out.println(actual);
		
		Assert.assertEquals(actual, expected);
	}

}
