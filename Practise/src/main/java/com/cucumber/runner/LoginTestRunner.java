package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//feature",
		glue = {"com.cucumber.stepdefinitions"}, stepNotifications = true
		,plugin = {"pretty", "html:target/cucumber"}
		)




public class LoginTestRunner {

}
