package com.applause.auto.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.LandingPage;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class HomeGoogleTest extends BaseTest{
	private LandingPage landingPageGoogle;
	private SearchResultsPage searchResultsPage;

	@Test(groups = { TestNGGroups.GOOGLE_SEARCH }, description = "9483")
	public void testSearchForCancunHotel() {

		LOGGER.info("1. Navigate to landing page");
		landingPageGoogle = navigateToLandingPage();
		
		LOGGER.info("2. Insertar busqueda de una pagina");
		driver.findElement(By.className("gLFyf gsfi")).sendKeys("kayak cancun");
		driver.findElement(By.className("sA5rQ")).click();
			
		// Click first search result and make sure that we are able to book it
	}
}
