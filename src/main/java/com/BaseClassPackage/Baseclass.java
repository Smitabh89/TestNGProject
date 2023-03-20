package com.BaseClassPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.UtilityPackage.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 
{
	public static WebDriver driver;
	public static Properties Prop;
	public static Logger logger=null;
	
	
	
 //private String name;
	public Baseclass()
	{
		try
		{
		Prop=new Properties();
		FileInputStream io=new FileInputStream("C:\\Users\\santo\\eclipse-workspace\\whitebox2\\src\\main\\java\\com\\ConfigPropertiesPackage\\Config.Properties");
	Prop.load(io);
	     }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	String log4jpath =System.getProperty("C:\\Users\\santo\\eclipse-workspace\\whitebox2\\src\\test\\resources\\Log4j\\Log4j.Properties");
        PropertyConfigurator.configure(log4jpath);
	}
	public static void initialization()
	{
		String browserName=Prop.getProperty("browser");
		//WebDriverManager.chromedriver().setup();  
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\santo\\eclipse-workspace\\WhiteBoxQa\\src\\main\\resources\\browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browserName.equals("gecko"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\santo\\eclipse-workspace\\WhiteBoxQa\\src\\main\\resources\\browsers");
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(Prop.getProperty("Url"));
		}
	public static String takeScreenshotAtEndOfTest(String TestCaseName,WebDriver driver) throws IOException 
    {
    	TakesScreenshot t=(TakesScreenshot)driver;
        File source = t.getScreenshotAs(OutputType.FILE);   //take screenshot and store it in a file
        File file  = new File(System.getProperty("user.dir")+"//repoprts"+TestCaseName + ".png");    //give the location where we have to save the screenshot taken
        FileHandler.copy(source,file);
         return System.getProperty("user.dir")+"//repoprts"+TestCaseName + ".png";   //finally copy the screenshot taken to the location
		

    }
}
