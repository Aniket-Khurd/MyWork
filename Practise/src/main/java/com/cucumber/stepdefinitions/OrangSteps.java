package com.cucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.cucumber.pages.OrangeHRMHomePage;
import com.cucumber.pages.OrangeHRMLoginPage;

import io.cucumber.java.en.*;

public class OrangSteps {
	
	public WebDriver driver;
	OrangeHRMLoginPage loginPage;
	OrangeHRMHomePage homePage;
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		driver = new ChromeDriver();
		
		loginPage = new OrangeHRMLoginPage(driver);
		homePage = new OrangeHRMHomePage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("Page title is {string}")
	public void page_title_is(String title) {
	   String actualTitle = driver.getTitle();
	   Assert.assertEquals(actualTitle, title);
	}

	@Then("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	}

	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
	   loginPage.clickOnLogin();
	}

	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
	   Assert.assertTrue(homePage.logoutDropdown.isDisplayed()); 
	}
	

	@Then("User clicks on logout link")
	public void user_clicks_on_logout_link() {
	   homePage.logOut(); 
	}

	@Then("User should be on login page")
	public void user_should_be_on_login_page() {
	   Assert.assertTrue(loginPage.userNameLocator.isDisplayed());
	}
	

	@Then("User closes the browser")
	public void user_closes_the_browser() {
	   driver.quit();
	}
	

	@Then("User fails to login and invalid credentials message is displayed as {string}")
	public void user_fails_to_login_and_invalid_credentials_message_is_displayed_as(String message) {
	    String actualMessage = loginPage.invaliCredentialsMessage.getText();
	    Assert.assertEquals(actualMessage, message);
	}

}
