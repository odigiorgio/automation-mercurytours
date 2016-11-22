package com.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;

public class screenshotUtil {

	private static String screenshotFolder;
	
	// Capture actual browser page and save it in png format file
	public static void getscreenshot(WebDriver driver, String fileName ) throws Exception 
    {
		 String screenshotFullName;
		
		 // Capture actual browse page
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         
         // Set screenshot destination folder 
         screenshotFolder = "C:\\TESTRAIL_REPOSITORY\\SCREENSHOTS";
         
         // Save capture in png format file
         screenshotFullName = screenshotFolder + "\\" + fileName + ".png";
         FileUtils.copyFile(scrFile, new File(screenshotFullName));
    }
	
	// Capture actual browser page and include it in html cucumber report
	// Doesn't work with json cucumber report
	public static void embedScreenshot(Scenario scenario, WebDriver driver){
		try {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot,  "image/png");
			
		} catch (WebDriverException somePlatformDontSuportScreenshots) {
			System.err.println("Screenshot Error");
		}
	}

}
