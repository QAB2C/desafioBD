package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(SearchResultGooglePage.class)
@WebTabletImplementation(SearchResultGooglePage.class)
@WebPhoneImplementation(SearchResultGooglePage.class)



public class SearchResultGooglePage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getSearchResultsSummary());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get the text from the search results summary for verification
	 *
	 * @return the text from the search results summary
	 */
	public String getSearchResultsSummaryText() {
		return getSearchResultsSummary().getText();
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "h1 span")
	protected Text getSearchResultsSummary() {
		return new Text(this, getLocator(this, "getSearchResultsSummary"));
	}
}
