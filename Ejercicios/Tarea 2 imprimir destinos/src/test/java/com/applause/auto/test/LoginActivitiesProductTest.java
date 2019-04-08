package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.ActivityProductLoginChunck;
import com.applause.auto.pageframework.pages.ActivityProductMainPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginActivitiesProductTest extends BaseTest {
	private ActivityProductLoginChunck ActivityProductLoginChunck;
	private ActivityProductMainPage ActivityProductMainPage;

	// private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testLogin() {
		LOGGER.info("1. Navigate to landing page");
		ActivityProductLoginChunck = navigateToActivityProductPage();

		// Assertions
		Assert.assertNotNull(ActivityProductLoginChunck, "Failed to navigate to the Andromeda page.");

		LOGGER.info(String.format("2. Enter %s into User and Password box", ""));
		ActivityProductLoginChunck.Login(TestConstants.TestData.USERNAME, TestConstants.TestData.PASSWORD);

		ActivityProductMainPage = ActivityProductLoginChunck.tapLoginButton();

		Assert.assertEquals(ActivityProductMainPage.GetURL(), TestConstants.TestData.ACTIVITIESPRODUCTLOGINCHUNCK_URL,
				"Failed login");
	}
}