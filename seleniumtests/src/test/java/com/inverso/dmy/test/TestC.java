package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class TestC extends TestSuper {

	@Test
	public void anmeldung_test() {
		String url_webseite = "https://the-internet.herokuapp.com/basic_auth";

		ChromeOptions options = new ChromeOptions();

		driver = new RemoteWebDriver(url_hub, options);

		driver.get(url_webseite);

		Screenshot.takeScreenshot(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean loginErfolg = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")), "Congratulations"));
		
		if (loginErfolg) {
			Reporter.log("Anmeldung erfolgreich!", true);
		} else {
			Reporter.log("Anmeldung nicht erfolgreich!", true);
		}

		driver.quit();
		//
	}
}
