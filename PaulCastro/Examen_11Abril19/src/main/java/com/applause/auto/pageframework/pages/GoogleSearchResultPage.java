package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(SearchResultsPage.class)

public class GoogleSearchResultPage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        // If we query for this element immediately the page doesn't load so we
        // need a short wait
        syncHelper.suspend(1000);
        syncHelper.waitForElementToAppear(getSearchResults());
    }

    public String getSearchResultsSummaryText() {
        return getSearchResults().getText();
    }

    /*
     * Protected Getters
     */

    @WebElementLocator(webDesktop = "h1#firstHeading")
    protected Text getSearchResults() {
        return new Text(this, getLocator(this, "getSearchResultsSummary"));
    }
}
