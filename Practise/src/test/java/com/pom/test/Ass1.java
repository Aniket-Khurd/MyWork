package com.pom.test;





	import static io.restassured.RestAssured.baseURI;
	import static io.restassured.RestAssured.given;

	import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	//import com.api.data.Item;

	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

	public class Ass1
		{
			//Item item;

			@BeforeTest
			public void set()
				{
					baseURI = "https://api.stackexchange.com";
					//item = new Item();
				}

			@Test
			public void tagReq()
				{
					Response resp = given().get("/2.3/badges/tags?order=desc&sort=rank&inname=java&site=stackoverflow").then().log().all().extract().response();
					Assert.assertTrue(resp.asString().contains("java"));
				}

			//Badges check when max passed as gold we get only
			//Gold badge Users 
			@Test
			public void badgeChecks()
				{
					String		resp	= given().get("/2.3/badges?order=desc&max=gold&sort=rank&site=stackoverflow").then().log().all().extract().response().asString();
					JsonPath	js		= new JsonPath(resp);
					int			Count	= js.get("items.size()");
					for (int i = 0; i < Count; i++)
						{
							String value = null;
							value = js.get("items[" + i + "].rank");
							Assert.assertTrue(value.equals("gold"));
						}
				}

			@Test
			public void badgeIdsTest() //verifying same id received 
				{
					int			genratedId	= ThreadLocalRandom.current().nextInt(1, 300);
					String		resp		= given().get("/2.3/badges/" + genratedId + "?order=desc&sort=rank&site=stackoverflow").then().log().all().extract().response().asString();
					JsonPath	js			= new JsonPath(resp);
					int			id			= js.get("items[0].badge_id");
//					item.setBadge_id(id);
//					Assert.assertEquals(item.getBadge_id(), genratedId);
				}

			@Test
			public void badgeTagTest()
				{
					String		tagName	= "selenium";
					String		resp	= given().get("/2.3/badges/tags?order=desc&sort=rank&inname=" + tagName + "&site=stackoverflow").then().log().all().extract().response().asString();
					JsonPath	js		= new JsonPath(resp);

					int			Count	= js.get("items.size()");
				//	item.setName(tagName);
					for (int i = 0; i < Count; i++)
						{
							String value = null;
							value = js.get("items[" + i + "].name");
						//Assert.assertTrue("tag name : " + tagName + " not found in reponse", value.contains(item.getName()));
						}
				}

			@Test
			public void jsonSchemaValidateForAllBadges()
				{
					// read pojo classes 
					// use object mapper 
					given().get("/2.3/badges?order=desc&sort=rank&site=stackoverflow").then().log().all().and().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
				}

		}

