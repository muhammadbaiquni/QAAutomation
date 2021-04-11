package com.jakartalabs.fullstack_answer;

import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import com.jakartalabs.baseapi.*;
import com.jakartalabs.utils.APIActions;
import com.jakartalabs.utils.TestUtils;


public class TestAPI extends BaseAPITest {
	
	String authtoken = "token not found";
	String currency = "2";
	
	User user;
	
	public TestAPI() {
		user = new User();
		user.setName("test");
		user.setEmail(TestUtils.getUniqueEmail("baiqq.com"));
		user.setPassword("123456789");
		user.setPhone("+62-1234567");
		user.setUserType("User");
		user.setOrganization("");
	}
	
	
	@Test(priority = 1)
	public void testRegisterAPI() {
//		String registerPayload = "{\"user\":{\"first_name\":\"Test\",\"last_name\":\"\",\"email\":\"test5@baiqq.com\",\"password\":\"test123\",\"phone_number\":\"+62-81260012345\",\"user_type\":\"User\",\"organisation\":\"\"}}";
		
		String registerPayload = user.toString();
		
		Response registerResponse = RestAssured.given().spec(commonRequestSpec).body(registerPayload).when().
				post(APIEndpoints.registerAPI);
		
		APIActions.verifyAPIResponse(registerResponse);
		
		authtoken = APIActions.getResponseDataUsingJsonPath(registerResponse, JsonPaths.authToken);
		
		APIActions.verifyAuthToken(authtoken);
		APIActions.assertStringJsonResponse(registerResponse, JsonPaths.email, user.getEmail());
	}
	
	@Test(priority = 2)
	public void testChangeCurrencyAPI() {
		Response changeCurrencyResponse = RestAssured.given().spec(formRequestSpec).formParam("user[currency_id]", this.currency).header("authtoken", authtoken).when().
				put(APIEndpoints.changeCurrencyAPI);
		
		APIActions.verifyAPIResponse(changeCurrencyResponse);
		APIActions.assertStringJsonResponse(changeCurrencyResponse, JsonPaths.currency, this.currency);
		
		String currencyId = APIActions.getResponseDataUsingJsonPath(changeCurrencyResponse, JsonPaths.currency);
		assertEquals(currencyId, "2");
	}
	
	@Test(priority = 3)
	public void testCheckProfileAPI() {
		Response checkProfileResponse = RestAssured.given().spec(commonRequestSpec).header("authtoken", authtoken).when()
				.get(APIEndpoints.profileAPI);
		
		APIActions.verifyAPIResponse(checkProfileResponse);
		APIActions.assertStringJsonResponse(checkProfileResponse, JsonPaths.profileEmail, user.getEmail());
	}
	
	@Test(priority = 4)
	public void testLogoutAPI() {
		Response logoutResponse = RestAssured.given().spec(commonRequestSpec).queryParam("authtoken", authtoken).when().
				delete(APIEndpoints.LogoutAPI);
		
		APIActions.verifyAPIResponse(logoutResponse);
		
		String logoutMessage = APIActions.getResponseDataUsingJsonPath(logoutResponse, JsonPaths.logout);
		
		assertEquals(logoutMessage.contains("Logged out successfully"), true);
	}
	
}
