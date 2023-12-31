package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

public class Slider extends TestSuper {
	/*
	 * Bei diesem Test soll ein Slider nach rechts bewegt werden.
	 * Dazu wird einmal mit den Pfeiltasten gearbeitet.
	 * Im Anschluss wird mit der Bewegung der Maus gesteuert.
	 */
	@Test
	public void test_method() {
		// Adresse der Webseite mit dem Slider
		String url_webseite = "https://the-internet.herokuapp.com/horizontal_slider";

		// Webseite öffnen
		driver.get(url_webseite);

		// Slider finden
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));

		// warten, dass slider tatsächlich da ist, angezeigt wird
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(slider));

		// Screenshot
		Screenshot.takeScreenshot(driver, null);
		
		// Slider mit Pfeiltasten bedienen
		slider.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);
		
		// Screenshot
		Screenshot.takeScreenshot(driver, null);
		
		// Actionchain erstellen
		Actions action = new Actions(driver);
		
		// Slider mit Maus bedienen
		action.clickAndHold(slider).moveByOffset(10, 0).release(slider).build().perform();
		
		// Screenshot
		Screenshot.takeScreenshot(driver,null);
		
		// Test beenden
		driver.quit();
	}
}
