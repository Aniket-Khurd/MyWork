package com.cucumber.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//feature//OrangeHRM.feature",
		glue = {"com.cucumber.stepdefinitions"},
		dryRun = false,
		monochrome = true,
		stepNotifications = true,
		plugin = {"pretty", "html:target/cucumber"}
		)

public class OrangeHRMTestRunner {

}
