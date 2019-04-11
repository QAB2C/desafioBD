package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

import java.lang.invoke.MethodHandles;
@WebDesktopImplementation(DesktopGooglePage.class)
public abstract class GooglePage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        //dismissPopup();
        //syncHelper.waitForElementToAppear(getDestinationTextBox());
    }

    /*
     * Public Actions
     */

    /**
     * Enter a string EditField and click Search
     *
     *
     */


    public void enterWordAndSearch(String word) {
        LOGGER.info(String.format("Entering user %s into search field", word));
        getResultsTextBox().setText(word);
        getResultsTextBox().click();
    }

    @WebElementLocator(webDesktop = ".gLFyf gsfi")
    protected EditField getResultsTextBox() {
        return new EditField(this, getLocator(this, "getResultsTextBox"));
    }

}

/**
 * Desktop Implementation for GooglePage
 */
class DesktopGooglePage extends GooglePage {

}
