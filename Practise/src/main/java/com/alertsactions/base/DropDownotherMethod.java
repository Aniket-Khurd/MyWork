package com.alertsactions.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownotherMethod {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));

		Select sel = new Select(country);

//		boolean flag=sel.isMultiple();
//		System.out.println(flag);

		List<WebElement> allcountries=sel.getOptions();

		int sizeofcountry = allcountries.size();
		System.out.println("Total no of Countries: "+sizeofcountry);

		for(WebElement c:allcountries){
			System.out.println(c.getText());
		}

		for(WebElement c:allcountries){
			if(c.getText().equalsIgnoreCase("netherlands")){
				c.click();
				break;

			}
		}
	}

}

