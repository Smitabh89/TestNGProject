package com.PageTestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClassPackage.Baseclass;
import com.ExtentReportPackage.ExtentReportNG;
import com.PageclassPackage.HomePage;
import com.PageclassPackage.LoginPage;
import com.PageclassPackage.RegisterPage;



public class HomePageTest extends Baseclass
{
	  HomePage home;
	    LoginPage login;
	    RegisterPage reg;
		public HomePageTest() throws IOException
		{
			super();
		}
		
		@BeforeMethod
		public void setup() throws IOException
		{
			initialization();
		
				home=new HomePage();
				//ExtentReportNG.getReportObject().ge
			
		}
		@Test(priority=1)
		public void testtitle()
		{
			String actual=home.VerifyTitle();
			//String expected="QA/QE/SDET Training.";
			Assert.assertEquals(actual, "Training");
			System.out.println("In the Testtitle test case");
		}
		@Test(priority=2)
		public void testLogo()
		{
			boolean logo=home.VerifyLogo();
			Assert.assertTrue(logo);
			System.out.println("In the testLogo");
			
		}
		@Test(priority=3)
		public void verifyTestStud()
		{
			boolean stud=home.verifyStud();
			Assert.assertTrue(stud);
		}
		/*@Test(priority=4)
		public void TestLoginPage() throws IOException
		{
			home.verifyLoginPage();
		}*/
		@Test(priority=4)
		public void TestRegisterPage() throws IOException
		{
			home.verifyRegisterPage();
		}
		@AfterMethod()
		public void browserclose()
		{
			driver.quit();
		}


}
