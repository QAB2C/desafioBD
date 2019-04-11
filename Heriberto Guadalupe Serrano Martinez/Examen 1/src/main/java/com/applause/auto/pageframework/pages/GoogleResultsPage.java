package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;

@WebDesktopImplementation(DesktopGoogleResultsPage.class)
@WebTabletImplementation(TabletGoogleResultsPage.class)
@WebPhoneImplementation(PhoneGoogleResultsPage.class)

public class GoogleResultsPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getResultsLinks());
	}

	/*
	 * Public Actions
	 */

	/**
	 * return Boolean true if exists
	 * 
	 */
	public Boolean containsResults() {
		if (getResultsLinks().exists()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "div.srg > div.g")
	protected Dropdown getResultsLinks() {
		return new Dropdown(this, getLocator(this, "getResultsLinks"));
	}

	/*
	 * Private Helpers
	 */

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGoogleResultsPage extends GoogleResultsPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGoogleResultsPage extends GoogleResultsPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGoogleResultsPage extends GoogleResultsPage {
}
