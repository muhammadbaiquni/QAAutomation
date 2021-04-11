package com.jakartalabs.fullstack_answer;

import static org.testng.Assert.assertEquals;

import java.util.regex.Pattern;

import org.apache.hc.core5.http.nio.AsyncDataExchangeHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.jakartalabs.baseui.BaseUITest;
import com.jakartalabs.page_objects.Dashboard;
import com.jakartalabs.page_objects.Home;
import com.jakartalabs.utils.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUI extends BaseUITest {
	
	String maxPrice;
	String templateName = TestUtils.getUniqueTemplate();
	
	@Test (priority=1)
	public void testLoginUI() throws InterruptedException {
		browserActions.waitRedirect("/welcome");
		browserActions.clickElementXpath(Home.skipTourXpath);
		
		browserActions.waitRedirect("/home");
		browserActions.clickElementXpath(Home.signinButtonXpath);
		browserActions.clickElementXpath(Home.loginXpath);
		
		browserActions.sendKeysToElementByXpath(Home.usernameXpath, "muhammad.baiquni@infolog.com.sg");
		browserActions.sendKeysToElementByXpath(Home.passwordXpath, "infolog12345!@#$%");
		browserActions.clickElementXpath(Home.loginButtonXPath);
		
		Thread.sleep(5000);
		
		browserActions.assertElementByXpath(Dashboard.helloDashboardXpath, "hello muhammad");
	}
	
	@Test (priority=2)
	public void testSelectProjectUI() throws InterruptedException {
		Thread.sleep(5000);
		browserActions.clickElementXpath(Dashboard.typeProjectXpath);
		browserActions.clickElementXpath(Dashboard.typeTemplateXpath);
		browserActions.clickElementXpath(Dashboard.getStartedXpath);
	}
	
	@Test(priority=3)
	public void testFeaturesUI() throws InterruptedException {
		browserActions.waitRedirect("/features");
		Thread.sleep(5000);
		browserActions.clickElementXpath(Dashboard.skipAfterSelectProjectXpath);
		Thread.sleep(5000);
		
		maxPrice = TestUtils.extractNumberFromString(browserActions.getTextOfElementByCSS(Dashboard.maxPriceCss));
		System.out.println(maxPrice);
		
		browserActions.clickElementXpath(Dashboard.planDeliveryButtonXpath);
	}

	@Test(priority=4)
	public void testDeliveryUI() throws InterruptedException {
		browserActions.waitRedirect("/delivery");
		Thread.sleep(5000);
		
		browserActions.assertElementByCSS(Dashboard.maxPriceCss, this.maxPrice, true);
		
		browserActions.clickElementXpath(Dashboard.doneDeliveryButtonXpath);
	}
	
	@Test(priority=5)
	public void testSaveTemplateUI() throws InterruptedException {
		browserActions.waitRedirect("/delivery");
		Thread.sleep(5000);
		
		browserActions.sendKeysToElementByXpath(Dashboard.inputTemplateNameXpath, templateName);
		browserActions.clickElementXpath(Dashboard.saveTemplateNameXpath);
		
		browserActions.waitRedirect("/build-card/");
		Thread.sleep(5000);
		
		browserActions.assertElementByCSS(Dashboard.verifyTemplateNameCss, this.templateName);
		browserActions.assertElementByXpath(Dashboard.verifyPriceXpath, this.maxPrice, true);
		
		Thread.sleep(5000);
		
		browserActions.clickElementXpath(Dashboard.userPanelCss);
		browserActions.clickElementXpath(Dashboard.goToDashboardXpath);
	}

	@Test(priority=6)
	public void testDeleteTemplateUI() throws InterruptedException {
		browserActions.waitRedirect("/dashboard");
		Thread.sleep(5000);
		
		browserActions.assertElementByXpath(Dashboard.templateNameCardXpath, this.templateName);		
		
		browserActions.clickPreseceOfElementXpath(Dashboard.burgerMenuCardXpath);
		Thread.sleep(5000);
		browserActions.clickPreseceOfElementXpath(Dashboard.deleteCardXpath);
		Thread.sleep(5000);
		browserActions.clickPreseceOfElementXpath(Dashboard.confirmDeleteXpath);
		browserActions.refresh();
		Thread.sleep(5000);
		
		if(browserActions.elementExistByXpath(Dashboard.templateNameCardXpath))
			browserActions.assertNotElementByXpath(Dashboard.templateNameCardXpath, this.templateName);
	}
	
}
