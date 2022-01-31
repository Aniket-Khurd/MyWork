package com.pom.test;

import javax.annotation.concurrent.ThreadSafe;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pom.pages.BaseClass;
import com.pom.pages.BaseClass2;
import com.pom.pages.OrangeHomePage;
import com.pom.pages.OrangeLoginPage;

public class OrangeHRMTest extends BaseClass2 {
	OrangeLoginPage logInPage; 
	OrangeHomePage homePage;

	//@BeforeMethod
	@BeforeClass
	public void initialize() {
		//launchBrowser();
		logInPage = new OrangeLoginPage(getDriver()); 
		homePage = new OrangeHomePage(getDriver());
	}

	
	@Test(priority = 1)
	//@Parameters({"userName", "passWord"})
	public void validLogin() {	
		//System.out.println("validLogin thread id: "+Thread.currentThread().getId());
		logInPage.validLogin("Admin", "admin123");
		homePage.logOut();
	//	Assert.assertTrue(homePage.logoutDropdown.isDisplayed());
	}
	
//	@Test(dependsOnMethods = {"validLogin"})
//	public void logOut() {		
//		homePage.logOut();
//	}
	
	@Test(dataProvider = "data", priority = 2)	
	public void invalidLogin(String userName, String passWord) {
		//System.out.println("invalidLogin thread id: "+Thread.currentThread().getId());
		logInPage.invalidLogin(userName, passWord);
		
		//Assert.assertEquals(logInPage.invaliCredentialsMessage.getText(), "Invalid credentials");
	}
	
	@DataProvider(name = "data")
	public  Object[][] credentials(){

		return new Object[][] 
				{
			{"userName","passWord"},
			{"username1","abc123"},
//			{"username2","xyz123"}

				};
	}
}
