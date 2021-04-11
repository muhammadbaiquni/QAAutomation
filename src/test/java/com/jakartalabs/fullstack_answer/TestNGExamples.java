package com.jakartalabs.fullstack_answer;

import org.testng.annotations.*;

public class TestNGExamples {

	@Test(description="Says BYE", priority=2)
	public void test1() {
		System.out.println("HELLO");
	}
	
	@Test(groups= {"Smoke", "Regression"}, description="Says HELLO", priority=1)
	public void test2() {
		System.out.println("HELLO1");
	}
	
	@Test(groups= "Smoke", description="Says HELLO", priority=1)
	public void test2a() {
		System.out.println("Hello 2a");
	}
	
	@Test(groups="Smoke", description="Says HELLO", priority=1)
	public void test2b() {
		System.out.println("Hello 2b");
	}
}
