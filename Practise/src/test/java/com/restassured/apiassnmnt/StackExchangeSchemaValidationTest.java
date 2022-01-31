package com.restassured.apiassnmnt;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import junit.framework.AssertionFailedError;


public class StackExchangeSchemaValidationTest {
	
	@BeforeMethod
	public void setup() {
		baseURI = "https://api.stackexchange.com";
	}
	
	@Test
	public void badgesSchemaValidation() {
		
		Response response = given()
								.get("/2.3/badges?site=stackoverflow&max=gold")
								.andReturn();
		System.out.println(response.asString());
		
		int statusCode = response.getStatusCode();
		if(statusCode == 200) {
			String responseBody = response.getBody().asString();
			Root root = null;
			try {
				ObjectMapper objectmap = new ObjectMapper();
				root = objectmap.readValue(responseBody, Root.class);
				String jsonString = objectmap.writeValueAsString(root);
				System.out.println(jsonString);
			} catch (JsonProcessingException e) {
				Assert.fail("Schma Validation Failed due to --> "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void schemaValidationPass() {
		
		Root root = given()
						.get("/2.3/badges?site=stackoverflow&max=gold")
						.as(Root.class);
		
		
	}
	
	@Test
	public void schemaValidationFail() {
		
		Item item = given()
						.get("/2.3/badges?site=stackoverflow&max=gold")
						.as(Item.class);
		
		
	}
	
	@Test
	public void accessValuesusingPojo() {
		
		Root root = given()
						.get("/2.3/badges?site=stackoverflow&max=gold")
						.as(Root.class);
		
		System.out.println(root.getQuota_max());
	}
	
	@Test
	public void partOfJsonObject() {
		Item[] item = given()
						.get("/2.3/badges?site=stackoverflow&max=gold")
						.jsonPath()
						.getObject("items", Item[].class);
		System.out.println(item.length);
		System.out.println(item[0].getName());
	}
}
