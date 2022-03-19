package tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPutPatchDelete {
	
	
	
	@Test
	public void testPut(){
		baseURI="https://reqres.in/api";
		//Generate RequestBody
		JSONObject requestBody=new JSONObject();
		requestBody.put("name", "updatedNameRaj");
		requestBody.put("job","updatedJOB");
		System.out.print("\nMy request body is\n"+ requestBody.toJSONString()+"\n\n");
		
		//Code for RestAssured automation
		given()
			.body(requestBody.toJSONString())
			.headers("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void testPatch() {
		baseURI="https://reqres.in/api";
		//Generate RequestBody
		JSONObject requestBodypatch=new JSONObject();
		requestBodypatch.put("name", "updatedNameRajPatch");
		System.out.print("\nMy request body for Patch test is\n"+ requestBodypatch.toJSONString()+"\n\n");
		
		//Code for RestAssured automation-PATCH HTTP Method
		given()
			.body(requestBodypatch.toJSONString())
			.headers("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	public void testDelete() {
		baseURI="https://reqres.in/api/";
		//No need to generate requestBody here
		//No need of given() also
		//when we pass the delete(baseURI+endpoint) then() assert the status code
		
		when()
			.delete("users/2")
		.then()
			.statusCode(204)
			.log().all();
			
	}

}
