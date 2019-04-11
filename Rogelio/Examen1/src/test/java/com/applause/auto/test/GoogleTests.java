package com.applause.auto.test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTest {

	private HomePage HomePage;


	@Test(groups = { TestNGGroups.LOGIN })
	public void testSearch() {

		LOGGER.info("1. Navigate to landing page");
		HomePage = navigateToHomePage();
		HomePage.ingresarDatos(TestConstants.TestData.Busqueda);


		// Assertions
		Assert.assertNotNull(HomePage, "Failed to navigate to the landing page.");



		// Click first search result and make sure that we are able to book it
	}
}
