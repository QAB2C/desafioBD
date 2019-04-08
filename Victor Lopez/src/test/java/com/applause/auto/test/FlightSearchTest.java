package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.SiteFlightsPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class FlightSearchTest extends BaseTest {

    private SiteFlightsPage SiteFlightsPage;

    @Test(groups = { TestNGGroups.FLIGHT_SEARCH }, description = "TBT")

    public void Search() {
        LOGGER.info("1. Navigate to Site Flights");
        SiteFlightsPage = navigateToSiteFlightsPage();

        //Assertions
        Assert.assertNotNull(SiteFlightsPage, "Failed to navigate to the Site Flights page.");


    }


}