package com.cucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
	   System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	   driver.get("https://opensource-demo.orangehrmlive.com/");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("^title of login page is OrangeHRM$")
	public void title_of_login_page_is_orange_hrm() {
	    String actualTitle = driver.getTitle();
	    System.out.println("Title is: "+actualTitle);
	    Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
	    Assert.assertTrue(driver.findElement(By.xpath("//a[@class='panelTrigger']")).isDisplayed());
	}




}
