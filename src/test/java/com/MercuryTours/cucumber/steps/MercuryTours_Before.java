package com.MercuryTours.cucumber.steps;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utils.VariablesGlobales;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class MercuryTours_Before {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private Scenario scenario;

	private Integer browserNameNumber; 
	// clean install -Dtest=$TEST_NAME test -Denv.browser=2
	
	@Before
	public void keepScenario(Scenario scenario) {
		this.scenario = scenario;
	    VariablesGlobales.get().setscenario(scenario);
	}
	
	@Before
	// Open browser
	public void setUp() throws Exception {
		
		String strBrowserNameNumber = System.getProperty("browser");
		if (strBrowserNameNumber == null){
			browserNameNumber = 3; // Chrome
		}
		else
		{
			browserNameNumber = Integer.parseInt(strBrowserNameNumber);
			System.out.println("Browser from Maven");
		}
		
		System.out.println("Browser : " + browserNameNumber);
		
		// Browser selection :
		//   - 1 : IE
		//   - 2 : Firefox
		//   - 3 : Chrome
		switch(browserNameNumber) {
		
			case 2 :
				
				// Firefox
			    //driver = new FirefoxDriver();
				VariablesGlobales.get().setdriver(new FirefoxDriver());
			    //driver = VariablesGlobales.get().getdriver();
				break;
				
			case 3 :
				
				// Chrome
			    File fileChrome = new File("C:\\chromedriver_win32\\chromedriver.exe");
			    System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
			    //driver = new ChromeDriver();
			    VariablesGlobales.get().setdriver(new ChromeDriver());
			    //driver = VariablesGlobales.get().getdriver();
			    break;
				
			case 1 :
				
				// Internet Explorer
				File fileIE = new File("C:\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			    System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
			    //driver = new InternetExplorerDriver();
				VariablesGlobales.get().setdriver(new InternetExplorerDriver());
			    //driver = VariablesGlobales.get().getdriver();
				break;
		    
		}
		
		driver = VariablesGlobales.get().getdriver();
		
	    
	    // URL set
	    baseUrl = "http://stx08-asusn751j:81";
	    VariablesGlobales.get().setbaseUrl(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

}
