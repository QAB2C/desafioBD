package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.HomeGooglePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class HomeGoogleTest extends BaseGoogleTest {

	private HomeGooglePage landingPage;
	private HomeGooglePage searchGoogle;

	@Test(groups = { TestNGGroups.GOOGLE_SEARCH }, description = "9483")
	public void testSearchGoogle() {

		LOGGER.info("1. Navigate to landing Google Home page");
		landingPage = navigateToGooglePage();

		// Assertions
		LOGGER.info(String.format("2. Enter %s into search box", TestConstants.TestData.SEARCH_PALABRA));
		landingPage.searchGoogle(TestConstants.TestData.SEARCH_PALABRA);
		// Click first search result and make sure that we are able to book it
	}
}
