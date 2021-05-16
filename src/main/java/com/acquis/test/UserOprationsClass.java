package com.acquis.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UserOprationsClass {


			// getting users from page 2
	@Test(priority = 1)
	public void TC_getUsersOfPage2() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().queryParam("page", "2").when().get("/api/users").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
	// getting specific user
	@Test(priority = 2)
	public void TC_getSpecificUser() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().queryParam("id", "2").when().get("/api/users").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
// getting single user who is not present 
	@Test(priority = 3)
	public void TC_getSingleNoUser() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().queryParam("id", "23").when().get("/api/users").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
	//to get unknown users
	@Test(priority = 4)
	public void TC_getUnknownUsers() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().when().get("/api/unknown").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
	//to get specific unknown user
	@Test(priority = 5)
	public void TC_getUnknownSpecificUser() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().when().get("/api/unknown/2").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
	
// trying to get user who is not present
	@Test(priority = 6)
	public void TC_getUnknownNoUser() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().when().get("/api/unknown/23").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}
	
	}


