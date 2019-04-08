package com.applause.auto.pageframework.Chunks;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(ActivityProductMenuChunk.class)
@WebTabletImplementation(ActivityProductMenuChunk.class)
@WebPhoneImplementation(ActivityProductMenuChunk.class)

public class ActivityProductMenuChunk extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getMenu());
	}

	/*
	 * Public Actions
	 */
	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public String validateUser() {
		return getUserText().getText();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//span[@class='bold']")
	protected Text getUserText() {
		return new Text(this, getLocator(this, "getUserText"));
	}

	@WebElementLocator(webDesktop = "//ul[@id='slide-out']")
	protected Dropdown getMenu() {
		return new Dropdown(this, getLocator(this, "getMenu"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopActivityProductMenuChunk extends ActivityProductMenuChunk {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletActivityProductMenuChunk extends ActivityProductMenuChunk {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneActivityProductMenuChunk extends ActivityProductMenuChunk {

}
