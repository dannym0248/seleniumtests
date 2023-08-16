package com.inverso.dmy.tools;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Screenshot {
	// Zähle mit, Nummer für Screenshot
	static int counter = 0;
	
	// Screenshot von aktueller Seite machen
	// Speichern im screenshots-Ordner des Projektes
	public static String takeScreenshot(WebDriver webdriver, String xpath_to_wait_on) {
		if (xpath_to_wait_on != null) {
			// auf element warten, damit Seite vollständig geladen
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(webdriver.findElement(By.xpath(xpath_to_wait_on))));
		}
		
		// Erhöhe die Nummer der Screenshot um 1
		counter++;
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Copy file at destination
		File DestFile = new File(System.getProperty("user.dir") + "\\screenshots" + "\\screen" + counter + ".jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			Reporter.log("Fehler beim Screenshot machen.", true);
			e.printStackTrace();
		}
		
		// Protokollierung, dass ein Screenshot gemacht wurde
		// Ausgabe des Speicherortes
		Reporter.log("Screenshot at " + DestFile.getAbsolutePath(), true);
		
		return DestFile.getAbsolutePath();
	}
}
