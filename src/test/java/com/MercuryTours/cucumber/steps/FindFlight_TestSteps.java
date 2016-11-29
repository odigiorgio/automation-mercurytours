package com.MercuryTours.cucumber.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.RegexMatcher;
import com.utils.VariablesGlobales;
import com.utils.screenshotUtil;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindFlight_TestSteps {

	private WebDriver driver = VariablesGlobales.get().getdriver();
	private String baseUrl = VariablesGlobales.get().getbaseUrl();
	private Scenario scenario = VariablesGlobales.get().getscenario();

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
		String expectedText = "^Select a Flight[\\s\\S]*$";
		String actualText = driver.getTitle();
		assertThat(actualText, RegexMatcher.matchesRegex(expectedText));
	}

	@Then("^New York is selected as departure city$")
	public void new_York_is_selected_as_departure_city() throws Throwable {
		String expectedText = "New York to Paris";
		String actualText = driver.findElement(By.cssSelector("td.title > b > font")).getText();
		assertThat(actualText, is(equalTo(expectedText)));
	}

	@Then("^Paris is selected as arrival city$")
	public void paris_is_selected_as_arrival_city() throws Throwable {
		String expectedText = "Paris to New York";
		String actualText = driver.findElement(By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText();
		assertThat(actualText, is(equalTo(expectedText)));
		screenshotUtil.embedScreenshot(scenario, driver);
	}    
	
}
