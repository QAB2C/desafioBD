package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GoogleLandingPage;
import com.applause.auto.pageframework.pages.GoogleResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class Google extends BaseTest {

	private GoogleLandingPage GooglePage;
	private GoogleResultsPage GoogleResultsPage;

	@Test(groups = { TestNGGroups.GOOGLE_SEARCH }, description = "9483")
	public void GoogleItemSearch() {

		LOGGER.info("Navigate to Google Home");
		GooglePage = navigateToLandingPage();

		LOGGER.info(String.format("Search in Google %s ", TestConstants.TestData.ITEM));
		GooglePage.SearchGoogle(TestConstants.TestData.ITEM);
		
		GoogleResultsPage = GooglePage.GResultPage();
		LOGGER.info("Validate the result is the expected");

		GoogleResultsPage.containItem();
		Assert.assertTrue(GoogleResultsPage.containItem());

		
		
		
	}
}
