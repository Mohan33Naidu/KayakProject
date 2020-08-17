package com.Kayak.StepDefinitions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.Kayak.Home.Home;
import com.Kayak.Listener.KayakListener;
import com.Kayak.Utilities.BrowserUtilities;
import com.Kayak.Utilities.CommonUtilities;
import com.Kayak.Utilities.TestBase;
import com.Kayak.poFlight.poFlight;
import com.Kayak.poHome.poHome;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import junit.framework.Assert;

@Listeners(com.Kayak.Listener.KayakListener.class)
public class Stepdefinition extends TestBase{

	public static poHome oPOHome=null;
	public static poFlight oPOFlight=null;
//	public static KayakListener listener=new KayakListener();
	
	@Given("^Launch \"([^\"]*)\" browser$")
	public void launch_browser(String sBrowser) throws Throwable {
		
		TestBase.triggerDependencies();
		TestBase.initDriver(sBrowser);
	}

	
	@When("^Launch \"([^\"]*)\" app$")
	public void launch_app(String sUrl) throws Throwable {
	objBrowser.getUrl(sUrl);
	
	}


	@Test
	@Then("^ValidateHomePage$")
	public void validatehomepage() throws Throwable {
		oPOHome=new poHome(driver);
		oPOHome.ValidateHome();
				
	}

	
	@Given("^Click on Flights tab$")
	public void click_on_Flights_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    oPOHome.clickFlight();
	    //flight page creation
	    //validation
	}

	@Test
	@Then("^Validate FlightPage$")
	public void validate_FlightPage() throws Throwable {
	  
	    oPOFlight=new poFlight(driver);
	    oPOFlight.ValidateFlight();
		
	}
	
	@Test
	@Given("^Enter Origin and Departure$")
	public void enter_Origin_and_Departure() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    oPOFlight.entercity();
	}

	@Test
	@When("^Enter Departure Date and Return Dates$")
	public void enter_Departure_Date_and_Return_Dates() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    oPOFlight.enterdates();
	}
	
	@Test
	@Then("^Click on Search$")
	public void click_on_Search() throws Throwable {
	   oPOFlight.clickSearch();
	   
	}

	@Test
	@Given("^Select Result N$")
	public void select_Result_N() throws Throwable {
	    oPOFlight.selectResultN();
	}

	@Test
	@When("^Assert origin and destination details are same$")
	public void assert_origin_and_destination_details_are_same() throws Throwable {
	   oPOFlight.assertAirports();
	}
	
	@Then("^Log all information of selected flight for reporting$")
	public void log_all_information_of_selected_flight_for_reporting() throws Throwable {
	   oPOFlight.logSelectFlight();
	}
}
