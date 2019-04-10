package com.applause.auto.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.CancellationPoliciesKRChunk;
import com.applause.auto.pageframework.pages.HotelListKR;
import com.applause.auto.pageframework.pages.RoomListKR;
import com.applause.auto.pageframework.pages.SearchBoxKR;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class HotelSearchKR extends BaseTest {
	private SearchBoxKR searchBoxKR;
	private HotelListKR hotelListPageKR;
	private RoomListKR roomListKR;
	private CancellationPoliciesKRChunk cancellationPoliciesKRChunk;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH_KR }, description = "9483")
	public void testShowCancellationPolicies() {

		LOGGER.info("1. Navigate to Search Box");
		searchBoxKR = navigateToSearchBoxKR();

		// Assertions
		Assert.assertNotNull(searchBoxKR, "Failed to navigate to the Search Box.");

		LOGGER.info("2. Expand search box");
		searchBoxKR.expandSearchBoxAjax();

		LOGGER.info(String.format("3. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		searchBoxKR.enterDestination(TestConstants.TestData.DESTINATION);

		LOGGER.info(String.format("4. Enter start booking date %s ", TestConstants.TestData.STARTDATE));
		searchBoxKR.enterDates(TestConstants.TestData.STARTDATE);

		LOGGER.info(String.format("5. Enter end booking date %s ", TestConstants.TestData.ENDDATE));
		searchBoxKR.enterDates(TestConstants.TestData.ENDDATE);

		LOGGER.info(String.format("6. Select %2d adults in the select", TestConstants.TestData.ADULTS));
		searchBoxKR.selectAdults(TestConstants.TestData.ADULTS);

		LOGGER.info("7. Tap to search and Navigate to Hotel List");
		hotelListPageKR = searchBoxKR.tapSearchButton();

		Assert.assertNotNull(hotelListPageKR, "Failed to navigate to the Hotel List");

		LOGGER.info("8. Get first price hotel");
		hotelListPageKR.getSearchFirstResult();

		LOGGER.info("9. Get hotel list with prices and select to Navigate to the Room List");
		roomListKR = hotelListPageKR.getResultListAndSelect();

		Assert.assertNotNull(roomListKR, "Failed to navigate to the Room List");

		LOGGER.info("10. Tap to access to the room section");
		roomListKR.tapRooms();

		LOGGER.info("11. Tap on first Cancellation Policy Link");
		cancellationPoliciesKRChunk = roomListKR.tapCancellationPolicy();

		Assert.assertNotNull(cancellationPoliciesKRChunk, "Failed to show Cancellation Policies Modal Chunk");

		LOGGER.info("12. Show Cancellation Policies");
		assertEquals(cancellationPoliciesKRChunk.modalTitle(), "Políticas de cancelación");
	}
}
