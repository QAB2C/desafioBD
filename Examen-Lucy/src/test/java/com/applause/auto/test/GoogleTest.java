package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.ResultPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class GoogleTest extends BaseTest {

	private HomePage homePage;
	private ResultPage resultPage;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")
	public void testSearchForGoogle() {

		LOGGER.info("1. Navigate to Home page");
		homePage = navigateToHomePage();

		// Assertions
		Assert.assertNotNull(homePage, "Failed to navigate to the home page.");

		LOGGER.info(String.format("2. Enter %s into busqueda box", TestConstants.TestData.BUSQUEDA));
		homePage.enterBusqueda(TestConstants.TestData.BUSQUEDA);

		// LOGGER.info("Click Search and expect to land at Search Results page");
		// resultPage = homePage.tapSearchButton();

		// LOGGER.info(String.format("2. Enter %s into busqueda box", TestConstants.TestData.BUSQUEDA));
		// resultPage = homePage.enterBusqueda(TestConstants.TestData.BUSQUEDA);
	}
}
