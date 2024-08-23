package com.tarottalk.today.stepdefenitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/resources/FeatureFiles",
      dryRun = !true,
      glue = {"com.tarottalk.today.stepdefenitions"},
      snippets = SnippetType.CAMELCASE,
      plugin = {"pretty","html:reports/cucumber-reports.html"},
      monochrome = true
		)
public class Runner extends AbstractTestNGCucumberTests {

	
}
