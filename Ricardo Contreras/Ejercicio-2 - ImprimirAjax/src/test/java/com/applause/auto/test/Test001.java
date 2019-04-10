package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class Test001 extends BaseTest {

	private LandingPage landingPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "Test")
	public void test001() {
		LOGGER.info("1. Navigate to landing page");
		landingPage = navigateToLandingPage();

		// Assertions
		Assert.assertNotNull(landingPage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		landingPage.enterDestinationAndConfirmKaleido(TestConstants.TestData.DESTINATION);

		LOGGER.info(String.format("3. Get total list of Ajax"));
		landingPage.enterGetDestinationList();

		// LOGGER.info("Click Search and expect to land at Search Results page");
		// searchResultsPage = landingPage.tapSearchButton();
		//
		// Assert.assertTrue(searchResultsPage.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));

		// Click first search result and make sure that we are able to book it
	}
}
