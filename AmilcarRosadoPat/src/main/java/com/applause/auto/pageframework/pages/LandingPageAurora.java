package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;
import com.applause.auto.pageframework.Chunks.LoginAuroraChunk;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;

@WebDesktopImplementation(DesktopLandingPageAurora.class)
@WebTabletImplementation(TabletLandingPageAurora.class)
@WebPhoneImplementation(PhoneLandingPageAurora.class)

public abstract class LandingPageAurora extends AbstractPage {
	protected static final LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(1000);
	}

	public LoginAuroraChunk chunk() {
		LOGGER.info(String.format("Navigating to the landing page '%s'", TestData.URL_AURORA));
		getDriver().navigate().to(TestData.URL_AURORA);
		return PageFactory.create(LoginAuroraChunk.class);
	}

	public String getIngresoBienvenidoText() {
		return getTextBienvenido().getText();
	}

	public HomePageAurora home() {
		return PageFactory.create(HomePageAurora.class);
	}

	public MyBookingsAurora Misreservas() {
		return PageFactory.create(MyBookingsAurora.class);
	}

	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "#hoteles")
	protected Text getTextBienvenido() {
		return new Text(this, getLocator(this, "getTextBienvenido"));
	}

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopLandingPageAurora extends LandingPageAurora {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingPageAurora extends LandingPageAurora {

}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingPageAurora extends LandingPageAurora {

}