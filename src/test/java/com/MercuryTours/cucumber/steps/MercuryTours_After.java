package com.MercuryTours.cucumber.steps;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import com.utils.VariablesGlobales;

import cucumber.api.java.After;

public class MercuryTours_After {

	private WebDriver driver = VariablesGlobales.get().getdriver();
	private StringBuffer verificationErrors = new StringBuffer();
	
	@After
	// Close Browser
	public void tearDown() throws Exception {
	  //screenshotUtil.getscreenshot(driver, "MyName");
	  //screenshotUtil.embedScreenshot(scenario, driver);
	  driver.quit();
	  String verificationErrorString = verificationErrors.toString();
	  if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	  }
	}

}
