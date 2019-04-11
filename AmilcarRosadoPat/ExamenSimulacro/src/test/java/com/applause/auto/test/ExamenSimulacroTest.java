package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.PagePrincipalGoogle;
import com.applause.auto.pageframework.pages.ResultadosGooglePage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class ExamenSimulacroTest extends BaseTest {

	private PagePrincipalGoogle landingPage;
	private ResultadosGooglePage ResultadosGoogle;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = "Examen")
	public void testExamenGoogle() {

		LOGGER.info("1. Navigate to landing page");
		landingPage = LandingGoogle();

		LOGGER.info(String.format("2. Palabra a buscar %s", TestConstants.TestData.Busqueda));
		landingPage.IngresoBusqueda(TestConstants.TestData.Busqueda);
		landingPage.tapSearchButton();

		LOGGER.info(String.format("3. Si llega hasta aqui"));
		// Assertions
		Assert.assertEquals(ResultadosGoogle.ListHotels(), true);

	}
}
