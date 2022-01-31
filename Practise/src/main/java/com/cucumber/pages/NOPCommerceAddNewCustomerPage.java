package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NOPCommerceAddNewCustomerPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(id = "FirstName")
	WebElement firstNameField;
	
	@FindBy(id = "LastName")
	WebElement lastNamrField;
	
	@FindBy(id = "Gender_Male")
	WebElement maleRadio;
	
	@FindBy(id = "Gender_Female")
	WebElement femaleRadio;
	
	

}
