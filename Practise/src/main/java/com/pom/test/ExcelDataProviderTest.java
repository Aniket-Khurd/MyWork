package com.pom.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.pages.BaseClass;
import com.pom.pages.DataProviderExcel;
import com.pom.pages.OrangeLoginPage;

public class ExcelDataProviderTest extends BaseClass {
	OrangeLoginPage loginPage;
	
	@BeforeClass
	public void initialize() {
		loginPage = new OrangeLoginPage(driver);
	}
	
  @Test(dataProvider = "excelData", dataProviderClass = DataProviderExcel.class)
  public void invalidLogin(String username, String password) {
	  loginPage.invalidLogin(username, password);
	  Assert.assertEquals(loginPage.invaliCredentialsMessage.getText(), "Invalid credentials");
  }
}
