package com.javascript.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	public static void flash(WebElement element, WebDriver driver) {
		//JavascriptExecutor JsScript = (JavascriptExecutor)driver;
		String bgColor = element.getCssValue("bachgroundColor");
		for(int i=0; i<50; i++) {
			changeColor("#000000", element, driver);
			changeColor(bgColor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String getTitleByJavaScript(WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		String title = jsScript.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("history.go(0)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor jsScript = (JavascriptExecutor)driver;
		jsScript.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

}
