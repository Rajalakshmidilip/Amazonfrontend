package com.nuvolarworks.testrunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.nuvolarworks.configuration.ReportRuntimeListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features = { "features" }, 
	glue = {"com.nuvolarworks.stepdefinition"}, 
	plugin = {"json:target/cucumber.json"},
	monochrome = true, 
	dryRun = false)


	public class TestRunner {
		
		@BeforeClass
		 public static void beforeClass()
		 {
			ReportRuntimeListener.initializeExtentReport();
		 }

		@AfterClass
		 public static void afterClass()
		 {
			ReportRuntimeListener.ReportCooldown();
		 }
	}

