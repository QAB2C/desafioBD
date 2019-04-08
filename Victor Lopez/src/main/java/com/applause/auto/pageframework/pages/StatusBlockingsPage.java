package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(StatusBlockingsPage.class)

public class StatusBlockingsPage extends AbstractPage {

    @Override
    protected void waitUntilVisible() {
        // If we query for this element immediately the page doesn't load so we
        // need a short wait
        syncHelper.suspend(1000);
        //syncHelper.waitForElementToAppear(getSearchResultsSummary());
    }

   // @WebElementLocator(webDesktop = "h2 Title")
    //protected Text getSearchResultsSummary() {
      //  return new Text(this, getLocator(this, "getSearchResultsSummary"));
    //}
}
