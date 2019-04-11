package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingPageGoogle;
import com.applause.auto.pageframework.pages.SearchResultsPageGoogle;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class GoogleTest extends BaseTest {

	private LandingPageGoogle googleLandingPage;
	private SearchResultsPageGoogle searchResultsPageGoogle;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "Word")
	public void testSearchForGoogleNavigator() {

		LOGGER.info("1. Navigate to landing page");
		googleLandingPage = navigateToGoogleLandingPage();

		// Assertions
		Assert.assertNotNull(googleLandingPage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		googleLandingPage.enterWordAndConfirm(TestConstants.TestData.WORD);

		LOGGER.info("Click Search and expect to land at Search Results page");
		searchResultsPageGoogle = googleLandingPage.tapSearchButtonGoogle();

		Assert.assertTrue(searchResultsPageGoogle.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));

		// Click first search result and make sure that we are able to book it
	}
}