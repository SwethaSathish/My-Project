package com.apitest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

public class ExampleAPI {
	
	private long petID;
	
	@BeforeClass
	public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void testAPI() {
		Response response = given().queryParam("status", "available")
				.when().get("/pet/findByStatus");
		//response.then().log().all();
		response.then().statusCode(200);
		response.then().contentType("application/json");
		System.out.println(response.asPrettyString());
		//System.out.println(response.asString());
	}
	
	@Test
	public void testPost() {
		String jsonBody = "{"
				+ "  \"id\": 0,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		
		Response response = given().body(jsonBody).header("accept", "application/json").header("Content-Type", "application/json")
				.when().post("/pet");
		System.out.println(response.asPrettyString());
		
		response.then().body("name", Matchers.equalTo("doggie")).body("status", Matchers.equalTo("available"))
			.body("category.name", Matchers.equalTo("string")).body("tags[0].name", Matchers.equalTo("string"))
			.body("photoUrls[0]", Matchers.equalTo("string"));
		
		petID = response.path("id");
		System.out.println("ID: " +petID);
		
	}
	
	@Test(dependsOnMethods = {"testPost"})
	public void testPut() {
		String jsonBody = "{"
				+ "  \"id\": "+petID+","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		
		Response response = given().body(jsonBody).header("accept", "application/json").header("Content-Type", "application/json")
				.when().put("/pet");
		System.out.println(response.asPrettyString());
		
	}
	
	@Test(dependsOnMethods={"testPut", "testGetPetByID"	})
	public void testDelete() {
		Response response = given().when().delete("/pet/"+petID);
		System.out.println(response.asPrettyString());
		response.then().statusCode(200);
		response.then().contentType("application/json");
	}
	
	@Test(dependsOnMethods={"testPost"})
	public void testGetPetByID() {
		Response response = given().when().get("/pet/"+petID);
		System.out.println(response.asPrettyString());
		response.then().statusCode(200);
		response.then().contentType("application/json");
	}
	

}


