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

public class LandingPageTest extends Baseclass 
{
   HomePage home;
   LoginPage login;
   LandingPage land;
   
 
   public LandingPageTest()
   {
	   super();
   }
   @BeforeMethod
   public void setup() throws IOException
   {
	   initialization();
	   home=new HomePage();
	   login=new LoginPage();
	   land=new LandingPage();
   }
   
   @Test
   public boolean testhome()
   {
	   boolean home2=land.VerifyHome();
	   Assert.assertTrue(true);
	return home2;
   }
   
   @Test
   public boolean testSchedule()
   {
	   boolean schedule=land.VerifySchedule();
	   Assert.assertTrue(true);
	return schedule;
   }
   
   @AfterMethod()
	public void browserclose()
	{
		driver.quit();
	}

   
   
}
