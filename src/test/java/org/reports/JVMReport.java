package org.reports;

import java.io.File;
import java.util.*;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void jiraReport(String json) {
		File file = new File(System.getProperty("user.dir")+"\\target");
		
		Configuration configuration = new Configuration(file, "Jira API");
		configuration.addClassifications("Spirint", "3");
		configuration.addClassifications("Jira Report", "1");
		
		List<String> list = new ArrayList<>();
		list.add(json);
		
		ReportBuilder builder = new ReportBuilder(list, configuration);
		builder.generateReports();
	}

}
