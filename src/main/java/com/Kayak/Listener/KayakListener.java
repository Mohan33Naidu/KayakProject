package com.Kayak.Listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.Kayak.ExtentManager.KayakReport;
import com.Kayak.Utilities.CommonUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class KayakListener implements ITestNGListener  {
	static ExtentReports oReport=null;
	static Logger logKayak=null;
	public KayakListener() {
		oReport=KayakReport.createReports();
		logKayak=Logger.getLogger(getClass().getSimpleName());
	}
	
	
	public void onFinish(ITestContext arg0) {
		
		System.out.println("Test Finish");
		KayakReport.repLogger.log(LogStatus.INFO, "Test Script Execution Ended");
		oReport.flush();
		
	}

	public void onStart(ITestContext testContext) {
		logKayak.info("onStartListener");
		System.out.println("Test Started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult res) {
		
			try {
				KayakReport.repLogger.log(LogStatus.FAIL,res.getMethod().getMethodName().toString(),KayakReport.repLogger.addScreenCapture(CommonUtilities.attachScreenshotToReport()));
			
			}
			catch (Exception e) {
				
				//e.printStackTrace();
				logKayak.info("Test Fail Listener");
			}
		
	}

	public void onTestSkipped(ITestResult res) {
		
		
		KayakReport.repLogger.log(LogStatus.SKIP, res.getMethod().getMethodName().toString());
	}

	public void onTestStart(ITestResult res) {
		
		
		KayakReport.repLogger=oReport.startTest(res.getMethod().getMethodName().toString());
		
	}

	public void onTestSuccess(ITestResult res) {
		KayakReport.repLogger.log(LogStatus.PASS, res.getMethod().getMethodName().toString(),res.getMethod().getDescription().toString());
		
		oReport.endTest(KayakReport.repLogger);
		logKayak.info("onSuccessTestListener");
	}

}
