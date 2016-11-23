package com.MercuryTours.cucumber.steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.screenshotUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckPrice_TestSteps {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private Scenario scenario;
	  
	@Before
	public void keepScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Before
	// Open browser
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://stx08-asusn751j:81";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Given("^User is on Select Flight Page$")
	public void user_is_on_Select_Flight_Page() throws Throwable {
		driver.get(baseUrl + "/servlets/com.mercurytours.servlet.WelcomeServlet");
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("o.digiorgio");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("acpqualife");
	    driver.findElement(By.name("login")).click();
	    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");
	    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
	    driver.findElement(By.name("findFlights")).click();
	    screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User select Blue Skies Airlines (\\d+) outbound flight$")
	public void user_select_Blue_Skies_Airlines_outbound_flight(int arg1) throws Throwable {
	    // Sélection vol Aller 
		// Dans Selenium IDE : document.results.outFlight[1]
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	}

	@When("^User select Pangea Airlines (\\d+) return flight$")
	public void user_select_Pangea_Airlines_return_flight(int arg1) throws Throwable {
	    
		screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User clicks Select Flight Continue button$")
	public void user_clicks_Select_Flight_Continue_button() throws Throwable {
		driver.findElement(By.name("reserveFlights")).click();
		screenshotUtil.embedScreenshot(scenario, driver);
	}
	
	@Then("^Book a Flight page is displayed$")
	public void book_a_Flight_page_is_displayed() throws Throwable {
		try {
		      assertTrue(driver.getTitle().matches("^Book[\\s\\S]*$"));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}

	@Then("^Total Price \\(including taxes\\) is \\$(\\d+)$")
	public void total_Price_including_taxes_is_$(int arg1) throws Throwable {
		try {
		      assertEquals("$942", driver.findElement(By.xpath("//td[2]/font/b")).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
	
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
