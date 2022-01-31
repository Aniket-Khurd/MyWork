package com.restassured.apis;

import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherDetails {

	@Test(enabled = true)
	public void weatherDetails() {
		//Specify baseURI
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city"; 

		//Request object
		RequestSpecification createRequest = RestAssured.given();

		//Response Object
		Response response = createRequest.request(Method.GET,"/Pune");

		//to print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: "+responseBody);

		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);

		//status line
		String statusLine = response.getStatusLine();
		System.out.println("Stats line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Header named Content-Type
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);

		//Header named Server
		String serverType = response.header("Server");
		System.out.println("Server value: "+serverType);

		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);

		//to get all headers
		Headers allHeaders = response.getHeaders();
		for(Header header: allHeaders) {
			System.out.println("Key: "+header.getName()+" Value: "+header.getValue());
		}

		//to get json node
		JsonPath jsonpathEvaluator = response.jsonPath();

		String city = jsonpathEvaluator.get("City");
		System.out.println("City value from response: "+city);
	}

	@Test(enabled = true)
	public void queryParameter() {

		RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
		RequestSpecification request = RestAssured.given();

		Response response = request.queryParam("q", "London,UK") 
				.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
				.get("/weather");

		String jsonString = response.asString();
		System.out.println(response.getStatusCode()); 
		System.out.println(jsonString);
		Assert.assertEquals(jsonString.contains("London"), true);

	}
	
	@Test
	public void registrationPost() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		
		JsonObject requestParams = new JsonObject();
//		requestParams.put("FirstName", "Aniket");
//		requestParams.put("LastName", "Khurd");
//		requestParams.put("Username", "sampleuser1234");
//		requestParams.put("Password", "password1");
//		requestParams.put("Email", "anky@gmal.com");
//		requestParams.put("name", "Aniket");
//		requestParams.put("job", "QA Engineer");
		requestParams.addProperty("name", "Aniket");
		requestParams.addProperty("job", "QA Engineer");
		
		request.body(requestParams.toString());
		Response response = request.post("/users");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
	}

}
