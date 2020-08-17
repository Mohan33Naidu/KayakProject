package com.Kayak.poHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Kayak.Home.Home;
import com.Kayak.StepDefinitions.Stepdefinition;
import com.Kayak.Utilities.TestBase;

public class poHome extends TestBase{

	public poHome(WebDriver driver) {
	 driver=TestBase.driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Flights")
	WebElement elFlights;
	
	public void clickFlight() {
		//objBrowser.waitUntilElementVisible(elFlights);
		objBrowser.poClick(elFlights);
	}

	public void ValidateHome() {
		Home objHome=new Home();
		objBrowser.waitUntilElementVisible(elFlights);
		objHome.ValidateHome(elFlights.getText().toString());
	}
}
