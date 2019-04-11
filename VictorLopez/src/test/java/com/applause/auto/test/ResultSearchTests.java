package com.applause.auto.test;

import com.applause.auto.pageframework.pages.LandingPage;

import com.applause.auto.pageframework.pages.GooglePage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultSearchTests extends BaseTest {

	private GooglePage GooglePage; //
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testSearchForCancunHotel() {

		LOGGER.info("1. Navigate to Google Home page");
        GooglePage = navigateToGooglePage();

		// Assertions
		Assert.assertNotNull(GooglePage, "Failed to navigate to the Google Home page.");

		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.WORDSEARCH));
		GooglePage.enterWordAndSearch(TestConstants.TestData.WORDSEARCH);

		LOGGER.info("Click Search and expect  Search Results in Result page");
		GooglePage.SearchEnterButton();
		//Assert.assertTrue(searchResultsPage.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));


		/*

		searchResultsPage = landingPage.tapSearchButton();

		Assert.assertTrue(searchResultsPage.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));

		// Click first search result and make sure that we are able to book it

		*/
	}
}
