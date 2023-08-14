package com.inverso.dmy.test;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class TestA extends TestSuper{

	@Test
	public void test_aufruf_google() throws Exception {
		// Url der Webseite speichern
		URL url_webseite = new URL("https://www.google.com");
		
		// Spezifikation des Browsers
		ChromeOptions options = new ChromeOptions();
		
		// Verbindung mit Hub aufbauen
		driver = new RemoteWebDriver(url_hub, options);
		// Fenster maximieren
		driver.manage().window().maximize();
		// Webseite öffnen
		driver.get(url_webseite.toString());

		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Verbindung zu hub und Test beenden
		driver.quit();
	}
}
