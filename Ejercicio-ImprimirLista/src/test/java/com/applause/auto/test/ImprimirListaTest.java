package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.ValidacionesPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class ImprimirListaTest extends BaseTest {

	private ValidacionesPage validacionesPage;

	@Test(groups = { TestNGGroups.LOGIN }, description = "9483")
	public void testSearchForHotelImprimir() {

		LOGGER.info("1. Navigate to Bestday page");
		validacionesPage = navigateToValidacionesPage();

		// Assertions
		Assert.assertNotNull(validacionesPage, "Failed to navigate to the Bestday page.");

		LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		validacionesPage.enterDestination(TestConstants.TestData.DESTINATION);

	}
}
