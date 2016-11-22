package com.MercuryTours.cucumber.steps;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_TestSteps {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	  
	@Before
	// Open browser
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://stx08-asusn751j:81";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Given("^User navigates to MercuryTours Home Page$")
	public void user_navigates_to_MercuryTours_Home_Page() throws Throwable {
		driver.get(baseUrl + "/servlets/com.mercurytours.servlet.WelcomeServlet");
	}

	@When("^User enter valid user name$")
	public void user_enter_valid_user_name() throws Throwable {
		driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("o.digiorgio");
	}

	@When("^User enter valid password$")
	public void user_enter_valid_password() throws Throwable {
		driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("acpqualife");
	}

	@When("^User cliks Sign-In button$")
	public void user_cliks_Sign_In_button() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@When("^Flight Finder page is displayed$")
	public void flight_Finder_page_is_displayed() throws Throwable {
		assertEquals("Flight Details", driver.findElement(By.cssSelector("b > font > font")).getText());
	}

	@After
	// Close Browser
	public void tearDown() throws Exception {
	  driver.quit();
	  String verificationErrorString = verificationErrors.toString();
	  if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	  }
	}
}







