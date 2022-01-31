package com.crossbrowser.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHomePageCrossBrows {
	public WebDriver driver;
	Logger logger;
	
	@FindBy(xpath = "//a[@class='panelTrigger']")public WebElement logoutDropdown;
	@FindBy(xpath = "//a[text()='Logout']") WebElement logoutButton;
	
	public OrangeHomePageCrossBrows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void logOut() {
		
		logoutDropdown.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = logoutButton;
		wait.until(ExpectedConditions.visibilityOf(element));
		logoutButton.click();
		//Logs.log.info("Logging out from website");
		
	}
	
	public boolean waitForLogoutDropdown() {
		boolean check = logoutDropdown.isDisplayed();
		return check;
	}

}
