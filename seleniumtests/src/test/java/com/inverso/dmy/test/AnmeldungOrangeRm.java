package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class AnmeldungOrangeRm extends TestSuper {
	@Test
	public void test_method() {
		// Url der Seite, an der Anmeldung getestet wird
		String url_webseite = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Fenster maximieren
		driver.manage().window().maximize();
		
		// Screenshot machen
		//Screenshot.takeScreenshot(driver, "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
		
		// Textfelder für Eingabe der Anmeldungsdaten und Bestätigungsschaltfläche suchen
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		WebElement login_button = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input
		// Anmeldungsdaten eingeben und bestätigen
		username_field.sendKeys("Admin");
		password_field.sendKeys("admin123");
		login_button.submit();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver, "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
		
		// Herausfinden, ob Anmeldung erfolgreich war
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginErfolg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
		if (loginErfolg != null) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!" ,true);
		}
		
		// Browser schließen, Verbindung zu Hub beenden
		driver.quit();
	}
}
