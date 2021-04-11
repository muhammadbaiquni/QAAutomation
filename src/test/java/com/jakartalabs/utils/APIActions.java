package com.jakartalabs.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class APIActions {
	
	public static void verifyAPIResponse(Response response) {
		System.out.println(response);
		assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"), true);
	}
	
	public static void verifyAuthToken(String authtoken) {
		assertEquals(authtoken.length() > 10, true);
	}
	
	public static void verifyJsonValue(String payload, String jsonPath, String value) {
		JsonObject jsonObject = new JsonParser().parse(payload).getAsJsonObject();
		
		String checkValue = jsonObject.get(jsonPath).getAsString();
		
		assertEquals(value.equals(checkValue), true);
	}
	
	public static void assertStringJsonResponse(Response response, String jsonPath, String value) {
		String checkValue = getResponseDataUsingJsonPath(response, jsonPath).toString();
		
		System.out.println("result:" + checkValue + " - key: " + value);
		assertEquals(value.equals(checkValue), true);
	}
	
	public static <T> T getResponseDataUsingJsonPath(Response response, String jsonPath) {
		JsonPath jPath = response.jsonPath();
		System.out.println(jsonPath + " value is:" + jPath.get(jsonPath));

		return jPath.get(jsonPath);
	}

	public static JsonObject updateJsonFieldValue(String payload, String jsonField, String value) {
		JsonObject jsonObject = new JsonParser().parse(payload).getAsJsonObject();

		jsonObject.remove(jsonField);
		jsonObject.addProperty(jsonField, value);
		return jsonObject;
	}

}
