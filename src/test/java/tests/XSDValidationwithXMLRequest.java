package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class XSDValidationwithXMLRequest {
	
	@Test
	public void testXSDValidationwithXmlSoapRequest() throws IOException {
		
		//Step1: Generate SOAP XML RequestBody using FileStream
		
				//Identify the file with its absolute location path
				File file=new File("SOAPRequest.xml");
				if (file.exists())
						System.out.println("File is present");
				
				//File Input Stream 
				FileInputStream fileinputstream= new FileInputStream(file);
				// Convert fileInputStream input to String of CharSet encoding type UTF-8 using "IOUtils"
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
				.and()
					.assertThat().body(matchesXsdInClasspath("XSD_Sample.XSD"));
		
	}

}
