package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopGooglePage.class)
public abstract class GooglePage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {

    }

    /*
     * Public Actions
     */

    /**
     * Enter a string EditField and click Search
     */


    public void enterWordAndSearch(String word) {
        LOGGER.info(String.format("Entering user %s into search field", word));
        getResultsTextBox().setText(word);
        getResultsTextBox().click();
    }


    public Boolean SearchEnterButton() {
        getSearchButton().click();
        LOGGER.info("Tap on Word Search Button");
        return true;
    }

    public SearchGoogleResultsPage ResultsSearchButton() {
        getSearchResultButton().click();
        LOGGER.info("Search Button");
        return PageFactory.create(SearchGoogleResultsPage.class);
    }


    @WebElementLocator(webDesktop = ".gLFyf")
    protected EditField getResultsTextBox() {
        return new EditField(this, getLocator(this, "getResultsTextBox"));
    }


    @WebElementLocator(webDesktop = " input[name='btnK']")
    protected Button getSearchButton() {
        return new Button(this, getLocator(this, "getSearchButton"));
    }

    @WebElementLocator(webDesktop = " input[name='btnK']")
    protected Button getSearchResultButton() {
        return new Button(this, getLocator(this, "getSearchResultButton"));
    }


}

/**
 * Desktop Implementation for GooglePage
 */
class DesktopGooglePage extends GooglePage {

}
