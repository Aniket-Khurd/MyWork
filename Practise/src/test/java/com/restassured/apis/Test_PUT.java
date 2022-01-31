package com.restassured.apis;

 
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class Test_PUT {
	
	@Test
	public void test_put() {
		JsonObject request = new JsonObject();
		
		request.addProperty("name", "Matt");
		request.addProperty("job", "Adminstrator");
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_patch() {
		JsonObject request = new JsonObject();
		
		
		request.addProperty("name", "Mathew");
		request.addProperty("job", "Adminstrator");
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toString())
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_delete() {
		
		given()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204) //204- Status code for delete or no content
			.log().all();
	}
	
}
