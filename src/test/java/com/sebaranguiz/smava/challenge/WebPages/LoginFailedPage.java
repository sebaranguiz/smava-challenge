package com.sebaranguiz.smava.challenge.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/* Page Object Model of a login process performed with invalid credentials */
public class LoginFailedPage 
{
	WebDriver driver;
	
	public LoginFailedPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	/* The following is the Web Element of the fail message displayed to the user*/
	@FindBy(how=How.XPATH, using = "//*[@id='layout-wrapper']/div[3]/div[1]/div/div/div[1]/div/ul/li")
	static	WebElement failMessage;
	
	/* By this method the fail message is passed on */
	public static String getFailMessageText() 
	{
		String failMessageText = failMessage.getText();
		return failMessageText;
	}
}
