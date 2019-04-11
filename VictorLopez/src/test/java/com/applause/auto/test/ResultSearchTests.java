package com.applause.auto.test;

import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.pageframework.pages.LandingPage;

import com.applause.auto.pageframework.pages.GooglePage;
import com.applause.auto.pageframework.pages.SearchGoogleResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultSearchTests extends BaseTest {

    private GooglePage GooglePage; //
    private SearchGoogleResultsPage SearchGoogleResultsPage;

    @Test(groups = {TestNGGroups.HOTEL_SEARCH}, description = "9483")
    public void testSearchForCancunHotel() {

        LOGGER.info("1. Navigate to Google Home page");
        GooglePage = navigateToGooglePage();

        // Assertions
        Assert.assertNotNull(GooglePage, "Failed to navigate to the Google Home page.");

        LOGGER.info(String.format("2. Enter %s into destination box", TestConstants.TestData.WORDSEARCH));
        GooglePage.enterWordAndSearch(TestConstants.TestData.WORDSEARCH);

        LOGGER.info(" 3.Click Search and expect Search Results in Result page");
        GooglePage.SearchEnterButton();
        Assert.assertNotNull(GooglePage, "Failed to expect Result page.");

        LOGGER.info("4.Click and expect tO result page");
        SearchGoogleResultsPage = GooglePage.ResultsSearchButton();

    }
}
