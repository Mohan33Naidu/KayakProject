package com.Kayak.poFlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.Kayak.Flight.Flight;
import com.Kayak.Utilities.CommonUtilities;
import com.Kayak.Utilities.TestBase;

@Listeners(com.Kayak.Listener.KayakListener.class)
public class poFlight extends TestBase{
	static Flight objFlight=null;
	Logger log=Logger.getLogger(getClass().getSimpleName());
	public poFlight(WebDriver driver) {
		driver=TestBase.driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//h2[@class='title dark']")
	WebElement elTitle;
		
	@FindBy(xpath="(//input[contains(@aria-label,'Flight origin input') and contains(@id,\"origin-airport\")])[1]")
	WebElement elOrigCity;
	
	@FindBy(xpath="(//div[contains(@id,'origin-airport-display-multi-container')])[1]//div[@role='listitem']//button")
	WebElement elDeleteCity;
	
	@FindAll({@FindBy(how=How.XPATH,using="//div[@class='item-info']//div[1]")})
	List<WebElement> ddOriginCity;
	
	@FindBy(xpath="(//div[contains(@id,'destination-airport-display-multi-container')])[1]//div[@role='listitem']//button")
	WebElement elDeleteDepCity;
	
	@FindBy(xpath="(//div[contains(@aria-label,'Flight destination input')])[1]")
	WebElement elDepartCity;
	
	@FindBy(xpath="(//input[contains(@aria-label,'Flight destination input')])[1]")
	WebElement elEnterDepCity;
	
	@FindAll({@FindBy(how=How.XPATH,using="//div[contains(@id,'destination-airport-smartbox-dropdown') and @role='dialog']//li")})
	List<WebElement> ddDepartCity;
	
		
	public void ValidateFlight() {
		objFlight=new Flight();

		objBrowser.waitUntilElementVisible(elTitle);
		objFlight.ValidateFlight(elTitle.getText().toString());
		log.info("Flight Tab Clicked");
	}

	public void entercity() throws Exception {
		
		elDeleteCity.click();
		
        objBrowser.waitUntilElementVisible(elOrigCity);
		elOrigCity.sendKeys(System.getProperty("OriginCityCode"));
		
		objBrowser.waitUntilElementsVisible(ddOriginCity);
		for (int i=0;i<ddOriginCity.size();i++) {
			
			if(ddOriginCity.get(i).getText().contains(System.getProperty("SelectOriginCity"))) {
				//Thread.sleep(2000);
			ddOriginCity.get(i).click();
				
			}
			
		}
		
			objBrowser.waitUntilElementVisible(elDepartCity);
			elDepartCity.click();
			elEnterDepCity.sendKeys(System.getProperty("DepartCityCode"));
			Thread.sleep(2000);
			objBrowser.waitUntilElementsVisible(ddDepartCity);
			
			for (int i=0;i<ddDepartCity.size();i++) {
				
				if(ddDepartCity.get(i).getText().contains(System.getProperty("SelectDepartCity"))) {
				ddDepartCity.get(i).click();
					
				}
				
			}
	}

	@FindBy(xpath="(//div[contains(@id,'dateRangeInput-display-start-inner')])[1]")
	WebElement elDepDate;
	
	@FindBy(xpath="//div[contains(@id,'depart-input')]")
	WebElement elDepInputDate;
	
	@FindBy(xpath="//div[contains(@id,'return-input')]")
	WebElement elReturnDate;
	
	@FindBy(xpath="//h3[contains(@id,'airports-section-title-text')]")
	WebElement lblAirports;
	
	@FindAll({@FindBy(how=How.XPATH,using="((//div[contains(@id,'airports-section-airports-options')]//div[contains(@class,'heading')])[1]//li//button)[1]")})
	List<WebElement> listTakeoff;
	
	@FindAll({@FindBy(how=How.XPATH,using="((//div[contains(@id,'airports-section-airports-options')]//div[contains(@class,'heading')])[2]//li//button)[1]")})
	List<WebElement> lsDestAirports;
	
			
	public void enterdates() throws Exception {
		
		objBrowser.waitUntilElementVisible(elDepDate);
		elDepDate.click();//calendar pops up
		Thread.sleep(3000);
		
		objBrowser.waitUntilElementVisible(elDepInputDate);
		elDepInputDate.clear();
		elDepInputDate.sendKeys(System.getProperty("FromDate"));
		//Thread.sleep(2000);
		objBrowser.waitUntilElementVisible(elReturnDate);
		elReturnDate.click();
		elReturnDate.clear();
		elReturnDate.sendKeys(System.getProperty("ToDate"));
		Thread.sleep(1000);
		
		//Thread.sleep(10000);
		log.info("Enter Dates for To and From");
		
	}

	@FindBy(xpath="(//span[contains(@class,'v-c-p centre')])//span[contains(@class,\"icon\")]")
	WebElement btnSearch;
	
	@FindAll({@FindBy(how=How.XPATH,using="(//div[@id='searchResultsList']//div[contains(@aria-label,'number')])")})
	List<WebElement> elResultView;
	
	public void clickSearch() {
		objBrowser.waitUntilElementVisible(btnSearch);
		objBrowser.poClick(btnSearch);
		objBrowser.waitUntilElementsVisible(elResultView);
		log.info("Search Clicked");
	}

	
	@FindAll({@FindBy(how=How.XPATH,using="(//div[@id='searchResultsList']//div[contains(@aria-label,'number')])")})
	List<WebElement> elResultSet;
	public void selectResultN() {
		objBrowser.waitUntilElementsVisible(elResultSet);
		WebElement elResult=elResultSet.get(Integer.parseInt(System.getProperty("SelectResultN")));
		objBrowser.jsScrollTo(elResult);
		objBrowser.waitUntilElementVisible(elResult);
		objBrowser.poClick(elResult);
		log.info("selectResultN");
		
	}

	@FindAll({@FindBy(how=How.XPATH,using="//div[contains(@id,\"detailsWrapper\") and @aria-expanded=\"true\"]//div[@class=\"airports left\"]/span")})
	List<WebElement> lsAirport;
	@Test
	public void assertAirports() {
			
		objFlight.assertAirports(lsAirport);
		log.info("assertAirports");
	}

	@FindBy(xpath="//h3[contains(@id,'airlines-title-text')]")
	WebElement elAirlinesText;
	public void logSelectFlight() throws Exception {
	
		objBrowser.jsScrollTo(elAirlinesText);
		
		CommonUtilities.clearScreenshot();
		Thread.sleep(2000);
		CommonUtilities.attachScreenshotToReport();
		
		
		Thread.sleep(2000);
		objBrowser.waitUntilElementVisible(lblAirports);
		objBrowser.jsScrollTo(lblAirports);
		//screenshot
		CommonUtilities.attachScreenshotToReport();
		//report
		log.info("logSeelectFlight");
		
	}
	public void selectedAirports() {
		objBrowser.waitUntilElementVisible(lblAirports);
		
		objBrowser.jsScrollTo(lblAirports);
		boolean bDepartAirport=false;
		boolean bDestAirport=false;
		for (WebElement eleDepart : listTakeoff) {
			
			if(eleDepart.getAttribute("aria-label").toString().contains("BOS: Logan Intl only"))
			{
				bDepartAirport=true;
			}
		}
		for (WebElement eleDest : lsDestAirports) {
			
			if(eleDest.getAttribute("aria-label").toString().contains("DEL: Indira Gandhi Intl only"))
				{
					bDestAirport=true;
				}
		}
		
		objFlight.ValidateAirports(bDepartAirport,bDestAirport);
		
	}

}
