package com.Kayak.Listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogLevel;
import com.relevantcodes.extentreports.LogStatus;
import com.Kayak.ExtentManager.KayakReport;

import com.Kayak.Utilities.CommonUtilities;


public class Listener extends RunListener{
 
	
	 static ExtentReports oReport=KayakReport.createReports();
	 
	
	/**
     * Called before any tests have been run.
     * */
    public void testRunStarted(Description description) throws java.lang.Exception
    {
        System.out.println("Number of tests to execute : " + description.testCount());
    }
 
    /**
     *  Called when all tests have finished
     * */
    public void testRunFinished(Result result) throws java.lang.Exception
    {
        System.out.println("Number of tests executed : " + result.getRunCount());
        oReport.flush();
    }
 
    /**
     *  Called when an atomic test is about to be started.
     * */
    public void testStarted(Description description) throws java.lang.Exception
    {
    	KayakReport.repLogger=oReport.startTest(description.getMethodName().toString());
        System.out.println("Starting execution of test case : "+ description.getMethodName());
    }
 
    /**
     *  Called when an atomic test has finished, whether the test succeeds or fails.
     * */
    public void testFinished(Description description) throws java.lang.Exception
    {
    	
        System.out.println("Finished execution of test case : "+ description.getMethodName());
        
        KayakReport.repLogger.log(LogStatus.INFO, "Test Script Execution Ended");
		oReport.flush();
    }
 
    /**
     *  Called when an atomic test fails.
     * */
    public void testFailure(Failure failure) throws java.lang.Exception
    {
        System.out.println("Execution of test case failed : "+ failure.getMessage());
        KayakReport.repLogger.log(LogStatus.FAIL,failure.getMessage(),KayakReport.repLogger.addScreenCapture(CommonUtilities.attachScreenshotToReport()));
    }
 
    /**
     *  Called when a test will not be run, generally because a test method is annotated with Ignore.
     * */
    public void testIgnored(Description description) throws java.lang.Exception
    {
        System.out.println("Execution of test case ignored : "+ description.getMethodName());
        KayakReport.repLogger.log(LogStatus.SKIP, description.getDisplayName());
    }

}
