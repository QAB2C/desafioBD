package com.applause.auto.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingDrakkars;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class DrakarsTest extends BaseTest{

	private LandingDrakkars LandingDrakars;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.DRAKARS_SEARCH }, description = "9483")
	public void testSearchForCancunHotel() {

		// Direccionamiento a la Pagina
				LOGGER.info("1.-Navigate to Landing Page");
				LandingDrakars = navigateDrakkars();
				
				// Ingresando Usuario
				LOGGER.info(String.format("2. Enter a User", TestConstants.TestData.USERNAME));
				LandingDrakars.enterUser(TestConstants.TestData.USERNAME);
				
				// Ingresando Button Next
				LOGGER.info("3.-Click Next");
				LandingDrakars.tapNextButton();
				
				//Ingresando Contraseña
				LOGGER.info(String.format("4.- Enter a Password", TestConstants.TestData.PASSWORD));
				LandingDrakars.enterPass(TestConstants.TestData.PASSWORD);
				
				// Iniciar Sesion.
				LOGGER.info("5.-Iniciar Sesion");
				LandingDrakars.tapNextButton();
				LandingDrakars.tapNextButton();
				
				// Seleecionar Menu
				LOGGER.info("5.-Iniciar Sesion");
				LandingDrakars.tapNextButton();
				LandingDrakars.tapNextButton();
						
	}
	
	
	
	}