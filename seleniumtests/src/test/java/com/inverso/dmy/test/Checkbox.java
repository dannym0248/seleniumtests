package com.inverso.dmy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class Checkbox extends TestSuper {
	
	/*
	 * Dieser Test soll prüfen, ob auf einer Webseite
	 * Checkboxen ausgewählt sind. Wenn ausgewählt, dann 
	 * nichts tun. Ansonsten auswählen.
	 */
	@Test
	public void test_method() {
		// Adresse der Webseite mit Checkboxen
		String url_webseite = "https://the-internet.herokuapp.com/checkboxes";
		
		// Webseite öffnen
		driver.get(url_webseite);		
		
		// Elemente, die Checkboxen sind, finden
		// Initialisierung nicht nötig, da, wenn Elemente nicht gefunden werden,
		// Programm abgebrochen wird
		WebElement checkbox1 = null;
		WebElement checkbox2 = null;
		try {
			checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		} catch (NoSuchElementException e) {
			String fehlermeldung = "Mindestens eine Checkbox konnte nicht gefunden werden!";
			Reporter.log(fehlermeldung, true);
			Assert.fail(fehlermeldung);
		}
		
		// Screenshot "vorher"-zustand
		Screenshot.takeScreenshot(driver, "//*[@id=\"checkboxes\"]/input[1]");
		
		// wenn checkbox 1 nicht ausgewählt, dann auswählen
		if (!checkbox1.isSelected()) {
			checkbox1.click();
		}
		
		// Screenshot erster "nachher" - zustand
		Screenshot.takeScreenshot(driver, "//*[@id=\"checkboxes\"]/input[2]");
		
		// wenn checkbox 2 nicht ausgewählt, dann auswählen
		if (!checkbox2.isSelected()) {
			checkbox2.click();
		}
		
		// Screenshot zweiter "nachher" - Zustand
		Screenshot.takeScreenshot(driver, null);
		
		// Test beenden
		driver.quit();
	}
}