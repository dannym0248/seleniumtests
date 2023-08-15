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

public class TestH extends TestSuper {
	/*
	 * Dieser Test soll auf einer Webseite malen.
	 */
	@Test
	public void test_malen() {
		// Adresse der Webseite
		String url_webseite = "https://www.tinyimage.de/";

		// Browser festlegen
		ChromeOptions options = new ChromeOptions();

		// Verbindung zu Selenium Grid aufbauen
		driver = new RemoteWebDriver(url_hub, options);

		// Webseite öffnen
		driver.get(url_webseite);

		// Leinwand suchen
		WebElement leinwand = driver.findElement(By.xpath("//*[@id=\"ti_canvas\"]"));

		// Warten, dass Leinwand vollständig geladen
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(leinwand));

		// Actionchain erstellen
		Actions action = new Actions(driver);

		// Screenshot
		Screenshot.takeScreenshot(driver);

		// Malen
		action.clickAndHold(leinwand).moveByOffset(10, 0).moveByOffset(0, 20).moveByOffset(-40, 0).moveByOffset(0, -80)
				.moveByOffset(160, 0).build().perform();

		// Screenshot
		Screenshot.takeScreenshot(driver);

		// Test beenden
		driver.quit();
	}
}
