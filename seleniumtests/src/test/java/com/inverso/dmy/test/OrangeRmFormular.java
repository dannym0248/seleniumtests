package com.inverso.dmy.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.inverso.dmy.tools.Screenshot;

public class OrangeRmFormular extends TestSuper {

	@Override
	public void test_method() {
		// Adresse der Webseite
		String url_webseite = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		// Webseite öffnen
		driver.get(url_webseite);
		
		// Eingabefelder für Name und Passwort suchen
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		WebElement pass = driver.findElement(By.name("password"));
		
		// Warten, dass gesuchte Element auch wirklich zu sehen sind
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(name));
		wait.until(ExpectedConditions.visibilityOf(pass));
		
		// Zugangsdaten eingeben
		name.sendKeys("Admin");
		pass.sendKeys("admin123");
		
		// Screenshot
		Screenshot.takeScreenshot(driver, null);
		
		// Eingabe bestätigen, Anmelden
		pass.sendKeys(Keys.ENTER);
		
		// Suche ein Element, das erst angezeigt wird,
		// wenn Anmeldung erfolgreich
		// wenn nicht erfolgreich, Fehlermeldung und Abbruch des Tests
		WebElement pim = null;
		try {
			pim = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		} catch (Exception e) {
			String fehlermeldung = "Element Dashboard konnte nicht gefunden werden. Anmeldung war nicht erfolgreich!";
			Reporter.log(fehlermeldung, true);
			e.printStackTrace();
			Assert.fail(fehlermeldung);
		}
		
		// Anmeldung war erfolgreich
		
		// Screenshot machen
		Screenshot.takeScreenshot(driver, null);
		
		// Wähle PIM aus
		// PIM gibt auf der Seite die Möglichkeit ein größeres Formular auszufüllen
		// was PIM genau ist, ist unbekannt...
		pim.click();
		
		WebElement add_pim = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		
		wait.until(ExpectedConditions.visibilityOf(add_pim));
		
		add_pim.click();
		
		WebElement first_name = driver.findElement(By.name("firstName"));
		WebElement middle_name = driver.findElement(By.name("middleName"));
		WebElement last_name = driver.findElement(By.name("lastName"));
		WebElement details = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(first_name, middle_name, last_name, details));
		
		String vorname = "Peter";
		String mittelname = "Herbert";
		String nachname = "Schmitt";
		
		first_name.sendKeys(vorname);
		middle_name.sendKeys(mittelname);
		last_name.sendKeys(nachname);
		details.click();
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
		WebElement confirm_password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
		WebElement save = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
				
		wait.until(ExpectedConditions.visibilityOfAllElements(username, password, confirm_password, save));
		
		String nutzername = "Peter";
		String passwort = "thisismypassword1";
		
		username.sendKeys(nutzername);
		password.sendKeys(passwort);
		
		save.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6"), "Personal Details"));
		
		driver.quit();
	}

}
