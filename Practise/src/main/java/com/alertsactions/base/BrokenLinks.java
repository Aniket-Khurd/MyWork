package com.alertsactions.base;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	static int brokenLinkCount = 0;

	public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.get("http://demo.guru99.com/test/newtours/");
		driver.get("https://www.amazon.com");
		int count=0;
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int numberOfLinks = links.size();
		System.out.println(numberOfLinks);
		for(WebElement element: links) {
			String url = element.getAttribute("href");
			count++;
			
			//System.out.println("Link url: "+url);
			try {
				checkBrokenLinks(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occured: "+e.getMessage());
//				e.printStackTrace();
			}
		}
		System.out.println(count);
		System.out.println("Total broken links count: "+brokenLinkCount );

	}
	
	public static void checkBrokenLinks(String url) throws Exception {
		URL link = new URL(url);
		
		
		HttpURLConnection urlConnect = (HttpURLConnection) link.openConnection();
		urlConnect.setConnectTimeout(5000);
		urlConnect.connect();
		
		if(urlConnect.getResponseCode()>=400) {
			System.out.println(url+"--> "+urlConnect.getResponseMessage()+" -->"+" is a broken");
			brokenLinkCount++;
		}
		
//		else {
//			System.out.println(url+"-->"+urlConnect.getResponseMessage());
//		}
	}

}
