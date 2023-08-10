package inverso.dmy.tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshot {
	static int counter = 0;
	
	public static void takeScreenshot(WebDriver webdriver) {
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
		
		Reporter.log("Screenshot at " + DestFile.getAbsolutePath(), true);
	}
}
