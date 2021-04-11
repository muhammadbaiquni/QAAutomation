package com.jakartalabs.utils;

import java.util.regex.Pattern;

public class TestUtils {
	
	public static String getUniqueEmail() {
		return "testemail" + System.currentTimeMillis() + "@yomail.com";
	}
	
	public static String getUniqueEmail(String domain) {
		return "testemail" + System.currentTimeMillis() + "@" + domain;
	}
	
	public static String getUniqueTemplate() {
		return "template" + System.currentTimeMillis();
	}
	
	public static String extractNumberFromString(String str) {
		return str.replaceAll("\\D+", "");
	}

}
