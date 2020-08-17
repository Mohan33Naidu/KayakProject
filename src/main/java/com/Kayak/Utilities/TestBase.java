package com.Kayak.Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.Kayak.ExtentManager.*;


public class TestBase {

	public static BrowserUtilities objBrowser=new BrowserUtilities();
	public static CommonUtilities objCommon=new CommonUtilities();
	public static KayakReport objReport=new KayakReport();
	Logger log4Obj=Logger.getLogger(getClass().getSimpleName());
	public static WebDriver driver=null;
	
	
	public static void initDriver(String sBrowser) throws Exception {
		
		
		
		driver= objBrowser.initDriver(sBrowser);
		
	}
	
	public static void triggerDependencies() throws Exception {
		objCommon.clearScreenshot();
		objCommon.loadProperty();
		objCommon.loadLog4jProperties();
		System.out.println("dependencies triggered");
		objCommon.loadTestDataProperties();
	}

}
