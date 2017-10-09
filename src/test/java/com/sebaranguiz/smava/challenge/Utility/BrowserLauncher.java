package com.sebaranguiz.smava.challenge.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLauncher {

	static WebDriver driver;

	public static WebDriver startFirefox(String url) {
		/* The geckodriver for Firefox Linux version (64 bits) is included on the path: 
		 * src/test/resources/drivers/linux64. In case of using a different OS please download 
		 * the suitable geckodriver version from the Selenium's Website and update the path below */
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/linux64/geckodriver"); 
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
}