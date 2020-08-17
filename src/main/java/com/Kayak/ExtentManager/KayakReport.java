package com.Kayak.ExtentManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class KayakReport {

	public static ExtentReports report=null;
	public static ExtentTest repLogger=null;
	
	public static ExtentReports createReports() {
		
		report=new ExtentReports(System.getProperty("user.dir")+"\\Report\\report.html");
		
		return report;
		
	}
	

}
