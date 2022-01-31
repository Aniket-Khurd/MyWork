package com.pom.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.pom.pages.BaseClass;
import com.pom.pages.OrangeHomePage;
import com.pom.pages.OrangeLoginPage;


public class OrangeHrmGroupTest extends BaseClass {
	OrangeLoginPage logInPage;
	OrangeHomePage homePage;
	
	@BeforeGroups//(groups = {"checkin","functional"})
	public void initialize() {
		logInPage = new OrangeLoginPage(driver);
		homePage = new OrangeHomePage(driver);
	}
	
  @Test(groups = {"checkin"}, priority = 1)
  public void validLogin() {
	  logInPage.validLogin("Admin", "admin123");
	  Assert.assertTrue(homePage.logoutDropdown.isDisplayed());
	  
  }
  
  @Test(groups = {"checkin"},priority = 2)
  public void logOut() {
	 homePage.logOut();
  }
  
  @Test(groups= {"functional"}, priority = 3)
  public void invalidLogin() {
	  logInPage.invalidLogin("Abc", "12345");
	  Assert.assertEquals(logInPage.invaliCredentialsMessage.getText(), "Invalid credentials");
  }
}
