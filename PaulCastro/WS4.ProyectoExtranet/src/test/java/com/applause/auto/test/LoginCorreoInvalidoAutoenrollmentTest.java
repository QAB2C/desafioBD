
package com.applause.auto.test;

import com.applause.auto.pageframework.Chunks.LoginChunk;
import com.applause.auto.pageframework.pages.ExtranetAutoenrollmentPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginCorreoInvalidoAutoenrollmentTest extends BaseTest {

    private ExtranetAutoenrollmentPage ExtranetAuto;
    private LoginChunk LoginChunk;

    @Test(groups = { TestNGGroups.LoginTest }, description = "9483")
    public void testInsertWrongMail() {

        LOGGER.info("1. Navigate into ExtranetAutoenrollmentPage");
        ExtranetAuto = navigateToExtranetWeb();

        // Assertions

        Assert.assertNotNull(ExtranetAuto, "Failed to navigate into ExtranetAutoenrollmentPage.");
        LOGGER.info(String.format("2. Enter %s into E-mail field", TestConstants.TestData.EMAILUSER));
        ExtranetAuto.enterEMail(TestConstants.TestData.EMAILUSER);

        LOGGER.info("Expect the tittle name of Login");
        Assert.assertTrue(LoginChunk.getLoginTittleText().contains("Bienvenidos al Registro de alojamiento en BestDay"));

        // Click first search result and make sure that we are able to book it
    }
}