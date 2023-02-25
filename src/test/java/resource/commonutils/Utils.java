package resource.commonutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	String bearer_token = "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";
	//user: 18081992 token: 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
	String baseURI = "https://api.github.com";
	Response response;
	RequestSpecification reqSpec;
	String ownerName = "pravinsautomation";
	String repoName;
	
	public Response postRequest(String resourcePath, String payload) {
		try {
			System.out.println("resource path2: " + resourcePath);
			RestLogger.info("base URI:- "+baseURI);
			RestLogger.info("Resource Path:- "+resourcePath);
			RestLogger.info("Request Payload:- "+payload);
			reqSpec = RestAssured.given().body(payload);
			reqSpec.contentType(ContentType.JSON);
			reqSpec.header("Authorization", "Bearer " + bearer_token);
			response = reqSpec.post(baseURI + resourcePath);
			RestLogger.info("Request Response:- "+response.getBody().asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public Response deleteRequest(String resourcePath, String repoName) {
		String requestURI=baseURI+resourcePath+repoName;
		try {
			reqSpec = RestAssured.given();
			reqSpec.contentType(ContentType.JSON);
			reqSpec.header("Content-Type", "application/json");
			reqSpec.header("Authorization", "Bearer " + bearer_token);
			response = reqSpec.delete(requestURI);
			System.out.println(response.asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


}
