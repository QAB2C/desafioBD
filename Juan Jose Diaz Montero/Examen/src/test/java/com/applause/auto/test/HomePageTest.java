package com.applause.auto.test;

import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private LandingPage landingPage;
    private SearchResultsPage HomePage;

    @Test(groups = { TestConstants.TestNGGroups.URL }, description = "9483")
    public void testSearchForCancunHotel() {

        LOGGER.info("1. Navigate to landing page");
        landingPage = navigateToLandingPage();

        // Assertions
        Assert.assertNotNull(landingPage, "Failed to navigate to the landing page.");

        LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.SEARCHG));
        landingPage.enterDestinationAndConfirm(TestConstants.TestData.SEARCHG);

        LOGGER.info("Click Search and expect to land at Search Results page");
        com.applause.auto.pageframework.pages.HomePage = landingPage.tapSearchButton();

        Assert.assertTrue(HomePage.getSearchResultsSummaryText().contains("concuerdan con tu búsqueda"));

        // Click first search result and make sure that we are able to book it
    }
}
