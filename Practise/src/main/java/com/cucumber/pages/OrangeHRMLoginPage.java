package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

	public WebDriver driver;

	@FindBy(id = "txtUsername")
	public WebElement userNameLocator;
	
	@FindBy(id = "txtPassword")
	WebElement passWordLocator;
	
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='spanMessage']") 
	public WebElement invaliCredentialsMessage;

	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String userName) {
		userNameLocator.clear();
		userNameLocator.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passWordLocator.clear();
		passWordLocator.sendKeys(password);
	}

	public void clickOnLogin() {
		loginButton.click();
	}

}
