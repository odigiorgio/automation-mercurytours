package com.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtil {

	private static String screenshotFolder;
	
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

}
