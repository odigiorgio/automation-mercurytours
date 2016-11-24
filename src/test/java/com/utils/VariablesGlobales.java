package com.utils;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class VariablesGlobales {

    private WebDriver driver = null;
    private String baseUrl = null;
    private Scenario scenario = null;

    private static VariablesGlobales INSTANCE = null;

    private VariablesGlobales(){}

    public static VariablesGlobales get() {
        if (INSTANCE == null) {
            INSTANCE = new VariablesGlobales();
        }
        return INSTANCE;
    }

    public WebDriver getdriver() {
        return driver;
    }

    public void setdriver(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getbaseUrl() {
        return baseUrl;
    }

    public void setbaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    public Scenario getscenario() {
        return scenario;
    }

    public void setscenario(Scenario scenario) {
        this.scenario = scenario;
    }


}
