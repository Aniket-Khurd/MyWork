package com.crossbrowser.classlevel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crossbrowser.pages.OrangeHomePageCrossBrows;
import com.crossbrowser.pages.OrangeLoginPageCrossBrows;

public class ClassLevelParallel1 {
	WebDriver driver;
	OrangeHomePageCrossBrows homePage;
	OrangeLoginPageCrossBrows loginPage;
	
	@BeforeClass
	@Parameters("browser1")
	public void setup(String browser1) {
		switch(browser1.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
			driver = new ChromeDriver();
			
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", ".//src//main//resources//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", ".//src//main//resources//msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;
		}
		System.out.println(Thread.currentThread().getName()+": "+browser1);
		homePage = new OrangeHomePageCrossBrows(driver);
		loginPage = new OrangeLoginPageCrossBrows(driver);
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
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
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
