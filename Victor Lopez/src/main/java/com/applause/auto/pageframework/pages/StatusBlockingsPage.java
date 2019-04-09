package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.AbstractPage;


@WebDesktopImplementation(StatusBlockingsPage.class)

public class StatusBlockingsPage extends AbstractPage {

    @Override
    protected void waitUntilVisible() {
        // If we query for this element immediately the page doesn't load so we
        // need a short wait
        syncHelper.suspend(1000);
        //syncHelper.waitForElementToAppear();
        //syncHelper.waitForElementToAppear(getSearchResultsSummary());
    }

    // @WebElementLocator(webDesktop = "h2 Title")
    //protected Text getSearchResultsSummary() {
    //  return new Text(this, getLocator(this, "getSearchResultsSummary"));
    //}
}
