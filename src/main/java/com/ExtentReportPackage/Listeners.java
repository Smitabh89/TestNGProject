package com.ExtentReportPackage;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClassPackage.Baseclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Baseclass implements ITestListener
{
	
	  public Listeners() throws IOException {
	        super();
	    } 
	ExtentReports extent = ExtentReportNG.getReportObject();
	    ExtentTest test;
	    public static Logger Log = LogManager.getLogger(Listeners.class);
		
	    public void onTestStart(ITestResult result) {
			test = extent.createTest(result.getMethod().getMethodName());
			
		}
		public void onTestSuccess(ITestResult result) {
			 test.log(Status.PASS,"Test Passed");
		        Log.info("Successfully passed testcase:" + result.getMethod().getMethodName());
			
		}
		public void onTestFailure(ITestResult result) {
			 test.fail(result.getThrowable());
			 try {
				driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			String filepath=null;
			try {
	            filepath=takeScreenshotAtEndOfTest(result.getMethod().getMethodName(),driver);
	        }catch(IOException e) {
	            e.printStackTrace();
	        }
	             
	       test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
			
		}
		public void onTestSkipped(ITestResult result) {
			System.out.println("Skipped the execution");
	        System.out.println("test case skipped at: "+result.getName());
			
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}
		public void onFinish(ITestContext context) {
			 extent.flush();
			
		}
	   
		
	    
}
