package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reports.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = "org.stepDefinition", dryRun = false, plugin = "json:src\\test\\resources\\Reports\\jira.json")
public class TestRunner {

	@AfterClass
	public static void afterClass() {
		JVMReport.jiraReport("src\\test\\resources\\Reports\\jira.json");
	}
}
