package com.pom.pages;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	@DataProvider()
	public Object[][] credentials(){
		return new Object[][] {
			
			{"username1","abc123"},
			{"username2","xyz456"}
			
		};
	}

}
