package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.Chunks.LoginAuroraChunk;
import com.applause.auto.pageframework.pages.HomePageAurora;
import com.applause.auto.pageframework.pages.LandingPageAurora;
import com.applause.auto.pageframework.pages.MyBookingsAurora;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class LoginTest extends BaseTest {

	private LandingPageAurora landingPage;
	private LoginAuroraChunk LoginAuroraChunk;
	private HomePageAurora HomeAurora;
	private MyBookingsAurora MisReservas;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = " Test ")
	public void testLoginAurora() {

		LOGGER.info("1. Navigate to landing page");
		landingPage = navigateToLandingPage();

		LOGGER.info(String.format("2. Ingreso Usuario %s, Ingreso de password %s", TestConstants.TestData.USER,
				TestConstants.TestData.PASSWORD));
		LoginAuroraChunk = landingPage.chunk();
		LoginAuroraChunk.UserPassword(TestConstants.TestData.USER, TestConstants.TestData.PASSWORD);

		LOGGER.info("Click Ingresar");
		LoginAuroraChunk.IngresarButtom();

		// Assertions
		Assert.assertTrue(landingPage.getIngresoBienvenidoText().contains("Destino/hotel"));

		LOGGER.info(String.format("3. Enter %s into destination box", TestConstants.TestData.DESTINATION));
		HomeAurora = landingPage.home();
		HomeAurora.Destination(TestConstants.TestData.DESTINATION);

		// Assertions
		Assert.assertEquals(HomeAurora.ListHotels(), true);

		LOGGER.info(String.format("4. Ingreso a Mis Reservas"));
		MisReservas = landingPage.Misreservas();
		MisReservas.IngresarMR();
		MisReservas.AllMR();

	}
}
