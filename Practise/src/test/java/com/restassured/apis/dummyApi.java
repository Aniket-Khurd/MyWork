package com.restassured.apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class dummyApi {
	
	@Test
	public void createJsonfromPojo() {
		StudentPOJO student = new StudentPOJO();
		student.setFirstName("Thomas");
		student.setLastName("Cullen");
		student.setEmail("thomascullen@test.com");
		student.setContactNumber(987547659);
		student.setGender("male");
		
		RestAssured
			.given()
			.log()
			.all()
			.body(student)
			.when()
			.get();
	}

}
