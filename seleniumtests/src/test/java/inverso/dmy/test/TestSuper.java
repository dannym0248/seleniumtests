package inverso.dmy.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import inverso.dmy.tools.Screenshot;

// Von dieser Klasse werden alle Test-Klassen erben
// vor jedem Test soll bspw. das Hub verbunden werden
// nach jedem Test soll untersucht werden, ob es Fehler gab
// und es soll der Report erstellt werden
public class TestSuper {
	protected URL url_hub;
	protected WebDriver driver;
	protected long id_thread;
	
	// Alles was vor einem Test gemacht werden soll
	@BeforeTest
	@Parameters ({"urlHub"})
	public void test_vorbereitung(String urlHub) throws MalformedURLException {
		url_hub = new URL(urlHub);
		id_thread = Thread.currentThread().getId();
	}
	
	// Alles was nach einem Test gemacht werden soll
	// Untersuchen ob Fehler
	@AfterMethod
	public void failure_setup(ITestResult result) throws Exception {
		Reporter.setCurrentTestResult(result);
		/*
		 * Falls ein Fehler beim Testen aufgetreten ist, dann - Ausgabe auf
		 * Kommandozeile - und mache Screenshot des Browsers
		 */
		if (result.getStatus() == 2) {
			System.err.println("Es ist etwas schief gelaufen. (" + id_thread + ")");

			// Screenshot machen und speichern
			String img_path = Screenshot.takeScreenshot(driver);
			
			// Screenshot auf Reporter-Webseite speichern
			Reporter.log(" <a href='" + img_path + "'> <img src='" + img_path
			+ "'height='700' width='900'/> </a>");

			// Verbinung zu Hub beenden, Testende
			driver.quit();
		}
	}
}
