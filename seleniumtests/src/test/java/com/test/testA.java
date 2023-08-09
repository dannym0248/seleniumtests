package com.test;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testA {
	
	@Test
	public void test_aufruf_google() throws Exception {
		URL url_webseite = new URL("https://www.google.com");
		URL url_hub = new URL("192.168.16.121:4444");
		FirefoxOptions options = new FirefoxOptions();
		
		WebDriver driver = new RemoteWebDriver(url_hub, options);
		driver.get(url_webseite.toString());

		File screenshot = new File(System.getProperty("user.dir") + "\\screen_01" + ".jpg");
		testA.takeSnapShot(driver, screenshot);
		Reporter.log("Screenshot at " + screenshot.getAbsolutePath(), true);
		
		driver.quit();
	}
	
	/**
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 */
	public static void takeSnapShot(WebDriver webdriver, File file) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, file);
	}
}
