package com.sebaranguiz.smava.challenge.WebPages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/* Page Object Model of the results displayed after the user selects and submits the parameters
 * of his/her desired loan */
public class LoanSelectionResultPage {
	
	WebDriver driver;
	
	public LoanSelectionResultPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	/* The next Web Elements are expected to be the parameters previously selected by the user
	 * for the loan: usage, amount and duration */
	@FindBy(how=How.XPATH, using = "//*[@id='applicant0.loan.selection.category']")
	static WebElement selectorUsage;

	@FindBy(how=How.XPATH, using = "//*[@id='applicant0.loan.selection.amount']")
	static WebElement selectorAmount;

	@FindBy(how=How.XPATH, using = "//*[@id='applicant0.loan.selection.duration']")
	static WebElement selectorDuration;

	/* By this method an Array with the loan's parameters displayed on the result page
	 *  is passed on */
	public static ArrayList<Object> getResultPageSelection()
	{
		ArrayList<Object> resultPageLoanSelection = new ArrayList<Object>();
		
		/* It gets the text from the WebElement */
		String resultAmountTextStr = (new Select(selectorAmount)).getFirstSelectedOption().getText();
		/* It removes the characters that are not numbers */
		String resultAmountTextNum = resultAmountTextStr.replaceAll("[^0-9]", "");
		/* It converts the variable to integer type */
		int resultAmountText = Integer.parseInt(resultAmountTextNum);
		/* It includes the loan's amount showed to the user on the array */
		resultPageLoanSelection.add(resultAmountText);
		
		/* It gets the text from the WebElement */
		String resultDurationTextStr = (new Select(selectorDuration)).getFirstSelectedOption().getText();
		/* It removes the characters that are not numbers */
		String resultDurationTextNum = resultDurationTextStr.replaceAll("[^0-9]", "");
		/* It converts the variable to integer type */
		int resultDurationText = Integer.parseInt(resultDurationTextNum);
		/* It includes the loan's duration showed to the user on the array */
		resultPageLoanSelection.add(resultDurationText);

		/* It gets the text from the WebElement */
		String resultUsageText = (new Select(selectorUsage)).getFirstSelectedOption().getText();		
		resultPageLoanSelection.add(resultUsageText);

		return resultPageLoanSelection;
	}
}