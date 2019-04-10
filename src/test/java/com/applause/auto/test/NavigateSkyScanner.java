package com.applause.auto.test;

import com.applause.auto.pageframework.pages.NavigateToRandomPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateSkyScanner extends BaseTest {

    private NavigateToRandomPage NavigateRandom;

    @Test(groups = { TestConstants.TestNGGroups.LoginTest }, description = "9483")

    public void test() {

        LOGGER.info("1. Navigate into ExtranetAutoenrollmentPage");
        NavigateRandom = navigateToCNN();

        // Assertions

        Assert.assertNotNull(NavigateRandom, "Failed to navigate into ExtranetAutoenrollmentPage.");

    }



}

