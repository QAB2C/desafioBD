package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.AndromedaPage;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginTest extends BaseTest {

	private AndromedaPage andromedaPage;

	@Test(groups = { TestNGGroups.LOGIN }, description = "9484")
	public void testSearchForCancunHotel() {

		LOGGER.info("1. Navigate to landing page");

		andromedaPage = navigateToAndromedaPage();// Assertions

		Assert.assertNotNull(andromedaPage, "Failed to navigate to the landing page.");
		
		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		
		andromedaPage.enterDestinationAndConfirm(TestConstants.TestData.DESTINATION);

	}
}
