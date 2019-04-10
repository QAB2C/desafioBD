package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.CotizacionPage;
import com.applause.auto.pageframework.pages.VuelosLoginPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class VuelosTest extends BaseTest {

	private VuelosLoginPage vuelosLoginPage;
	private CotizacionPage cotizacionPage;

	@Test(groups = { TestNGGroups.LOGIN_VUELOS }, description = "9483")
	public void testSearchForVuelos() {

		LOGGER.info("1. Navigate to vuelos page");
		vuelosLoginPage = navigateToVuelosLoginPage();

		// Assertions
		Assert.assertNotNull(vuelosLoginPage, "Failed to navigate to the vuelosLoginPage.");

		LOGGER.info(String.format("2. Enter user into user box", TestConstants.TestData.USER));
		vuelosLoginPage.enterUser(TestConstants.TestData.USER);

		LOGGER.info(String.format("3. Enter password into password box", TestConstants.TestData.PASSWORDWM));
		vuelosLoginPage.enterPassword(TestConstants.TestData.PASSWORDWM);

		LOGGER.info(String.format("4. Enter Ingresar"));
		cotizacionPage = vuelosLoginPage.IngresarButton();

		LOGGER.info(String.format("5. Enter Cotizacion"));
		cotizacionPage.IngresarCotizar();

		// LOGGER.info(String.format("6. Enter asociado into asociado box", TestConstants.TestData.ASOCIADO));
		// cotizacionPage.enterAsociado(TestConstants.TestData.ASOCIADO);
	}
}
