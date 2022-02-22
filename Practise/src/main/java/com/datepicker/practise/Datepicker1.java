package com.datepicker.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker1 {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		selectDate("3", "February", "2021");
	}

	public static void selectDate(String selectDate, String selectMonth, String selectYear) {
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearValue);

		String month = monthYearValue.split(" ")[0].trim();
		System.out.println(month);
		String year = monthYearValue.split(" ")[1].trim();
		System.out.println(year);

		if (selectMonth.equals("February") && Integer.parseInt(selectDate) > 29) {
			System.out.println("wrong date: " + selectMonth + ":" + selectDate);
			return;
		}

		if (Integer.parseInt(selectDate) > 31) {
			System.out.println("wrong date: " + selectMonth + ":" + selectDate);
			return;
		}

		if ((Integer.parseInt(year) <= Integer.parseInt(selectYear))) {
			while (!(month.equals(selectMonth) && year.equals(selectYear))) {

				driver.findElement(By.xpath("//a[@title='Next']")).click();
				monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
				System.out.println(monthYearValue);
				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			}
		} else if ((Integer.parseInt(year) >= Integer.parseInt(selectYear))) {
			while (!(month.equals(selectMonth) && year.equals(selectYear))) {

				driver.findElement(By.xpath("//a[@title='Prev']")).click();
				monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();
				System.out.println(monthYearValue);
				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			}
		}

		driver.findElement(By.xpath("//a[text()='" + selectDate + "']")).click();
	}
}
