package com.Kayak.RunnerFiles;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import com.Kayak.Listener.*;
import com.Kayak.Utilities.ConfigReader;
import com.aventstack.extentreports.utils.Reader;
//import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;


@RunWith(Cucumber.class)

@CucumberOptions(
		features="KayakFeatures",glue= {"com.Kayak.StepDefinitions"}
		,
		// plugin = { "pretty", "html:Report" },
		
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Report/Reports/KayakReport.html"},
		monochrome = true
		 )

public class Runner {
	
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(ConfigReader.getInstance().getReportConfigPath()));
	 
	
	 }


	}
