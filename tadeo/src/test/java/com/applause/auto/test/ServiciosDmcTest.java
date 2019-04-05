package com.applause.auto.test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.testng.annotations.Test;

public class ServiciosDmcTest extends BaseTest{

	private LandingPage landingPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestConstants.TestNGGroups.SERVICES_SEARCH }, description = "9483")
	public void testSearchServiceDmc() {

		LOGGER.info("1. Navigate to landing page");

		landingPage = navigatePageReceptivo();
		landingPage.clickServicesDmc()    ;






		// Click first search result and make sure that we are able to book it */
	}


}
