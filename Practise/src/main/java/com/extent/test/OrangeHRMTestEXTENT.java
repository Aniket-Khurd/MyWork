package com.extent.test;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.testng.Assert;
import org.testng.DependencyMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.extent.pages.ExtentBaseClass;
import com.extent.pages.OrangeHomePageExtent;
import com.extent.pages.OrangeLoginPageExtent;



public class OrangeHRMTestEXTENT extends ExtentBaseClass{
	OrangeLoginPageExtent logInPage; 
	OrangeHomePageExtent homePage;

	
	@BeforeClass
	public void initialize() {
		
		logInPage = new OrangeLoginPageExtent(driver); 
		homePage = new OrangeHomePageExtent(driver);
	}

	
	@Test(priority = 1)
	
	public void validLogin() {	
		//tests = extent.createTest("OrangeHRM validLogin");
		logInPage.validLogin("Admin", "admin123");
		
		if(homePage.logoutDropdown.isDisplayed()) {
			//tests.pass("Successfully logged in");
			//screenShot("validLoginSuccessfull");
		}
		else {
			//tests.fail("Failed to login");
			//screenShot("validLoginFailed");
		}
		Assert.assertTrue(homePage.logoutDropdown.isDisplayed());
	}
	
	@Test(dependsOnMethods = {"validLogin"})
	public void logOut() {	
		//tests = extent.createTest("OrangeHRM Logout");
		homePage.logOut();
		if(logInPage.loginButton.isDisplayed()) {
			//tests.pass("Logged out Successfully");
		}
		else {
			//tests.fail("Failed to logout");
		}
	}
	
	@Test(dependsOnMethods = {"logOut"})	
	public void invalidLogin() {
		//tests = extent.createTest("OrangeHRM InvalidLogin");
		logInPage.invalidLogin("Anky", "anky123");
		if(logInPage.invaliCredentialsMessage.isDisplayed()) {
			//tests.pass("Showing Invalid credentials message");
		}
		else {
			//tests.fail("Not showing Invalid credentials message");
		}
		Assert.assertEquals(logInPage.invaliCredentialsMessage.getText(), "Invalid credentials");
		//screenShot("InvalidLogin");
	}
	

}
