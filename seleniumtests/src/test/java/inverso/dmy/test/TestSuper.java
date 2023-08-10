package inverso.dmy.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import inverso.dmy.tools.Screenshot;

public class TestSuper {
	protected URL url_hub;
	protected WebDriver driver;
	protected long id_thread;
	
	@BeforeTest
	@Parameters ({"urlHub"})
	public void test_vorbereitung(String urlHub) throws MalformedURLException {
		url_hub = new URL(urlHub);
	}
	
	@AfterMethod
	public void failure_setup(ITestResult result) throws Exception {
		/*
		 * Falls ein Fehler beim Testen aufgetreten ist, dann - Ausgabe auf
		 * Kommandozeile - und mache Screenshot des Browsers
		 */
		if (result.getStatus() == 2) {
			System.err.println("Es ist etwas schief gelaufen. (" + id_thread + ")");

			// Screenshot machen und speichern (neu)
			Screenshot.takeScreenshot(driver);

			// Verbinung zu Hub beenden, Testende
			driver.quit();
		}
	}
}
