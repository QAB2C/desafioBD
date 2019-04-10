package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;

@WebDesktopImplementation(DesktopLandingDesafio.class)
@WebTabletImplementation(TabletLandingDesafio.class)
@WebPhoneImplementation(PhoneLandingDesafio.class)

public abstract class LandingDesafio extends AbstractPage {
	protected static final LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(1000);
	}

	public LandingDesafio Landing() {
		LOGGER.info(String.format("Navigating to the landing page '%s'", TestData.Desafio_URL));
		getDriver().navigate().to(TestData.Desafio_URL);
		return PageFactory.create(LandingDesafio.class);
	}

	/*
	 * Protected Getters
	 */

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopLandingDesafio extends LandingDesafio {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingDesafio extends LandingDesafio {

}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingDesafio extends LandingDesafio {

}