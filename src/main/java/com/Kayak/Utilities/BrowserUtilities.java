package com.Kayak.Utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities {

	
		// TODO Auto-generated constructor stub
		public static WebDriver driver=null;
		CommonUtilities objComUtil=new CommonUtilities();
		WebDriverWait wait=null;
		public WebDriver initDriver(String sBrowser) {
			
			
			if(sBrowser.contains("ch"))
		{
			
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			}
			
			wait=new WebDriverWait(driver, 30);
			
			return driver;
		}
		public void getUrl(String sUrl) throws Exception {
			
			//driver.get(System.getProperty("url"));
			driver.get(sUrl);
			driver.manage().window().maximize();
		}
		
		public void waitUntilElementVisible(WebElement ele) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		public void waitUntilElementsVisible(List<WebElement> eleList) {
			//waitUntilElementVisible(eleList.get(0));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(eleList));
		}
		
		public void poSendKeys(WebElement element,String sKey) {
			element.sendKeys(sKey);
		}
		
		public void poClick(WebElement element) {
			element.click();
		}
		public void ValidateString(String string) {
			// TODO Auto-generated method stub
			
		}
		
		public void jsScrollTo(WebElement element) {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",element);
		}

}
