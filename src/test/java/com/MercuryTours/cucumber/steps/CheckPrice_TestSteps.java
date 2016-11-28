package com.MercuryTours.cucumber.steps;

//import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.core.IsEqual;

//import org.hamcrest.core.IsEqual;
//import org.hamcrest.core.IsNull;
//import org.hamcrest.text.IsEmptyString;
//import org.hamcrest.core.StringContains;
//import org.hamcrest.core.SubstringMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.RegexMatcher;
import com.utils.VariablesGlobales;
import com.utils.screenshotUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CheckPrice_TestSteps {

	private WebDriver driver = VariablesGlobales.get().getdriver();
	private String baseUrl = VariablesGlobales.get().getbaseUrl();
	private StringBuffer verificationErrors = new StringBuffer();
	private Scenario scenario = VariablesGlobales.get().getscenario();
	private Integer errorNumber;
	
	@Rule
    public ErrorCollector collector = new ErrorCollector();
	
	/*
	@Before
	public void keepScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Before
	// Open browser
	public void setUp() throws Exception {
		
		// Lancement Firefox
	    //driver = new FirefoxDriver();
		
		// Lancement Internet Explorer
		//File file = new File("C:\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
	    //System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	    //driver = new InternetExplorerDriver();
	    
	    // Lancement Chrome
	    //File file = new File("C:\\chromedriver_win32\\chromedriver.exe");
	    //System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	    //driver = new ChromeDriver();
	    
	    File file = new File("C:\\chromedriver_win32\\chromedriver.exe");
	    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	    //driver = new ChromeDriver();
	    VariablesGlobales.get().setdriver(new ChromeDriver());
	    driver = VariablesGlobales.get().getdriver();
	    
	    baseUrl = "http://stx08-asusn751j:81";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    baseUrl = "http://stx08-asusn751j:81";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	*/
	
	
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
		// Sélection vol Retour 
		// Dans Selenium IDE : document.results.outFlight[1]
		// ERROR: Caught exception [Error: Dom locators are not implemented yet!]
		screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User clicks Select Flight Continue button$")
	public void user_clicks_Select_Flight_Continue_button() throws Throwable {
		driver.findElement(By.name("reserveFlights")).click();
		screenshotUtil.embedScreenshot(scenario, driver);
	}
	
	@Then("^Book a Flight page is displayed$")
	public void book_a_Flight_page_is_displayed() throws Throwable {
		String expectedText = "^Book[\\s\\S]*$";
		String actualText = driver.getTitle();
        //assertTrue(driver.getTitle().matches("^Book[\\s\\S]*$"));
        //collector.checkThat(driver.getTitle(), IsEqual.equalTo("^Book[\\s\\S]*$"));
		assertThat(actualText, RegexMatcher.matchesRegex(expectedText));
		//collector.checkThat(actualText,containsString(actualText));	
	}

	@Then("^Total Price \\(including taxes\\) is \\$(\\d+)$")
	public void total_Price_including_taxes_is_$(int arg1) throws Throwable {
		String expectedText = "$881";
		String actualText = driver.findElement(By.xpath("//td[2]/font/b")).getText();
		String checkpointDescription = "Total price should be $881";
		//assertEquals("$883", driver.findElement(By.xpath("//td[2]/font/b")).getText());
		// assertThat(actual, is(equalTo(expected)));
		assertThat(checkpointDescription, actualText, is(equalTo(expectedText)));
		//collector.checkThat(expectedText, IsEqual.equalTo(actualText));
	}
	
	@Then("^Taxes is \\$(\\d+)$")
	public void taxes_is_$(int arg1) throws Throwable {
		String expectedText = "$67";
		String actualText = driver.findElement(By.xpath("//tr[8]/td[2]/font")).getText();
		//assertEquals("$67", driver.findElement(By.xpath("//tr[8]/td[2]/font")).getText());
		//collector.checkThat("$67", IsEqual.equalTo(driver.findElement(By.xpath("//tr[8]/td[2]/font")).getText()));
		assertThat(actualText, is(equalTo(expectedText)));
		//collector.checkThat(expectedText, IsEqual.equalTo(actualText));
	}
	
	@Given("^User is on Book a Flight Page$")
	public void user_is_on_Book_a_Flight_Page() throws Throwable {
	    
	}
	
	/*@After
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
	*/

}
