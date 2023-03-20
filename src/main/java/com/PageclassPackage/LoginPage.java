package com.PageclassPackage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClassPackage.Baseclass;



public class LoginPage extends Baseclass
{
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement username;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"login\"]")
	WebElement LoginBtn;
	@FindBy(xpath="//*[@id=\"register\"]")
	WebElement register;
	

	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
		logger=Logger.getLogger(LoginPage.class);  //logger for Login page
		logger.info("we are in LoginPage");
		
	}
	
	public String verifyTitle()
	{
		String title1=driver.getTitle();
		logger.info("Getting the title of landing page");
		return title1;
		
	}
	
	public boolean verifyRegister()
	{
		boolean regr=register.isDisplayed();
		return regr;
	}
	
	public LandingPage loginMethod(String use,String pass )
	{
		username.sendKeys(use);
		password.sendKeys(pass);
		LoginBtn.click();
		logger.info("Clicking on the page");
		return new LandingPage();
	}


}
