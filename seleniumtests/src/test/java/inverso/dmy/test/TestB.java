package inverso.dmy.test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import inverso.dmy.tools.Screenshot;

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
		
		// Textfelder für Eingabe der Anmeldungsdaten und Bestätigungsschaltfläche suchen
		WebElement username_field = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement password_field = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		// Fehler provozieren
		WebElement abc = driver.findElement(By.xpath("//*sghuidvndjkvnuildhbldjkbngin-button\"]"));
		
		// Anmeldungsdaten eingeben und bestätigen
		username_field.sendKeys("standard_user");
		password_field.sendKeys("secret_sauce");
		login_button.submit();
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver);
		
		// Herausfinden, ob Anmeldung erfolgreich war
		
		// 5 Sekunden warten
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.quit();
		}
		
		// Browser schließen, Verbindung zu Hub beenden
		driver.quit();
	}
}
