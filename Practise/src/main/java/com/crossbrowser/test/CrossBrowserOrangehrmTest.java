package com.crossbrowser.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crossbrowser.pages.CrossBrowserBaseClass;
import com.crossbrowser.pages.OrangeHomePageCrossBrows;
import com.crossbrowser.pages.OrangeLoginPageCrossBrows;

public class CrossBrowserOrangehrmTest extends CrossBrowserBaseClass{
	OrangeHomePageCrossBrows homePage;
	OrangeLoginPageCrossBrows loginPage;
	
	@BeforeClass
	public void initialize() {
		homePage = new OrangeHomePageCrossBrows(driver);
		loginPage = new OrangeLoginPageCrossBrows(driver);
	}
	
	@Test(priority = 1)
	public void logIn() {
		loginPage.validLogin("Admin", "admin123");
		Assert.assertTrue(homePage.logoutDropdown.isDisplayed());
		
		
	}
	
	

	@Test(dependsOnMethods = {"logIn"})
	public void logOut() {
		homePage.logOut();
	}
	
	@Test(dependsOnMethods = {"logOut"})
	public void invalidLogin() {
		loginPage.invalidLogin("Aniket", "aniket124");
		Assert.assertEquals(loginPage.invaliCredentialsMessage.getText(), "Invalid credentials");
	}

}
