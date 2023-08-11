package inverso.dmy.tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshot {
	// Zähle mit, Nummer für Screenshot
	static int counter = 0;
	
	// Screenshot von aktueller Seite machen
	// Speichern im screenshots-Ordner des Projektes
	public static void takeScreenshot(WebDriver webdriver) {
		// 1 Sekunden warten, damit Seite vollständig geladen
		// besser wäre vllt auf ein bestimmtes Element zu warten....
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Erhöhe die Nummer der Screenshot um 1
		counter++;
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Copy file at destination
		File DestFile = new File(System.getProperty("user.dir") + "\\screenshots" + "\\screen" + counter + ".jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			Reporter.log("Fehler beim Screenshot machen.", true);
			e.printStackTrace();
		}
		
		// Protokollierung, dass ein Screenshot gemacht wurde
		// Ausgabe des Speicherortes
		Reporter.log("Screenshot at " + DestFile.getAbsolutePath(), true);
	}
}
