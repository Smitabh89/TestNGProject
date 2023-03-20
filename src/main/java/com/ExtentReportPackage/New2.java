package com.ExtentReportPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class New2
{
	public static ExtentReports extent;
	public static ExtentReports getobject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\Extent.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("smita");
		reporter.config().setDocumentTitle("Test");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Testeer", "Smita");
		return extent;
	
	}
}
