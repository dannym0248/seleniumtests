package com.inverso.dmy.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

// Von dieser Klasse werden alle Test-Klassen erben
// vor jedem Test soll bspw. das Hub verbunden werden
// nach jedem Test soll untersucht werden, ob es Fehler gab
// und es soll der Report erstellt werden
public abstract class TestSuper {
	protected URL url_hub;
	protected WebDriver driver;
	protected long id_thread;
	protected ChromeOptions options;
	
	// Alles was vor einem Test gemacht werden soll
	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters ({"urlHub", "browserName"})
	public void test_vorbereitung(String urlHub, String browserName) throws MalformedURLException {
		url_hub = new URL(urlHub);
		id_thread = Thread.currentThread().getId();
		switch(browserName) {
		case "chrome":
			ChromeOptions chrome_options = new ChromeOptions();
			driver = new RemoteWebDriver(url_hub, chrome_options);
			break;
		case "firefox":
			FirefoxOptions firefox_options = new FirefoxOptions();
			driver = new RemoteWebDriver(url_hub, firefox_options);
			break;
		case "edge":
			EdgeOptions edge_options = new EdgeOptions();
			driver = new RemoteWebDriver(url_hub, edge_options);
			break;
		default:
			String fehlermeldung = "Unbekannter Browser: '" + browserName + "'";
			Reporter.log(fehlermeldung);
			Assert.fail(fehlermeldung);
		}
		// Fenster maximieren
		driver.manage().window().maximize();
		Reporter.log("Test mit '" + browserName + "' startet. (ThreadId: " + id_thread + ")", true);
		// Festlegen, dass auf jedes Element höchstens 30 Sekunden gewartet wird
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	abstract public void test_method();
	
	// Alles was nach einem Test gemacht werden soll
	// Untersuchen ob Fehler
	@AfterMethod
	@Parameters ("browserName")
	public void failure_setup(ITestResult result, String browserName) throws Exception {
		Reporter.setCurrentTestResult(result);
		/*
		 * Falls ein Fehler beim Testen aufgetreten ist, dann - Ausgabe auf
		 * Kommandozeile - und mache Screenshot des Browsers
		 */
		if (result.getStatus() == 2) {
			Reporter.log("Es ist etwas schief gelaufen. (" + id_thread + ")", true);

			// Screenshot machen und speichern
			String img_path = Screenshot.takeScreenshot(driver, null);
			
			// Screenshot auf Reporter-Webseite speichern
			Reporter.log(" <a href='" + img_path + "'> <img src='" + img_path
			+ "'height='700' width='900'/> </a>");

			// Verbinung zu Hub beenden, Testende
			driver.quit();
		}
		Reporter.log("Test mit '" + browserName + "' beendet. (ThreadId: " + id_thread + ")", true);
	}
}
