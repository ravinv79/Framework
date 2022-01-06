package com.automationtest.scripts;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.ConfigurationGroupMethods;
import com.automationtest.utility.BrowserFactory;
import com.automationtest.utility.ConfigDataProvider;
import com.automationtest.utility.ExcelDataprovider;
import com.automationtest.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	public WebDriver driver;	
	public ExcelDataprovider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		excel=new ExcelDataprovider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/CL.html"));		
		report =new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done - Test can be started", true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getStringURL());
		Reporter.log("Browser and Application is up and running", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		
	}
	

}
