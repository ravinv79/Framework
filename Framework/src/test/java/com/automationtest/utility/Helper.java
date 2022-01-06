package com.automationtest.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//To Handle Screenshots, alerts, Frames, Windows, Sync issue, Javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath =System.getProperty("user.dir")+"/Screenshots/CL ";
		
		
		try
		{
			FileHandler.copy(src, new File(screenshotPath));
		}catch (Exception e)
		{
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		
		return screenshotPath;
	}

	
}


