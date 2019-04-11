package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.applause.auto.framework.pageframework.webcontrols.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;

@WebDesktopImplementation(SearchResultsPage.class)
@WebTabletImplementation(SearchResultsPage.class)
@WebPhoneImplementation(SearchResultsPage.class)
public class SearchResultsPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// If we query for this element immediately the page doesn't load so we
		// need a short wait
		syncHelper.suspend(1000);
		syncHelper.waitForElementToAppear(getListResultLink());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Get the text from the search results summary for verification
	 * 
	 * @return the text from the search results summary
	 */
	public Boolean getSearchResultsSummaryText() {

		if(getListResultLink() != null){
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#search")
	protected Dropdown getListResultLink() {

		return new Dropdown(this, getLocator(this, "getListResultLink"));
	}
}