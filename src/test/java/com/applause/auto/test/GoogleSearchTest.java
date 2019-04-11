package com.applause.auto.test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

	private LandingPage landingPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testSearchForJava() {

		LOGGER.info("1. Navigate to landing page");
		landingPage = navigateToLandingPage();

		// Assertions
		Assert.assertNotNull(landingPage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Enter %s into Search box", TestConstants.TestData.KEYWORD));
		searchResultsPage = landingPage.searchText(TestConstants.TestData.KEYWORD);

		LOGGER.info(String.format("2. Result %s ", searchResultsPage.getSearchResultsSummaryText()));
		Assert.assertTrue(searchResultsPage.getSearchResultsSummaryText());
		// Click first search result and make sure that we are able to book it
	}
}
