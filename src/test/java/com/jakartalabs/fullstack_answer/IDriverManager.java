package com.jakartalabs.fullstack_answer;

import java.io.IOException;
import org.testng.ITestResult;

public interface IDriverManager {
	public void setupSystemUnderTest();
	public void cleanup(ITestResult result) throws IOException;
}
