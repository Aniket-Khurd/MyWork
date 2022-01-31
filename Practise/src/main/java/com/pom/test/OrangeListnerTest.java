package com.pom.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pom.pages.BaseClass;
import com.pom.pages.OrangeHomePage;
import com.pom.pages.OrangeLoginPage;

public class OrangeListnerTest extends BaseClass {
	OrangeLoginPage logInPage;
	OrangeHomePage homePage;
	@BeforeClass
	public void initialize() {
		logInPage = new OrangeLoginPage(driver);
		homePage = new OrangeHomePage(driver);
	}
	
  @Test(priority = 1)
  
  public void validLogin() {
	  logInPage.validLogin("Admin","admin123");
	  Assert.assertTrue(homePage.logoutDropdown.isDisplayed());
	  homePage.logOut();
	  //Assert.assertEquals(false, true);
  }
  
//  @Test(dependsOnMethods = {"validLogin"})
//  public void logOut() {
//	  homePage.logOut();
//  }
  
  @Test(dependsOnMethods = {"validLogin"}, priority=2)
  public void invalidLogin() {
	  logInPage.invalidLogin("ABC", "ABC1234");
		
	  Assert.assertEquals(logInPage.invaliCredentialsMessage.getText(), "Invalid credentials");
	 // Assert.assertEquals(false, true);
  }
}
