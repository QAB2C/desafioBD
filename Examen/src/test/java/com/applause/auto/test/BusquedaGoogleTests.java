package com.applause.auto.test;

import com.applause.auto.pageframework.pages.GoogleSearchResultPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.applause.auto.pageframework.pages.BusquedaGooglePage;


public class BusquedaGoogleTests extends BaseTest {

    private BusquedaGooglePage BusquedaHomePage;
    private GoogleSearchResultPage GoogleSearchResult;

    @Test(groups = { TestConstants.TestNGGroups.GOOGLE_SEARCH }, description = "9483")
    public void testBusquedaGoogle() {

        LOGGER.info("1. Navigate into google page");
        BusquedaHomePage = navigateToGooglePage();

        // Assertions
        Assert.assertNotNull(BusquedaHomePage, "Failed to navigate into google page.");

        LOGGER.info(String.format("2. Enter %s word to search", TestConstants.TestData.WORDTEST));
        BusquedaHomePage.enterWordTestAndConfirm(TestConstants.TestData.WORDTEST);


        LOGGER.info("Click Search and expect to Google give LOOK xD....!!");
        GoogleSearchResult = BusquedaHomePage.tapSearchButton();

        Assert.assertTrue(GoogleSearchResult.getSearchResultsSummaryText().contains("Agujero negro"));



    }
}
