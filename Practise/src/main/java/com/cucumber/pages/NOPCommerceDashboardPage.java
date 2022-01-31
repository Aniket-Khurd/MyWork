package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NOPCommerceDashboardPage {
	WebDriver driver;
	
	@FindBy(xpath = "//p[normalize-space()='Customers']//child::i")
	WebElement customersDropdown;
	
	@FindBy(xpath = "//p[normalize-space()='Customers']//preceding-sibling::i[@class='nav-icon far fa-dot-circle']")
	WebElement customersLink;
	
	@FindBy(xpath = "//a[normalize-space()='Add new']")
	WebElement addNewCustomerButton;

	public NOPCommerceDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
