package com.extent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeLoginPageExtent  {
	WebDriver driver;


	@FindBy(id = "txtUsername") WebElement userNameLocator;
	@FindBy(id = "txtPassword") WebElement passWordLocator;
	@FindBy(id = "btnLogin") public WebElement loginButton;
	@FindBy(xpath = "//span[@id='spanMessage']") public WebElement invaliCredentialsMessage;

	public OrangeLoginPageExtent(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void validLogin(String userName, String passWord) {
		userNameLocator.sendKeys(userName);
		passWordLocator.sendKeys(passWord);
		loginButton.click();
		

		//Logs.log.info("Checking for Valid login credentials");
	}

	public void invalidLogin(String userName, String passWord) {
		userNameLocator.clear();
		userNameLocator.sendKeys(userName);
		passWordLocator.sendKeys(passWord);
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(invaliCredentialsMessage));
		String message = invaliCredentialsMessage.getText();
		System.out.println(message);
		//Logs.log.info("Checking for Invaid login credentials")
	}

}
