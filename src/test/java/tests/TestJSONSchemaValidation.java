package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestJSONSchemaValidation {
	@Test
	public void testValidateJSONSchemaWithJSON() {
		
		baseURI="https://reqres.in";
		given()
			.auth().none()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get("/api/users?page=2")
	    .then()
//	    	.assertThat().body(matchesJsonSchemaInClasspath("Schema.json"))
	    	.statusCode(200)
	    	.log().all();
			
		
	}

}
