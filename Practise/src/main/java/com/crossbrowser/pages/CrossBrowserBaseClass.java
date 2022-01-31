package com.crossbrowser.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CrossBrowserBaseClass {
	public  WebDriver driver;
	//public String browserName;
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {

		switch(browser.toLowerCase()) {
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
		
		//setBrowserName(browser);
		System.out.println(Thread.currentThread().getName()+": "+browser);
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
//	public void setBrowserName(String name) {
//		browserName = "chrome";
//	}
//	
//	public String getBrowser() {
//		System.out.println("inside getBrowser: "+browserName);
//		return browserName;
//	}
	
	//public String browserName = "chrome";
	
	public  String browserName() {
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		return cap.getBrowserName();
	}

}
