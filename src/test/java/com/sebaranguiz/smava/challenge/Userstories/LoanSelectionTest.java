package com.sebaranguiz.smava.challenge.Userstories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.sebaranguiz.smava.challenge.Utility.BrowserLauncher;
import com.sebaranguiz.smava.challenge.WebPages.HomePage;
import com.sebaranguiz.smava.challenge.WebPages.LoanSelectionResultPage;

	public class LoanSelectionTest {

	/* smava Homepage URL */
	String baseUrl = "https://www.smava.de";
	/* It launches Firefox from the BrowserLauncher class in the Utility package */
	WebDriver driver = BrowserLauncher.startFirefox(baseUrl);
	
	/* By this Test loan parameters are selected by the user who is taken to the result page.
	 * An assertion is performed to verify if the parameters selected by the user on the
	 * Homepage are the same that are displayed on the result page */
	@Test
	public void loanSelectionTest() throws Exception 
	{
		/* Enter loan parameters to be tested */
		int amount = 2750;
		int duration = 24;
		String usageStr = "Wohnen"; // Only this option was considered for this assignment

		/* It instantiates page objects from HomePage class by using Page Factory */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		/* It passes the parameters for loan selection and the 'Jetzt vergleichen' button 
		 * is clicked on */
		homePage.loanSelection(amount, duration, usageStr);

		/* It instantiates page objects from LoanSelectionResultPage class by using Page Factory */
		PageFactory.initElements(driver, LoanSelectionResultPage.class);

		/* The values from the result page are assigned to the variable below */
		ArrayList<Object> resultPageText = LoanSelectionResultPage.getResultPageSelection();

		/* Assertion for comparing loan parameters selected by the user on:
		 * the Homepage versus the results showed on the result page */
		ArrayList<Object> loanSelection = HomePage.getLoanSelection();
		assertThat(loanSelection, equalTo(resultPageText));
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000); // It gives 5 seconds to allow the tester to visualize result page
		driver.quit();	// The Firefox driver is closed
	}
}