package com.restassured.apis;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_POST {
	
	@Test
	public void test_1() {

		
		JsonObject request = new JsonObject();
		
		request.addProperty("name", "Matt");
		request.addProperty("job", "Manager");
		
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)//201- status code for create
			.log().all();
	}
	
	@Test
	public void test_1_register() {

		
		JsonObject request = new JsonObject();
		
		request.addProperty("email", "eve.holt@reqres.in");
		request.addProperty("password", "pistol");
		
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("https://reqres.in/api/register")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_1_register_fail() {

		
		JsonObject request = new JsonObject();
		
		request.addProperty("email", "sydney@fife");
		//request.put("password", "pistol");
		
		System.out.println(request);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("https://reqres.in/api/register")
		.then()
			.statusCode(400)
			.log().all();
	}

}
