package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.GooglePage;
import com.applause.auto.pageframework.pages.SearchGooglePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class GoogleTest  extends BaseTest {
	public GooglePage googlePage;
	public SearchGooglePage searchgooglepage;
	@Test(groups = { TestNGGroups.GOOGLE_SEACH }, description = "9483")

	public void testSearchGoogle() {

		LOGGER.info("1. Navigate to google page");
		googlePage = navigateToGooglePage();

		// Assertions
		Assert.assertNotNull(googlePage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Enter %s into data in textbox & search", TestConstants.TestData.SEARCHDATA));
		googlePage.enterdata(TestConstants.TestData.SEARCHDATA);
	
		searchgooglepage.validateResults();
		LOGGER.info("Validate results >1 ");
		Assert.assertTrue(searchgooglepage.validateResults());

		
	}
	
	
}
