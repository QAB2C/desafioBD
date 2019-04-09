package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingDrakkars;
import com.applause.auto.pageframework.Chunks.LoginChunk;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class Hotels extends BaseTest {

	private LandingDrakkars landingPage;
	private LoginChunk chunklogin;

	@Test(groups = { TestNGGroups.HOTEL_DRAKKARS }, description = "9483")
	public void LoginDrakkars() {

		// Direccionamiento a la Pagina
		LOGGER.info("1.-Navigate to Landing Page");
		chunklogin = navigateDrakkars();

		// Ingresando Usuario
		LOGGER.info(String.format("2. Enter a User", TestConstants.TestData.USERNAME));
		chunklogin.enterUser(TestConstants.TestData.USERNAME);

		// Ingresando Contraseña
		LOGGER.info(String.format("3.- Enter a Password", TestConstants.TestData.PASSWORD));
		chunklogin.enterPass(TestConstants.TestData.PASSWORD);

	}
}
