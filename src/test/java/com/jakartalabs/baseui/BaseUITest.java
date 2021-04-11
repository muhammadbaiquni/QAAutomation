package com.jakartalabs.baseui;

import java.io.*;
import java.net.*;
import java.util.*;
import java.time.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.jakartalabs.utils.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.jakartalabs.fullstack_answer.*;

public class BaseUITest implements IDriverManager {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();
	
	protected BrowserActions browserActions;
	
	@Override
	@BeforeSuite
	public void setupSystemUnderTest() {
		WebDriverManager.chromedriver().setup();
		
//		Map<String, String> mobileProps = new HashMap<String, String>();
//		mobileProps.put("deviceName", "iPhone X");
		
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
//		chromeOptions.setExperimentalOption("mobileEmulation", mobileProps);
		

//		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver(chromeOptions));
		driver.get().manage().window().maximize();
		
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofMinutes(1)));
		
		browserActions = new BrowserActions(driver, explicitWait);
		browserActions.openUrl("https://staging.engineer.ai");
	}
	
	@Override
	@AfterSuite(alwaysRun = true)
	public void cleanup(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			if(driver instanceof TakesScreenshot) {
				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
				try {
					File screenshot = new File(System.getProperty("user.dir") + File.separator + result.getName() + ".png");
					FileUtils.copyFile(screenshotFile, screenshot);
					
					System.err.println("Screenshot save to: " + screenshot.getCanonicalPath());
				}
				catch (IOException e) {
					throw new Error(e);
				}
			}
			else {
				System.err.println("Cannot take screenshoot");
			}
		}
		
		driver.get().quit();
	}
}
