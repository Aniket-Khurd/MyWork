package com.restassured.apis;

import static io.restassured.RestAssured.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import junit.framework.Assert;

public class JsonSchemaValidator {
	
	@BeforeMethod
	public void setup() {
		baseURI = "https://reqres.in/api";
	}
	
	@Test
	public void test_1() {
		
		
		given()
			.get("/users?page=2")
		.then()
			.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200);
	}
	
	@Test
	public void test_2() {
		
		Response response = given()
								.get("/users?page=2")
								.andReturn();
		
		System.out.println(response.asString());
		
		String responseBody = response.getBody().asString();
		RootDemo rootDemo = null;
		
		ObjectMapper objectMap = new ObjectMapper();
		try {
			rootDemo = objectMap.readValue(responseBody, RootDemo.class);
			String jsonString = objectMap.writeValueAsString(rootDemo);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			Assert.fail("Schema Validation Failed due to --> "+e);
		}
	}
}
