package com.jakartalabs.utils;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserActions {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();
	
	private String url;
	
	/**
	 * @param driver.get()
	 * @param explicitWait
	 */
	public BrowserActions(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	public void openUrl(String url) {
		this.url = url;
		
		driver.get().get(url);
	}
	
	public void clickElementXpath(String elementXpath) {
		WebElement elementByXpath = explicitWait.get()
				.until(ExpectedConditions.elementToBeClickable(driver.get().findElement(By.xpath(elementXpath))));
		
		elementByXpath.click();
	}

	public void clickPreseceOfElementXpath(String elementXpath) {
		WebElement elementByXpath = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		
		elementByXpath.click();
	}
	
	public void clickElementByID(String elementID) {
		WebElement elementByID = explicitWait.get()
				.until(ExpectedConditions.elementToBeClickable(driver.get().findElement(By.id(elementID))));
		
		elementByID.click();
	}

	public void clickElementByCSS(String elementCSS) {
		WebElement elementByCSS = explicitWait.get()
				.until(ExpectedConditions.elementToBeClickable(driver.get().findElement(By.cssSelector(elementCSS))));
		
		elementByCSS.click();
	}
	
	public void sendKeysToElementByXpath(String elementName, String keys) {
		WebElement elementByName = explicitWait.get()
				.until(ExpectedConditions.visibilityOf(driver.get().findElement(By.xpath(elementName))));
		
		elementByName.sendKeys(keys);
	}
	
	public void sendKeysToPreseceOfElementByXpath(String elementName, String keys) {
		WebElement elementByName = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
		
		elementByName.sendKeys(keys);
	}

	public void sendKeysToElementByID(String elementID, String keys) {
		WebElement elementByID = explicitWait.get()
				.until(ExpectedConditions.visibilityOf(driver.get().findElement(By.id(elementID))));
		
		elementByID.sendKeys(keys);
	}

	public void setKeyboardKey(String elementID, Keys key) {
		WebElement elementByID = explicitWait.get()
				.until(ExpectedConditions.visibilityOf(driver.get().findElement(By.id(elementID))));
		
		elementByID.sendKeys(key);
	}

	public String getTextOfElementByCSS(String elementCSS) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.visibilityOf(driver.get().findElement(By.cssSelector(elementCSS))));
		
		return elementInPage.getText();
	}
	
	public String getTextOfElementByXpath(String xpath) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.visibilityOf(driver.get().findElement(By.xpath(xpath))));
		
		return elementInPage.getText();
	}
	
	public void assertElementByXpath(String elementXpath, String keys, boolean isNumber) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		
		String number = isNumber ? TestUtils.extractNumberFromString(elementInPage.getText()) : elementInPage.getText();
		
		Assert.assertEquals(number, keys);
	}
	
	public void assertElementByXpath(String elementXpath, String keys) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		
		Assert.assertEquals(elementInPage.getText().toLowerCase(), keys);
	}
	
	public void assertNotElementByXpath(String elementXpath, String keys) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		
		Assert.assertNotEquals(elementInPage.getText().toLowerCase(), keys);
	}
	
	public void assertElementByCSS(String elementCSS, String keys, boolean isNumber) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
		
		String number = isNumber ? TestUtils.extractNumberFromString(elementInPage.getText()) : elementInPage.getText();
		
		Assert.assertEquals(number, keys);
	}
	
	public void assertElementByCSS(String elementCSS, String keys) {
		WebElement elementInPage = explicitWait.get()
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
		
		Assert.assertEquals(elementInPage.getText().toLowerCase(), keys);
	}

	public void performRightClick(String elementID) {
		Actions mouseAction = new Actions(driver.get());

		mouseAction.contextClick(driver.get().findElement(By.id(elementID))).perform();
	}
	
	public void performClick(String xpath) {
		Actions mouseAction = new Actions(driver.get());
		
		mouseAction.moveToElement(driver.get().findElement(By.xpath(xpath))).click().perform();
	}
	
	public void performHover(String xpath) {
		Actions mouseAction = new Actions(driver.get());
		
		mouseAction.moveToElement(driver.get().findElement(By.xpath(xpath))).perform();
	}

	public void createTab() {
		driver.get().switchTo().newWindow(WindowType.TAB);
	}

	public void createWindow() {
		driver.get().switchTo().newWindow(WindowType.WINDOW);
	}

	public void switchDriver(int index) {

		Set<String> windows = driver.get().getWindowHandles();

		ArrayList<String> windowsList = new ArrayList<String>(windows);

		driver.get().switchTo().window(windowsList.get(index));
	}

	public void executeJS(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript(script);
	}

	public void acceptAlert() {
		driver.get().switchTo().alert().accept();
	}

	public void refresh() {
		driver.get().navigate().refresh();
	}
	
	public void waitRedirect(String url) {
		explicitWait.get().until(ExpectedConditions.urlContains(url));
	}
	
	public void clicked(String xpath) {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].click();", explicitWait.get().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
	}
	
	public boolean elementExistByXpath(String xpath) {
		return driver.get().findElements(By.xpath(xpath)).size() > 0;
	}

}
