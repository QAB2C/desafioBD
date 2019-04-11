package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GoogleResultsPage;
import com.applause.auto.pageframework.pages.GoogleSearchPage;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class SearchGoogleTest extends BaseTest {

	private GoogleSearchPage GoogleSearchPage;
	private GoogleResultsPage GoogleResultsPage;

	@Test(groups = { TestNGGroups.GOOGLE_SEARCH }, description = "9483")
	public void GoogleSearch() {

		LOGGER.info("1. Navigate to GoogleSearchPage page");
		GoogleSearchPage = navigateGoogleSearchPage();

		// Assertions
		Assert.assertNotNull(GoogleSearchPage, "Failed to navigate to the GoogleSearchPage page.");

		LOGGER.info(String.format("Ingresando y buscando %s", TestData.SEARCH));
		GoogleSearchPage.entersearchandGo(TestData.SEARCH);

		GoogleResultsPage = GoogleSearchPage.gotoGoogleResultsPage();
		LOGGER.info("Validate that contains Something");

		GoogleResultsPage.containsResults();
		Assert.assertTrue(GoogleResultsPage.containsResults());

	}
}
