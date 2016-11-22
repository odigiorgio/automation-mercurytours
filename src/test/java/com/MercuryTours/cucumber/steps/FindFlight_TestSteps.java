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

public class FindFlight_TestSteps {

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

	@Given("^User is on Flight Finder Page$")
	public void user_is_on_Flight_Finder_Page() throws Throwable {
		driver.get(baseUrl + "/servlets/com.mercurytours.servlet.WelcomeServlet");
		screenshotUtil.embedScreenshot(scenario, driver);
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("o.digiorgio");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("acpqualife");
	    screenshotUtil.embedScreenshot(scenario, driver);
	    driver.findElement(By.name("login")).click();
	    screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User select departure from New York$")
	public void user_select_departure_from_New_York() throws Throwable {
		new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");
		
	}

	@When("^User select arrival to Paris$")
	public void user_select_arrival_to_Paris() throws Throwable {
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
		screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User clicks Continue button$")
	public void user_clicks_Continue_button() throws Throwable {
		driver.findElement(By.name("findFlights")).click();
	}

	@Then("^Select Flight page is displayed$")
	public void select_Flight_page_is_displayed() throws Throwable {
		 assertEquals("Select your departure and return flight from the selections below. Your total price will be higher than quoted if you elect to fly on a different airline for both legs of your travel.", driver.findElement(By.xpath("//tr[3]/td/font")).getText());
	}

	@Then("^New York is selected as departure city$")
	public void new_York_is_selected_as_departure_city() throws Throwable {
		assertEquals("New York to Paris", driver.findElement(By.cssSelector("td.title > b > font")).getText());
	}

	@Then("^Paris is selected as arrival city$")
	public void paris_is_selected_as_arrival_city() throws Throwable {
		assertEquals("Paris to New York", driver.findElement(By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText());
		screenshotUtil.embedScreenshot(scenario, driver);
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
	
//	public void embedScreenshot(Scenario scenario){
//		try {
//			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot,  "image/png");
//			
//		} catch (WebDriverException somePlatformDontSuportScreenshots) {
//			System.err.println("Screenshot Error");
//		}
//	}
	
//	public void getscreenshot() throws Exception 
//    {
//         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//         //The below method will save the screen shot in d drive with name "screenshot.png"
//         FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
//    }
}
