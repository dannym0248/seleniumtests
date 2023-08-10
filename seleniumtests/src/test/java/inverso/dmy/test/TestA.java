package inverso.dmy.test;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import inverso.dmy.tools.Screenshot;

public class TestA extends TestSuper{

	@Test
	public void test_aufruf_google() throws Exception {
		URL url_webseite = new URL("https://www.google.com");
		
		ChromeOptions options = new ChromeOptions();
		
		driver = new RemoteWebDriver(url_hub, options);
		driver.manage().window().maximize();
		driver.get(url_webseite.toString());

		Screenshot.takeScreenshot(driver);
		
		driver.quit();
	}
}
