package com.PageclassPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClassPackage.Baseclass;




public class HomePage extends Baseclass 
{
	@FindBy(xpath="//*[@id=\"logo\"]")
	WebElement Wbqa;
	@FindBy(xpath="//*[@id=\"headerfblogin\"]")
	WebElement FreeStudentAcess;
	@FindBy(xpath="//*[@id=\"loginButton\"]")
	WebElement Login;
	@FindBy(xpath="//*[@id=\"wblhead\"]")
	WebElement Wbl;
	
	public HomePage() throws IOException 
	{
		
		PageFactory.initElements(driver,this);
	}

	public String VerifyTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public boolean VerifyLogo()
	{
		boolean Logo=Wbqa.isDisplayed();
		return Logo;
	}
	
	public boolean verifyStud()
	{
		boolean stu=FreeStudentAcess.isDisplayed();
		return stu;
	}
	
	public LoginPage verifyLoginPage() throws IOException
	{
		Login.click();	
		return new LoginPage();
	}


}
