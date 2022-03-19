import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.http.ContentType;
//import static io.restassured.matchers.RestAssuredMatchers.*;
//import static io.restassured.hamcrest.Matchers.*;
import io.restassured.response.Response;


public class TestPojo {

	// In-order to call a class from another class,
	// we need to provide values in its arguments as per the Contructor defined of
	// that class

	// in-order to call a String object, we need to pass the values as below new
	// String[] {"Java","Python"}

	public static void main(String[] args) {
		EmployeePOJO ep = new EmployeePOJO("Sakshi", "SDET", new String[] { "Java", "Python" }, "Visa Inc",
				"sakshianie2410@gmaill.com");

		// Code to fetch response of a POST method of a complex JSON
		 Response postresponse= given()
		 .auth().none()
		 .header("Content-Type","application-json")
		 .contentType(ContentType.JSON)
		 .when()
		 .body(ep).log().all()
		 .post("hhttps://reqres.in/api/users?page=2");

		// For Logging we use log().all() under then()
		/*
		 * given() .auth().none() .header("Content-Type", "application/json")
		 * .contentType(ContentType.JSON) .when() .body(ep).log().all() //logging
		 * request body .post("https://reqres.in/api/users") .then().log().all()
		 * //loggin response body all details .body("name", equalTo("Sakshi"));
		 */
		 
		 System.out.println(postresponse.getHeaders().toString());
		// Assert.assertEquals(postresponse.jsonPath().get("name"),"Sakshi");

	}

}
