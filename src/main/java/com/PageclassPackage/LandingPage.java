package com.PageclassPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClassPackage.Baseclass;

public class LandingPage extends Baseclass
{
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
	WebElement home;
	
     @FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement schedule;
     @FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[3]/a")
	WebElement demo;
     @FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[4]/a")
	WebElement resourses;
     
     public LandingPage()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public boolean VerifyHome()
     {
    	 boolean home1=home.isDisplayed();
    	 return home1;
     }
     public boolean VerifySchedule()
     {
    	 boolean schedule1=schedule.isDisplayed();
    	 return schedule1;
     }
     public boolean verifyDemo()
     {
    	 boolean demo1=demo.isDisplayed();
    	 return demo1;
     }
}
