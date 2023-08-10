package inverso.dmy.test;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import inverso.dmy.tools.SeleniumTools;

public class TestA {
	
	@Test
	public void test_aufruf_google() throws Exception {
		URL url_webseite = new URL("https://www.google.com");
		URL url_hub = new URL("http://192.168.16.103:4444/wd/hub");
		
		ChromeOptions options = new ChromeOptions();
		
		WebDriver driver = new RemoteWebDriver(url_hub, options);
		driver.manage().window().maximize();
		driver.get(url_webseite.toString());

		File screenshot = new File(System.getProperty("user.dir") + "\\screen_01" + ".jpg");
		SeleniumTools.takeSnapShot(driver, screenshot);
		Reporter.log("Screenshot at " + screenshot.getAbsolutePath(), true);
		
		driver.quit();
	}
}
