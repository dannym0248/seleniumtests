package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inverso.dmy.tools.Screenshot;

@Test
public class TestF extends TestSuper {
	public void test_draganddrop() {
		String url_webseite = "https://the-internet.herokuapp.com/drag_and_drop";
		
		ChromeOptions options = new ChromeOptions();
		
		driver = new RemoteWebDriver(url_hub, options);
		
		driver.get(url_webseite);
		
		WebElement dragA = driver.findElement(By.id("column-a"));
		WebElement dragB = driver.findElement(By.id("column-b"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dragA));
		wait.until(ExpectedConditions.visibilityOf(dragB));
		
		Actions action = new Actions(driver);
		
		Screenshot.takeScreenshot(driver);
		
		action.dragAndDrop(dragA, dragB).build().perform();
//		action.clickAndHold(dragA).moveToElement(dragB).release().build().perform();
//		action.dragAndDropBy(dragA, 0, 1000);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Screenshot.takeScreenshot(driver);
		
		driver.quit();
	}
}
