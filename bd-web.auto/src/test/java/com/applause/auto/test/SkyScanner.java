package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.TestSky;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class SkyScanner extends BaseTest {
	private TestSky testSky;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH_KR }, description = "9483")
	public void testVideo() {

		LOGGER.info("1. Navigate to Search Box");
		testSky = navigateToSkyTest();
		Assert.assertNotNull(testSky, "Failed to navigate to the Search Box.");
		LOGGER.info("2. play to video");
		testSky.TapPlay();
		//testSky.TapPause();
	}
}
