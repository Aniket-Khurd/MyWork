package com.crossbrowser.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crossbrowser.pages.CrossBrowserBaseClass;

public class CrossBrowserDemo extends CrossBrowserBaseClass {
	
	@Test
	public void checkTitle() {
		
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(), "Google");
	}

}
