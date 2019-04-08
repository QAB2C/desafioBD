package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GplanPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginGpTest extends BaseTest {

	private GplanPage landingPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testLogin() {

		LOGGER.info("1. Navigate to landing page");
		landingPage = navigateToGplanPage();

		// Assertions
		LOGGER.info(String.format("2. Enter %s into User Name", TestConstants.TestData.USERNAME));
		landingPage.userName(TestConstants.TestData.USERNAME);

		LOGGER.info(String.format("3. Enter %s into Password", TestConstants.TestData.PASSWORD));
		landingPage.passwordUser(TestConstants.TestData.PASSWORD);

		LOGGER.info("4. Click button Login");
		landingPage.buttonSumitLogin();

		LOGGER.info("5. Click menu Hotel");
		landingPage.menuLink();

		LOGGER.info(String.format("6. Enter %s into Destination", TestConstants.TestData.DESTINATION));
		landingPage.enterDestination(TestConstants.TestData.DESTINATION);

		LOGGER.info("7. Click Destinat landingPage.tapClickDestination();ion ");

		LOGGER.info("8. Click search Button");
		landingPage.clickSearchHotel();

		// Click first search result and make sure that we are able to book it
	}

}
