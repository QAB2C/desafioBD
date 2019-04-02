package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.AndromedaPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginTest extends BaseTest {

	private AndromedaPage AndromedaPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testLogin() {

		LOGGER.info("1. Navigate to landing page");
		AndromedaPage = navigateToAndromedaPage();

		// Assertions
		Assert.assertNotNull(AndromedaPage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		AndromedaPage.enterDestinationAndConfirm(TestConstants.TestData.DESTINATION);



	}
}
