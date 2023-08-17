package com.inverso.dmy.test;

import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class OpenInverso extends TestSuper {

	@Test
	public void test_method()  {
		// Url der Webseite speichern
		String url_webseite = "https://www.inverso.de/";
		
		// Webseite öffnen
		driver.get(url_webseite);

		// Screenshot machen
		Screenshot.takeScreenshot(driver, null);
		
		// Verbindung zu hub und Test beenden
		driver.quit();
	}
}
