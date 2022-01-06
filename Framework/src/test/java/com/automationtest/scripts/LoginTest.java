package com.automationtest.scripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Automation.pages.CLADDPage;
import com.automationtest.utility.ExcelDataprovider;
import com.automationtest.utility.Helper;

public class LoginTest extends BaseClass
{
	@Test
	public void loginapp()
	{	
			
		logger=report.createTest("Login to CL");
			
		CLADDPage ADDPage = PageFactory.initElements(driver, CLADDPage.class);
		logger.info("Starting Application");
		ADDPage.UNTB(excel.getStringData("Sheet1", 1, 0),excel.getStringData("Sheet1", 1, 1));	
		logger.pass("Login Success");
		
		
		
	}

	
}
