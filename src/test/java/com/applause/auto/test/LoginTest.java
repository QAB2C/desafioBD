package com.applause.auto.test;


import com.applause.auto.pageframework.pages.LandingPageAndromeda;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private LandingPageAndromeda landingPage;
    private SearchResultsPage searchResultsPage;

    @Test(groups = { TestConstants.TestNGGroups.HOTEL_SEARCH }, description = "TBD")
    public void testLogin() {

        LOGGER.info("1. Navigate to landing page Andromeda");
        landingPage = navigateToLandingPageAndromeda();

        // Assertions
        Assert.assertNotNull(landingPage, "Failed to navigate to the landing page.");

        LOGGER.info("Click Search and expect to land at Search Package page");
        searchResultsPage = landingPage.tapSearchButton();


        // Click first search result and make sure that we are able to book it
    }



}
