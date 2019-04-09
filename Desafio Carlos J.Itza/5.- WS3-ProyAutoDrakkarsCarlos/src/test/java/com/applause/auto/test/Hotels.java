package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingDrakkars;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class Hotels extends BaseTest {

	private LandingDrakkars landingPage;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.LOGIN }, description = "9483")
	public void testSearchForCancunHotel() {

		// Direccionamiento a la Pagina
		LOGGER.info("1.-Navigate to Landing Page");
		landingPage = navigateDrakkars();
		
		// Ingresando Usuario
		LOGGER.info(String.format("2. Enter a User", TestConstants.TestData.USERNAME));
		landingPage.enterUser(TestConstants.TestData.USERNAME);
		
		// Ingresando Button Next
		LOGGER.info("3.-Click Next");
		searchResultsPage = landingPage.tapNextButton();
		
		//Ingresando Contraseña
		LOGGER.info(String.format("4.- Enter a Password", TestConstants.TestData.PASSWORD));
		landingPage.enterPass(TestConstants.TestData.PASSWORD);
        
		
	}
}
