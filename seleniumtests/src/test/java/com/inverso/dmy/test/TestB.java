package com.inverso.dmy.test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;


public class TestB extends TestSuper {
	
	@Test
	public void test_anmeldung_swaglabs() throws MalformedURLException {
		// Url der Seite, an der Anmeldung getestet wird
		String url_webseite = "https://www.saucedemo.com/";
		
		// Konfiguration des Browsers
		ChromeOptions options = new ChromeOptions();
		
		// Verbindungsaufbau mit Hub
		driver = new RemoteWebDriver(url_hub, options);
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Fenster maximieren
		driver.manage().window().maximize();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Textfelder für Eingabe der Anmeldungsdaten und Bestätigungsschaltfläche suchen
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		// Anmeldungsdaten eingeben und bestätigen
		username_field.sendKeys("standard_user");
		password_field.sendKeys("secret_sauce");
		login_button.submit();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Herausfinden, ob Anmeldung erfolgreich war
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginErfolg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-burger-menu-btn\"]")));
		if (loginErfolg != null) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!" ,true);
		}
		
		// 5 Sekunden warten
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
		
		// Browser schließen, Verbindung zu Hub beenden
		driver.quit();
	}
	
	@Test
	public void test_anmeldung_orangehrm() throws MalformedURLException {
		// Url der Seite, an der Anmeldung getestet wird
		String url_webseite = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		// Konfiguration des Browsers
		ChromeOptions options = new ChromeOptions();
		
		// Verbindungsaufbau mit Hub
		driver = new RemoteWebDriver(url_hub, options);
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Fenster maximieren
		driver.manage().window().maximize();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Textfelder für Eingabe der Anmeldungsdaten und Bestätigungsschaltfläche suchen
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		WebElement login_button = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		
		// Anmeldungsdaten eingeben und bestätigen
		username_field.sendKeys("Admin");
		password_field.sendKeys("admin123");
		login_button.submit();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Herausfinden, ob Anmeldung erfolgreich war
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginErfolg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
		if (loginErfolg != null) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!" ,true);
		}
		
		// 5 Sekunden warten
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			driver.quit();
		}
		
		// Browser schließen, Verbindung zu Hub beenden
		driver.quit();
	}
}
