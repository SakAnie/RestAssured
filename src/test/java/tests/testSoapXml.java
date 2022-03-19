package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class testSoapXml {
	
	
	@Test
	public void SOAPXMLRequest() throws IOException {
		
		//Step1: Generate SOAP XML RequestBody uisng FileStream
		
		//Identify the file with its location
		File file=new File("SOAPRequest.xml");
		if (file.exists())
				System.out.println("File is present");
		
		//File Input Stream 
		FileInputStream fileinputstream= new FileInputStream(file);
		//convert fileInputStream input to String of charset encoding type UTF-8 using "IOUtils"
		String requestBody=IOUtils.toString(fileinputstream, "UTF-8");
		
		
		//Step2:Automate the POST SOAP Request and assert the response
		baseURI="http://www.dneonline.com";
		
	
		given()
			.auth().none()
			.contentType(ContentType.XML)
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(415)
			.log().all();
			
			
	}

}
