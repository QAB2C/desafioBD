package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopHomeGooglePage.class)
@WebTabletImplementation(TabletHomeGooglePage.class)
@WebPhoneImplementation(PhoneHomeGooglePage.class)
public abstract class HomeGooglePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getSearchTextBox());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */

	public void searchGoogle(String search) {
		syncHelper.waitForElementToAppear(getSearchTextBox());
		getSearchTextBox().setText(search);
	}

	public Boolean containsResults() {
		if (getSearchTextBox().exists()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//input[@class='gLFyf gsfi']")
	protected EditField getSearchTextBox() {
		return new EditField(this, getLocator(this, "getSearchTextBox"));
	}

	/*
	 * Private Helpers
	 */

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopHomeGooglePage extends HomeGooglePage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletHomeGooglePage extends HomeGooglePage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneHomeGooglePage extends HomeGooglePage {

}