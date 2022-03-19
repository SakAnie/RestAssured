import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_Get {
	@Test
	void Test01() {
		
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode()+"\n  "+"  "+response.getBody().asString()+" \n"+response.asString());;
		int actualStatus=response.getStatusCode();
		Assert.assertEquals(actualStatus, 200);
		
	}

}
