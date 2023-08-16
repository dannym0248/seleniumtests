package com.inverso.dmy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class DropDown extends TestSuper {
	
	/*
	 * Dieser Test soll in einem Dropdown-Menü etwas auswählen.
	 * Falls das gewünschte Element nicht da ist, soll
	 * der Test abgebrochen werden.
	 */
	@Test
	public void test_method() {
		// Webseite zum Testen eines DropDown-Menüs
		String url_webseite = "https://the-internet.herokuapp.com/dropdown";
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Screenshot von Seite machen
		Screenshot.takeScreenshot(driver, "//*[@id=\"dropdown\"]");
		
		// Dropdown-Menü suchen
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
		
		// Name des Elements, das im Dropdown-Menü ausgewählt werden soll
		String dropdown_auswahl = "Option 1";
		
		// Auswahl im Dropdown-Menü tätigen
		// dabei Prüfen, ob Element gefunden wird
		// wenn Element nicht gefunden, dann Abbruch
		try {
			dropdown.selectByVisibleText(dropdown_auswahl);
		} catch (NoSuchElementException e) {
			String fehlertext = "Element '" + dropdown_auswahl + "' konnte nicht gefunden werden!";
			Reporter.log(fehlertext, true);
			Assert.fail(fehlertext);
		}
		
		// Element wurde gefunden, also Beweisfoto machen
		Screenshot.takeScreenshot(driver, null);
		
		// Test beenden
		driver.quit();
	}
}
