package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(ActivityProductCountriesPage.class)
@WebTabletImplementation(ActivityProductCountriesPage.class)
@WebPhoneImplementation(ActivityProductCountriesPage.class)
public class ActivityProductCountriesPage extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getShowInactivesText());
	}

	/*
	 * Public Actions
	 */
	/**
	 * Returns the URL with String format
	 */
	public String GetURL() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//label[@for='show-inactives']")
	protected Text getShowInactivesText() {
		return new Text(this, getLocator(this, "getShowInactivesText"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopActivityProductCountriesPage extends ActivityProductCountriesPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletActivityProductCountriesPage extends ActivityProductCountriesPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneActivityProductCountriesPage extends ActivityProductCountriesPage {

}
