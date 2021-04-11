package com.jakartalabs.page_objects;

public class Home {
	public static final String skipTourXpath = "//button[@type='button'][normalize-space()='Skip Tour']";
	public static final String skipTourCSS = "div[class='contentholder active'] button[type='button']";
	public static final String signinButtonXpath = "//body/app[@class='eiApp']/div[@id='app-component']/div[@class='wrapper']/div/headerpart[@class='headerPart']/nav[@id='header']/div[@class='container-fluid']/div[@class='row']/div[@class='loginPanel']/ul/li/button[1]";
	public static final String loginXpath = "//strong[normalize-space()='Login']";
	public static final String usernameXpath = "//input[@placeholder='Company email']";
	public static final String passwordXpath = "//input[@placeholder='Password']";
	public static final String loginButtonXPath = "//button[@type='submit'][normalize-space()='Login']";
}
