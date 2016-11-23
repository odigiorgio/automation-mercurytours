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
		,tags={"@CheckPrice"}
		//,plugin={"pretty","json:target/cucumber.json"}
		,plugin={"pretty","html:target/Destination"}
		)

public class CheckPrice {


}
