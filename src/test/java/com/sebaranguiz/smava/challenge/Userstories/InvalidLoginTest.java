package com.sebaranguiz.smava.challenge.Userstories;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;

import com.sebaranguiz.smava.challenge.Utility.BrowserLauncher;
import com.sebaranguiz.smava.challenge.WebPages.HomePage;
import com.sebaranguiz.smava.challenge.WebPages.LoginFailedPage;

public class InvalidLoginTest 
{
	/* smava Homepage URL */
	String baseUrl = "https://www.smava.de";
	/* It launches Firefox from the BrowserLauncher class in the Utility package */
	WebDriver driver = BrowserLauncher.startFirefox(baseUrl);

	/* By this Test a login process is performed with invalid credentials */
	@Test
	public void InvalidDataLoginTest() 
	{
		/* Change these variables to check desired invalid credentials */
		String username = "sebastian.aranguiz@smava.de";
		String password = "selenium";

		/* It instantiates page objects from HomePage class by using Page Factory */
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);

		/* It executes the login process: clicking Anmelden button, filling up the login 
		 * form and submitting the credentials */
		homepage.loginProcess(username, password);
		
		/* As the credentials were invalid, login process should not be successful and 
		 * user should be forwarded to the LoginFailedPage. 
		 * Then, page objects from this class are instantiated to perform verification */
		PageFactory.initElements(driver, LoginFailedPage.class);

		/* It gets the fail message presented to the user after submitting invalid credentials */
		String failMessageText = LoginFailedPage.getFailMessageText();

		/* It verifies if the expected fail message below is showed to the user */
		String expectedMessage = "Ihre Angaben zum Einloggen sind ungültig";
		assertThat(failMessageText, CoreMatchers.containsString(expectedMessage));
	}
	
	@After
	public void tearDown() throws Exception 
	{
		Thread.sleep(5000); // It gives 5 seconds to allow the tester to visualize result page
		driver.quit();	// The Firefox driver is closed
	}
}