package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;


public class AnmeldungSwagLabs extends TestSuper {
	
	@Test
	public void test_method() {
		// Url der Seite, an der Anmeldung getestet wird
		String url_webseite = "https://www.saucedemo.com/";
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Fenster maximieren
		driver.manage().window().maximize();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver, "//*[@id=\"user-name\"]");
		
		// Textfelder für Eingabe der Anmeldungsdaten und Bestätigungsschaltfläche suchen
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		// Anmeldungsdaten eingeben und bestätigen
		username_field.sendKeys("standard_user");
		password_field.sendKeys("secret_sauce");
		login_button.submit();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver, "//*[@id=\"react-burger-menu-btn\"]");
		
		// Herausfinden, ob Anmeldung erfolgreich war
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginErfolg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-burger-menu-btn\"]")));
		if (loginErfolg != null) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!" ,true);
		}
		
		// Browser schließen, Verbindung zu Hub beenden
		driver.quit();
	}
}
