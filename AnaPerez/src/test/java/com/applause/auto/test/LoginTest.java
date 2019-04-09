package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginTest  extends BaseTest{
	
	private LandingPage landingPage;
	private SearchResultsPage searchResultsPage;
	
	@Test(groups= { TestNGGroups.HOTEL_SEARCH}, description="9483")
	public void testLogin() {	
		
		LOGGER.info("1. Navigate to landing page");
		landingPage = navigateToLandingPage();
		landingPage.enterDestinationAndPrint(TestConstants.TestData.DESTINATION_BUSQUEDAD);


	}
}
