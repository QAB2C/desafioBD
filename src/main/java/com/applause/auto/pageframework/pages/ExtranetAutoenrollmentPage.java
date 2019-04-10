package com.applause.auto.pageframework.pages;


import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopExtranetAutoenrollmentPage.class)

public abstract class ExtranetAutoenrollmentPage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        syncHelper.waitForElementToAppear(getEMailTextBox());
    }

    public void enterEMail(String mailName) {
        LOGGER.info(String.format("Entering Wrong Mail %s into E-Mail field", mailName));
        getEMailTextBox().setText(mailName);
    }

    @WebElementLocator(webDesktop = "#mat-input-0")
    protected EditField getEMailTextBox() {
        return new EditField(this, getLocator(this, "getEMailTextBox"));
    }

}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopExtranetAutoenrollmentPage extends ExtranetAutoenrollmentPage {

}
