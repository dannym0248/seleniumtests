package com.inverso.dmy.phantomjs;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.inverso.dmy.tools.Screenshot;

public class firstTestHeadless {
	public static void main(String[] args) {
		System.setProperty("phantomja.binary.path", "C:\\Users\\danny\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		// Driver erstellen für Browser (lokal)
		Capabilities caps = new DesiredCapabilities();
		PhantomJSDriver driver = new PhantomJSDriver(caps);
		
		// Url der Webseite speichern
		String url_webseite = "https://www.google.com";
				
		// Webseite öffnen
		driver.get(url_webseite);

		// Titel der Seite ausgeben
		System.out.println("Titel der Webseite ist: " + driver.getTitle());
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver, null);
		
		// Verbindung zu hub und Test beenden
		driver.quit();
	}
}
