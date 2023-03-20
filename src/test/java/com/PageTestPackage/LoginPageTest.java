package com.PageTestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClassPackage.Baseclass;
import com.PageclassPackage.HomePage;
import com.PageclassPackage.LandingPage;
import com.PageclassPackage.LoginPage;




public class LoginPageTest extends Baseclass
{
	HomePage home;
	 LoginPage Login;
	 LandingPage Land;

	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		
		initialization();
		home=new HomePage();
		Login=new LoginPage();
		Land=new LandingPage();

		home.verifyLoginPage();	
		
	}
	@Test(priority=1)
	public void verifyLoginTitleTest()
	{
		String actual=Login.verifyTitle();
		String expected="QA/QE/SDET Training.";
		Assert.assertEquals(actual, expected);
		
		
	}
	@Test(priority=2)
	public void LoginTest()
	{
		Land=Login.loginMethod(Prop.getProperty("username"), Prop.getProperty("password"));
	}
	@AfterMethod
	public void Browserclose()
	{
		driver.quit();
		
	}
	

}
