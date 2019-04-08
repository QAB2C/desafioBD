package com.applause.auto.test;

import com.applause.auto.pageframework.pages.ExtranetAereosPage;
import com.applause.auto.pageframework.pages.StatusBlockingsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginExtranetAereosTest extends BaseTest {

    private ExtranetAereosPage ExtranetAereosPage;

    private StatusBlockingsPage StatusBlockingsPage;

    @Test(groups = { TestNGGroups.FLIGHT_SEARCH }, description = "TBT")
    public void testLogin() {
        LOGGER.info("1. Navigate to Extranet Flights ");
        ExtranetAereosPage = navigateToExtranetAereosPage();

        //Assertions
        Assert.assertNotNull(ExtranetAereosPage, "Failed to navigate to the Extranet Flights page.");

        LOGGER.info(String.format("2. Enter %s into User box", TestConstants.TestData.USERNAME));
        ExtranetAereosPage.enterUser(TestConstants.TestData.USERNAME);

        LOGGER.info(String.format("3. Enter %s into Password box", TestConstants.TestData.PASSWORD));
        ExtranetAereosPage.enterPassword(TestConstants.TestData.PASSWORD);

        LOGGER.info(String.format("4. Enter %s into Domain box", TestConstants.TestData.DOMAIN));
        ExtranetAereosPage.enterDomain(TestConstants.TestData.DOMAIN);

        LOGGER.info("5.Click and expect to Enter at Status of Blockings page");
        StatusBlockingsPage = ExtranetAereosPage.LogingEnterButton();

        Assert.assertNotNull(StatusBlockingsPage, "Failed to navigate to the Status Blockings page.");


    }


}