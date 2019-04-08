package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.NoSuchElementException;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;

public class SiteFlightsPage extends AbstractPage{

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        dismissPopup();

    }

    @WebElementLocator(webDesktop = "#account-lightbox")
    protected Text getPopupWelcomeText() {
        return new Text(this, getLocator(this, "getPopupWelcomeText"));
    }

    @WebElementLocator(webDesktop = "#d-icon-header-login-close") ///FindElement
    protected Button getDismissPopupButton() {
        return new Button(this, getLocator(this, "getDismissPopupButton"));
    }

    /*
     * Private Helpers
     */
    private void dismissPopup() {
        try {
            LOGGER.info("Attempting to dismiss popup");
            syncHelper.waitForElementToAppear(getPopupWelcomeText());
            getDismissPopupButton().click();
        } catch (NoSuchElementException e) {
            LOGGER.info("Popup not found, moving on");
        }

    }
}
