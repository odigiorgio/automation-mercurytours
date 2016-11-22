package com.MercuryTours.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false
		,features = "classpath:cucumberFeatures"
		,glue={"com.MercuryTours.cucumber.steps"}
		,monochrome = true
		,tags={"@LoginOK"}
		,plugin={"pretty","json:target/cucumber.json"}
		)

public class LoginOK {

}
