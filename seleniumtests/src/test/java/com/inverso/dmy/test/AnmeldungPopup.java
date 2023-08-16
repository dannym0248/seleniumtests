package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class AnmeldungPopup extends TestSuper {

	@Test
	public void test_method() {
		// Url der Testseite
		// hier: Anmeldung an einem Popup-Fenster
		String url_webseite = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

		// Webseite öffnen
		driver.get(url_webseite);

		// Screenshot machen
		Screenshot.takeScreenshot(driver, "//*[@id=\"content\"]/div/p");

		// warten, ob Anmeldung erfolgreich
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginErfolg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/p")));
		
		// Prüfen, ob Anmeldung erfolgreich
		if (loginErfolg != null) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!", true);
		}

		// Test beenden
		driver.quit();
	}
}
