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

public class Login_TestSteps {
	
	private WebDriver driver = VariablesGlobales.get().getdriver();
	private String baseUrl = VariablesGlobales.get().getbaseUrl();
	private Scenario scenario = VariablesGlobales.get().getscenario();
	
	@Given("^User navigates to MercuryTours Home Page$")
	public void user_navigates_to_MercuryTours_Home_Page() throws Throwable {
		driver.get(baseUrl + "/servlets/com.mercurytours.servlet.WelcomeServlet");
		screenshotUtil.embedScreenshot(scenario, driver);
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
	    screenshotUtil.embedScreenshot(scenario, driver);
	}

	@When("^User cliks Sign-In button$")
	public void user_cliks_Sign_In_button() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@When("^Flight Finder page is displayed$")
	public void flight_Finder_page_is_displayed() throws Throwable {
		String expectedText = "^Find a Flight[\\s\\S]*$";
		String actualText = driver.getTitle();
		assertThat(actualText, RegexMatcher.matchesRegex(expectedText));
		screenshotUtil.embedScreenshot(scenario, driver);
	}

}







