package com.acquis.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import JsonFiles.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CRUDClass {
	
	
	/* @Author - Vaishali Patil
	 * @Assigment - Acquis
	 * 
	 */
	
    // To get the users from page 2
	@Test(priority = 1)
	public void TC_getUsers() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().queryParam("page", "2").when().get("/api/users").then().assertThat()
				.statusCode(200).header("Server", "cloudflare").extract().response().asString();

		// JsonPath js1 = new JsonPath(response);
		// String actualAddress = js1.getString("email");
		System.out.println(response);

	}

	// In this method created new user and payload Json data getting from other class which is Payload
	@Test(priority = 2)
	public void TC_postUsers() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().header("Content-Type", "application/json").body(Payload.create()).when()
				.post("/api/users").then().assertThat().statusCode(201).header("Server", "cloudflare")// validating
																										// record
				.extract().response().asString();

		JsonPath js = new JsonPath(response); // for parsing Json
		String Id = js.getString("id");
		System.out.println(response);

	}

	// In this method updating the record
	@Test(priority = 3)
	public void TC_putUsers() {
		RestAssured.baseURI = "https://reqres.in";

		String response = given().log().all().header("Content-Type", "application/json").queryParam("id", 2)
				.body(Payload.update()).when().put("/api/users").then().assertThat().statusCode(200)
				.header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}

	@Test(priority = 4) // to delete the updated values
	public void deleteUser() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().header("Content-Type", "application/json").when().delete("/api/users/2")
				.then().assertThat().statusCode(204).header("Server", "cloudflare").extract().response().asString();
		System.out.println(response);

	}

}
