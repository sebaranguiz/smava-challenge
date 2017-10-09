package com.sebaranguiz.smava.challenge.WebPages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/* Page Object Model of smava Homepage. The necessary elements for loan selection and 
 * login process are included for performing this assignment */
public class HomePage {

	WebDriver driver;
	
	/* Numerical values of user's loan selection */
	int amount;
	int duration;
	int usage;
	/* This array collects the parameters of user's loan selection */
	static ArrayList<Object> loanSelection;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	/* By this method the parameters for performing a loan selection are received and 
	 * used to perform a loan comparison */
	public void loanSelection(int amount, int duration, String usageStr)
	{
		ArrayList<Object> loanSelection = new ArrayList<Object>();
		this.amount = amount;
		/* It includes the amount selected by the user on the array */
		loanSelection.add(amount);
		this.duration = duration;
		/* It includes the duration selected by the user on the array */
		loanSelection.add(duration);
		/* Only the parameter "Wohnen" was considered for this assignment but the 
		 * other options could be included on 'else if' statements */
		if (usageStr == "Wohnen") {this.usage = 886;}
		/* It includes the kind of usage selected by the user on the array */
		loanSelection.add(usageStr);
		/* It stores the parameters collected in the main array */
		HomePage.loanSelection = loanSelection;
		
	/* Selection of loan's amount */
	WebElement amountSelector = driver.findElement(By.xpath("//*[@id='myselect']/div/div[2]/div[@data-value='"+amount+"']"));
	/* It seems that the Web Elements for loan's parameters selection are 'ElementNotInteractable'. 
	 * Then, for selecting the WebElement the scripts below are executed */
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", amountSelector);

	/* Selection of loan's duration */
	WebElement durationSelector = driver.findElement(By.xpath("//*[@id='myselect2']/div/div[2]/div[@data-value='"+duration+"']"));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", durationSelector); 

	/* Selection of loan's usage */
	WebElement usageSelector = driver.findElement(By.xpath("//*[@id='myselect3']/div/div[2]/div[@data-value='"+usage+"']"));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", usageSelector);

	/* Click on the 'Jetzt vergleichen' button */
	WebElement forwardButton = driver.findElement(By.id("loanSelectionForward"));
	forwardButton.click();
	}

	/* By this method an Array with the user's selected parameters is passed on */
	public static ArrayList<Object> getLoanSelection()
	{ 
		return loanSelection;
	}

	/* From this section the Web Elements involved in the login process are included.
	 Below is the link to access the login form */
	@FindBy(how=How.LINK_TEXT, using = "Anmelden")
	WebElement anmeldenLink;

	/* Username field of login form */
	@FindBy(how=How.ID, using = "signonForm.email")
	WebElement loginUserField;

	/* Password field of login form */
	@FindBy(how=How.ID, using = "signonForm.password")
	WebElement loginPassField;

	/* Button of login form */
	@FindBy(how=How.XPATH, using = "//button[@type='submit']")
	WebElement anmeldenButton;

	/* This method receives the credentials and performs the login process */
	public void loginProcess(String username, String password) {
		anmeldenLink.click();
		loginUserField.sendKeys(username);
		loginPassField.sendKeys(password);
		anmeldenButton.click();
	}
}