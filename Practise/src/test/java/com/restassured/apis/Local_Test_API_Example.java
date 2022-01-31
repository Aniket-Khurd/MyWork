package com.restassured.apis;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Local_Test_API_Example {
	//npm install -g json-server -->command to install json-server
	//npx json-server --watch db.json -->command to start json-server on local machine --.run it on cmd
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.get("/avengers")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_get_params() {
		
		baseURI = "http://localhost:3000/";
		
		given()
			.params("firstName", "Tony")
			.get("/avengers")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_post() {
		
		JsonObject request = new JsonObject();
		
		request.addProperty("firstName", "Steve");
		request.addProperty("lastName", "Rogers");
		request.addProperty("knownAs", "Captain America");
		request.addProperty("workId", 3);
		
		
		baseURI = "http://localhost:3000/";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("/avengers")			
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	public void test_patch() {
		
		JsonObject request = new JsonObject();
		
		
		request.addProperty("lastName", "Robert");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.patch("/avengers/4")			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_put() {
		
		JsonObject request = new JsonObject();
		
		request.addProperty("firstName", "Thor");
		request.addProperty("lastName", "Odinson");
		request.addProperty("knownAs", "Thor");
		request.addProperty("workId", 4);
		
		
		baseURI = "http://localhost:3000/";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.put("/avengers/4")			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_post_01() {
		
		JsonObject request = new JsonObject();
		
		//request.addProperty("id", 4);
		request.addProperty("normalWork", "King");
		
		baseURI = "http://localhost:3000/";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("/work")			
		.then()
			.statusCode(201)
			.log().all();
	}

}
