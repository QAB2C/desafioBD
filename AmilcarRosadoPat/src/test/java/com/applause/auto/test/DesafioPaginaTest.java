package com.applause.auto.test;

import org.testng.annotations.Test;

import com.applause.auto.pageframework.pages.LandingDesafio;
import com.applause.auto.pageframework.testdata.TestConstants.TestNGGroups;

public class DesafioPaginaTest extends BaseTest {

	private LandingDesafio landingDesafios;

	@Test(groups = { TestNGGroups.HOTEL_SEARCH }, description = " Test ")
	public void testDesafio() {

		LOGGER.info("1. Navigate to landing page");
		landingDesafios = DesafioPageWS();

	}
}
