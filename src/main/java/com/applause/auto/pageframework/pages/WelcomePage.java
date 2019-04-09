package com.applause.auto.pageframework.pages;

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

import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(DesktopWelcomePage.class)
@WebTabletImplementation(TabletWelcomePage.class)
@WebPhoneImplementation(PhoneWelcomePage.class)
public abstract class WelcomePage extends AbstractPage {

    protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

    @Override
    protected void waitUntilVisible() {
        //syncHelper.waitForElementToAppear(getMyBookingsLink());
    }

    public void tapMyBookingsLink() {
        getMyBookingsLink().click();
        LOGGER.info("Tap on All Reservas Button");
        syncHelper.suspend(5000);
       // return PageFactory.create(WelcomePage.class);

    }

    public void tapALLBookings() {
        getALLBookingsButton().click();
        LOGGER.info("Tap on All Reservas Button");
        syncHelper.suspend(5000);
        //return PageFactory.create(WelcomePage.class);

    }

    @WebElementLocator(webDesktop = "//a[@href='/MyBookings/List' and contains(text(),' Mis reservas')]")
    protected Link getMyBookingsLink() {
        return new Link(this, getLocator(this, "getMyBookingsLink"));
    }

    @WebElementLocator(webDesktop = "#All")
    protected Button getALLBookingsButton() {
        return new Button(this, getLocator(this, "getALLBookingsButton"));
    }

}

/**
 * Desktop Implementation for RandonPage
 */
class DesktopWelcomePage extends WelcomePage {

}

/**
 * Tablet Implementation for WelcomePage
 */
class TabletWelcomePage extends WelcomePage {
}

/**
 * Phone Implementation for WelcomePage
 */
class PhoneWelcomePage extends WelcomePage {

}