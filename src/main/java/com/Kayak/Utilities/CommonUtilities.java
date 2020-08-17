package com.Kayak.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Kayak.StepDefinitions.Stepdefinition;
import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

public class CommonUtilities {

		 String sPathConfig="\\src\\main\\java\\com\\Kayak\\Properties\\config.properties";
		 String sLogConfig="\\src\\main\\java\\com\\Kayak\\Properties\\log4j.properties";
		 String sTestDataConfig="\\src\\main\\resources\\TestData\\TestData.properties";
		 static String sScreenshotsFolderPath="/Report/KayakScreenshots";
		 static String sPathScreenshot="\\Report\\KayakScreenshots\\Screenshot_";
		 Properties prop=new Properties();
		 FileInputStream fi=null;
		 
		
		public void loadProperty() throws Exception {
			
			fi=new FileInputStream(System.getProperty("user.dir")+sPathConfig);
			prop.load(fi);
			System.getProperties().putAll(prop);
			
			
		}
		public void loadLog4jProperties() throws Exception {
			fi=new FileInputStream(System.getProperty("user.dir")+sLogConfig);
			prop.load(fi);
			PropertyConfigurator.configure(prop);
			
		}
		public void loadTestDataProperties() throws Exception {
			fi=new FileInputStream(System.getProperty("user.dir")+sTestDataConfig);
			prop.load(fi);
			System.getProperties().putAll(prop);
			
		}
		public static String attachScreenshotToReport() throws Exception {
			
			TakesScreenshot ts=(TakesScreenshot)Stepdefinition.driver;
			File SourceFile=ts.getScreenshotAs(OutputType.FILE);
			
			String datetime=DateTimeFormatter.ofPattern("MMddyyyyHHmmss").format(LocalDateTime.now());
			String sDestPath=System.getProperty("user.dir")+sPathScreenshot+datetime+".png";
			File DestFile=new File(sDestPath);
			FileUtils.copyFile(SourceFile, DestFile);	
			Reporter.addScreenCaptureFromPath(sDestPath);
				return sDestPath;	
		}

		public static void clearScreenshot() {
			 File folder = new File(sScreenshotsFolderPath);
			 System.out.println("clear screenshots "+sScreenshotsFolderPath);
			 System.out.println(folder.getName());
		    File[] files = folder.listFiles();
		    System.out.println(folder.list());
		    //System.out.println("file size "+files.length);
		    if(files!=null) { //some JVMs return null for empty dirs
		        for(File f: files) {
		        	int i=0;
		            System.out.println("delete"+i++);
		                f.delete();
		            
		        }
		    }
		    else
		    	System.out.println("screenshot folder empty.");
		   // folder.delete();
		}
		
		
}
