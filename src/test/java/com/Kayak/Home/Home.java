package com.Kayak.Home;

import com.Kayak.Utilities.TestBase;

import org.junit.Assert;

public class Home extends TestBase{

	public void ValidateHome(String sActualHome) {
		
		 Assert.assertEquals("Flights",sActualHome);
		
		
	}
}
