package inverso.dmy.tools;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshot {
	static int counter = 0;
	
	public static void takeScreenshot(WebDriver webdriver, String directory) throws Exception {
		counter++;
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Copy file at destination
		File DestFile = new File(directory + "screen" + counter + ".jpg");
		FileUtils.copyFile(SrcFile, DestFile);
		
		Reporter.log("Screenshot at " + DestFile.getAbsolutePath(), true);
	}
}
