package com.restassured.apiassnmnt;

import static io.restassured.RestAssured.*;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StackExchangeApiTest {

	@BeforeMethod
	public void baseUri() {
		baseURI = "https://api.stackexchange.com";
	}
	
	@Test
	public void getBadgesId() {
		
		int generateBadgeId = ThreadLocalRandom.current().nextInt(1,500);
		System.out.println("Generated badge Id: "+generateBadgeId);
		Response response =
			given()
				.get("/2.3/badges/"+generateBadgeId+"?order=desc&sort=rank&site=stackoverflow")
				.andReturn();
			
			System.out.println(response.asString());
			
			response.then()
					.statusCode(200)
					.log().status();
			
			JsonPath js = new JsonPath(response.asString());
			int badgeID = js.get("items[0].badge_id");
			System.out.println("Badge Id from Response: "+badgeID);
			Assert.assertEquals(generateBadgeId, badgeID);
	}
	
	
	
	@Test
	public void getBadgesRecipients() {
		
		Response response =
				given()
					.header("Content-Type", "application/json")
					.contentType(ContentType.JSON)
					.get("/2.3/badges/1/recipients?site=stackoverflow")
					.andReturn();
				
				System.out.println(response.asString());
				
				response.then()
						.statusCode(200)
						.log().status();
	}
	
	@Test
	public void getBadgesTags() {
		
		Response response =
				given()
					.header("Content-Type", "application/json")
					.contentType(ContentType.JSON)
					.get("/2.3/badges/tags?order=desc&sort=rank&inname=java&site=stackoverflow")
					.andReturn();
				
				System.out.println(response.asString());
				
				response.then()
						.statusCode(200)
						.log().status();
				Assert.assertTrue(response.asString().contains("java"));
	}
	
	@Test
	public void getBadges() {
		
		
		Response response =
			given()
				.get("/2.3/badges?site=stackoverflow&max=gold")
				.andReturn();
			
			System.out.println(response.asString());
			
			
			response.then()
					.statusCode(200)
					.log().status();
			JsonPath js = new JsonPath(response.asString());
			int count = js.get("items.size()");
			for(int i=0; i<count; i++) {
				String value = null;
				value = js.get("items["+i+"].rank");
				Assert.assertTrue(value.equals("gold"));
			}
	}
	
	
}
