package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(SearchResultsPage.class)
@WebTabletImplementation(SearchResultsPage.class)
@WebPhoneImplementation(SearchResultsPage.class)
public class SearchResultsPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getSearchResultsSummary());
	}

	/*
	 * Public Actions
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