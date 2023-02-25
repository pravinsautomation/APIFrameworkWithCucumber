package stepdefinition;

//import static org.testng.Assert.assertEquals;

import PojoPayloads.CreateRepoPojo;
import static org.junit.Assert.*;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resource.TestDataBuilder;
import resource.commonutils.RestLogger;
import resource.commonutils.Utils;

public class CreateRepo extends Utils {

	ObjectMapper objMapper;
	JsonPath jsonPath;

	String repositoryName;
	TestDataBuilder testData = new TestDataBuilder();
	public static String payload;
	Response response;

	@Given("create repo payload name {string} and description {string}")
	public void create_repo_payload_name_and_description(String name, String desc) throws JsonProcessingException {
		objMapper = new ObjectMapper();
		payload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(testData.createRepoPayload(name, desc));
		CreateRepoPojo repopojo = objMapper.readValue(payload, CreateRepoPojo.class);
	}

	@When("user calls Create api {string} post api call")
	public void user_calls_create_api_post_api_call(String resourcePath) {
		System.out.println("resource path1: " + resourcePath);
		response = postRequest(resourcePath, payload);
		RestLogger.info("Response IS:- " + response.getBody().asString());
	}

	@Then("API call got successful with status code {int}")
	public void api_call_got_successful_with_status_code(int status_code) {
		assertEquals(status_code, response.getStatusCode());
		// response.getStatusCode();
	}

	@Then("verify Repository {string} is created {string}")
	public void verify_repository_is_created(String key_value, String expectedRepoName) {
		jsonPath = new JsonPath(response.getBody().asString());
		String actualRepo = jsonPath.get(key_value);
		assertEquals(expectedRepoName, actualRepo);
		RestLogger.info("Actual Repo Name:- " + actualRepo);
		RestLogger.info("Expected Repo Name:- " + expectedRepoName);
	}

	@Then("verify repo {string} is {string}")
	public void verify_repo_is(String description, String actualDescription) {
		String key_value = jsonPath.get(description);
		assertEquals(key_value, actualDescription);
	}

	@Then("verify repo description is {string}")
	public void verify_repo_description_is(String expectedDescription) {
		jsonPath = new JsonPath(response.getBody().asString());
		String actualDescription = jsonPath.get("description");
		assertEquals(expectedDescription, actualDescription);
		RestLogger.info("ActualDescription:- " + actualDescription);
		RestLogger.info("ExpectedDescription:- " + expectedDescription);
	}

	@Then("user calls Create API {string} delete api call")
	public void user_calls_create_api_delete_api_call(String resourcePath) {
		repositoryName = testData.getName();
		response = deleteRequest(resourcePath, repositoryName);
		RestLogger.info("Delete request status code:- " + response.getStatusCode());
		RestLogger.info("Response IS:- " + response.getBody().asString());
	}

	@Given("starting testcase {string}")
	public void starting_testcase(String testCaseName) {
		RestLogger.initLogger();
		RestLogger.startTestCase(testCaseName);
	}

	@Then("Ending Test case")
	public void ending_test_case() {
		RestLogger.endTestCase();
	}
}
