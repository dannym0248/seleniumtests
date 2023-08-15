package com.inverso.dmy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class TestE extends TestSuper {
	
	/*
	 * Dieser Test soll prüfen, ob auf einer Webseite
	 * Checkboxen ausgewählt sind. Wenn ausgewählt, dann 
	 * nichts tun. Ansonsten auswählen.
	 */
	@Test
	public void test_checkbox() {
		// Adresse der Webseite mit Checkboxen
		String url_webseite = "https://the-internet.herokuapp.com/checkboxes";
		
		// Browser wählen
		ChromeOptions options = new ChromeOptions();
		
		// Verbindung zu Selenium Grid aufbauen
		driver = new RemoteWebDriver(url_hub, options);
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Elemente, die Checkboxen sind, finden
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		
		// Screenshot "vorher"-zustand
		Screenshot.takeScreenshot(driver);
		
		// wenn checkbox 1 nicht ausgewählt, dann auswählen
		if (!checkbox1.isSelected()) {
			checkbox1.click();
		}
		
		// Screenshot erster "nachher" - zustand
		Screenshot.takeScreenshot(driver);
		
		// wenn checkbox 2 nicht ausgewählt, dann auswählen
		if (!checkbox2.isSelected()) {
			checkbox2.click();
		}
		
		// Screenshot zweiter "nachher" - Zustand
		Screenshot.takeScreenshot(driver);
		
		// Test beenden
		driver.quit();
	}
}