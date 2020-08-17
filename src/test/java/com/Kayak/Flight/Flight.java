package com.Kayak.Flight;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Kayak.Utilities.TestBase; 

public class Flight extends TestBase{

	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void ValidateFlight(String sValidateTitle) {
		 Assert.assertEquals("Search hundreds of flight sites at once.",sValidateTitle);
		
	}
	public void enterCities() {
		
	}


	public void ValidateAirports(boolean bOrigAirport,boolean bDestAirport) {
		
		
		//Assertion
		Assert.assertTrue(bOrigAirport);
		Assert.assertTrue(bDestAirport);
		log.info("FlightCode:ValidateAirports");
	}
	
	public void assertAirports(List<WebElement> lsAirports) {
		
		String sToFlightActual=System.getProperty("ToFlight");
		String sFromFlightActual=System.getProperty("FromFlight");
		log.info(sToFlightActual+";"+sFromFlightActual);
		Assert.assertEquals(lsAirports.get(0).getText().toString(),sToFlightActual);
		Assert.assertEquals(lsAirports.get(1).getText().toString(),sFromFlightActual);
		log.info("FlightCode:assertAirports");
	}
	
	
	
}
