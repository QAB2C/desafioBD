package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.ActivityProductLoginChunck;
import com.applause.auto.pageframework.Chunks.ActivityProductMenuChunk;
import com.applause.auto.pageframework.pages.ActivityProductMainPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginActivitiesProductTest extends BaseTest {
	private ActivityProductLoginChunck ActivityProductLoginChunck;
	private ActivityProductMainPage ActivityProductMainPage;
	private ActivityProductMenuChunk ActivityProductMenuChunk;

	// private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.ACTIVITY_PRODUCT }, description = "9483")

	public void testLogin() {
		LOGGER.info("1. Navigate to landing page");
		ActivityProductLoginChunck = navigateToActivityProductLoginChunck();

		// Assertions
		Assert.assertNotNull(ActivityProductLoginChunck, "Failed to navigate to the Andromeda page.");

		LOGGER.info("2. Enter %s into User and Password box");
		ActivityProductLoginChunck.Login(TestConstants.TestData.USERNAME, TestConstants.TestData.PASSWORD);

		ActivityProductMainPage = ActivityProductLoginChunck.tapLoginButton();
		LOGGER.info(String.format("3. Validate that URL %s is correct",
				TestConstants.TestData.ACTIVITIES_PRODUCT_LOGIN_CHUNCK_URL));

		Assert.assertEquals(ActivityProductMainPage.GetURL(),
				TestConstants.TestData.ACTIVITIES_PRODUCT_LOGIN_CHUNCK_URL, "Failed login");

		ActivityProductMenuChunk = ActivityProductMainPage.OpenMenu();
		LOGGER.info(String.format("Validate that user %s is correct", TestConstants.TestData.USERNAME));
		Assert.assertEquals(ActivityProductMenuChunk.validateUser(), TestConstants.TestData.USERNAME, "Incorrect user");
	}
}