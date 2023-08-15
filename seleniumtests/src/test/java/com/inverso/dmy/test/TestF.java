package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class TestF extends TestSuper {
	
	/*
	 * Dieser Test soll zwei Element per Drag and Drop austauschen.
	 * Funktioniert bisher nicht. (15.8.2023)
	 */
	@Test
	public void test_draganddrop() {
		// Adresse der Webseite für Drag And Drop Test
		String url_webseite = "https://the-internet.herokuapp.com/drag_and_drop";
		
		// Browser festlegen
		ChromeOptions options = new ChromeOptions();
		
		// Verbindung zu Selenium Grid aufbauen
		driver = new RemoteWebDriver(url_hub, options);
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Elemente, die verschoben werden soll, finden
		WebElement dragA = driver.findElement(By.id("column-a"));
		WebElement dragB = driver.findElement(By.id("column-b"));
		
		// warten, dass Element wirklich geladen sind
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dragA));
		wait.until(ExpectedConditions.visibilityOf(dragB));
		
		// Actionchain erstellen für Drag and Drop
		Actions action = new Actions(driver);
		
		// Screenshot "vorher" - Zustand
		Screenshot.takeScreenshot(driver);
		
		// Verschiebe die Elemente
		dragA.click();
		action.dragAndDrop(dragA, dragB).build().perform();
//		action.clickAndHold(dragA).moveToElement(dragB).release().build().perform();
//		action.dragAndDropBy(dragA, 0, 1000);
		
		// Screenshot "nachher" - Zustand
		Screenshot.takeScreenshot(driver);
		
		// Test beenden
		driver.quit();
	}
}
