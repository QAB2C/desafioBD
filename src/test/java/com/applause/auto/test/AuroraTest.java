package com.applause.auto.test;

import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.RandomPage;

import com.applause.auto.pageframework.pages.WelcomePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuroraTest extends BaseTest {

    private HomePage paginaInicio;
    private WelcomePage cotizacion;



    @Test(groups = {TestNGGroups.LOGIN})
    public void Login() {

        LOGGER.info("1. Navigate to Home page");
        paginaInicio = navigateToHomePage();
        cotizacion = paginaInicio.ingresarDatos(TestConstants.TestData.USERNAME,TestConstants.TestData.PASSWORD);
        cotizacion.tapMyBookingsLink();
        cotizacion.tapALLBookings();

          // Assertions
        Assert.assertNotNull(paginaInicio, "Failed to navigate to the landing page.");


    }
}
