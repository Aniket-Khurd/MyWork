package com.restassured.apiassnmnt;

import static io.restassured.RestAssured.*;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class StackExchangeApiNegativeTest {
	
	@BeforeMethod
	public void setUp() {
		baseURI = "https://api.stackexchange.com";
	}
	
	@Test
	public void verifyResponseForInvalidBadgeId() {
		
		int generateBadgeId = ThreadLocalRandom.current().nextInt(1);
		System.out.println("Generated Badge Id: "+generateBadgeId);
		
		Response response = given()
								.get("/2.3/badges/"+generateBadgeId+"?order=desc&sort=rank&site=stackoverflow")
								.andReturn();
		
		System.out.println(response.asString());
		
		JsonPath js = new JsonPath(response.asString());
		
		String responseBody = response.getBody().asString();
		Root root = null;
		ObjectMapper objectMap = new ObjectMapper();
		
		try {
			root = objectMap.readValue(responseBody, Root.class);
			Assert.assertTrue(root.items.isEmpty());
		} catch (JsonProcessingException e) {
			System.out.println("Response is not proper: "+e);
		}
	}
	
	@Test
	public void verifyBadResponseIfSiteFieldIsNotPresentInEndPoint() {
		Response response = given()
								.get("/2.3/badges/1?order=desc&sort=rank")
								.andReturn();
		System.out.println(response.asString());
		response
				.then()
				.statusCode(400)
				.log().all();
	}
	
	@Test
	public void verifyResponseForInvalidCharacterInBadgeId() {
		
		Response response = given()
								.get("/2.3/badges/100@?order=desc&sort=rank&site=stackoverflow")
								.andReturn();
		System.out.println(response.asString());
		
		response
				.then()
				.statusCode(400)
				.log().all();
		
	}

}
