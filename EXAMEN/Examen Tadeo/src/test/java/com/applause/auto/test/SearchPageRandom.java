package com.applause.auto.test;

import com.applause.auto.pageframework.pages.RandomLandingPage;
import com.applause.auto.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class SearchPageRandom extends BaseTest {

	private RandomLandingPage landingPage;
	// private SearchResultsPage searchResultsPage;

	protected int a = 8;
	private boolean b = true;
	public String c = "hola";
	private RandomLandingPage aaaa;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "9483")

	public void testSearchPageRandom() {

		LOGGER.info("1. Navegar por Pagina RandomLandingPage");
		aaaa = navigateToRandomPage();

	}
}