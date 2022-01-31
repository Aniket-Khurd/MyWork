package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NOPCommerceLoginPage {
	WebDriver driver;
	
	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	public NOPCommerceLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailId) {
		emailField.clear();
		emailField.sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	

}
