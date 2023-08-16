package com.inverso.dmy.test;

import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class OpenGoogle extends TestSuper {

	@Test
	public void test_method()  {
		// Url der Webseite speichern
		String url_webseite = "https://www.google.com";
		
		// Webseite öffnen
		driver.get(url_webseite);

		// Screenshot machen
		Screenshot.takeScreenshot(driver, null);
		
		// Verbindung zu hub und Test beenden
		driver.quit();
	}
}
