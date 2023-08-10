package inverso.dmy.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class TestSuper {
	URL url_hub;
	WebDriver driver;
	
	@BeforeTest
	public void test_vorbereitung() throws MalformedURLException {
		url_hub = new URL("http://192.168.16.103:4444/wd/hub");;
	}
}
