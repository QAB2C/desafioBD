package com.applause.auto.test.Hotels;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.HotelSearchPage;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import com.applause.auto.test.BaseTest;

/**
 * 
 * @author BMXDDT005309
 */
public class TestHotels_001 extends BaseTest {

	private HotelSearchPage hotelSearchPage;

	@Test(groups = { TestNGGroups.HOTEL_QUOTE }, description = "Test HotelsResponsive 001")
	public void test() {

		LOGGER.info("1. Navigate to landing page");
		hotelSearchPage = navigateToLandingPage("Dream");

		// Assertions
		Assert.assertNotNull(hotelSearchPage, "Failed to navigate to the landing page.");

		LOGGER.info(String.format("2. Click edit button"));
		hotelSearchPage.EditLiquidBox();

		LOGGER.info("Click DestinationBox and Select one Option");
		hotelSearchPage.DestinationBox();

		LOGGER.info("Change Date");
		hotelSearchPage.ChangeDate();

		hotelSearchPage.SelectRooms();
		hotelSearchPage.isVisibleAdults();
		Assert.assertEquals(hotelSearchPage.isVisibleChildrens(), true);
		hotelSearchPage.ClickSearchButton();

		// Assert.assertTrue(searchResultsPage.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));

		// Click first search result and make sure that we are able to book it
	}

}
