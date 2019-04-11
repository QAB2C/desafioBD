package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import org.openqa.selenium.Keys;

import java.lang.invoke.MethodHandles;

public class LandingPageGoogle extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        syncHelper.waitForElementToAppear(getSearchBox());
    }

    /*
     * Public Actions
     */

    /**
     * Enter a string Search *
     *
     * @param search
     */
    public void entersearchandGo(String search) {
        getSearchBox().setText(search);
        getSearchBox().sendKey(Keys.ENTER);
    }

    public HomePage gotoGoogleResultsPage() {
        return PageFactory.create(HomePage.class);
    }

    /*
     * Protected Getters
     */

    @WebElementLocator(webDesktop = "input.gLFyf ")
    protected EditField getSearchBox() {
        return new EditField(this, getLocator(this, "getSearchBox"));
    }

    /*
     * Private Helpers
     */

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopGoogleSearchPage extends HomePage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGoogleSearchPage extends HomePage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGoogleSearchPage extends HomePage {
}