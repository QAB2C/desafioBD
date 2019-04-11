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
import java.lang.invoke.MethodHandles;

@WebDesktopImplementation(GoogleLandingPage.class)
@WebTabletImplementation(GoogleLandingPage.class)
@WebPhoneImplementation(GoogleLandingPage.class)

public class GoogleLandingPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
		// syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

	}


class DesktopGoogleLandingPage extends GoogleLandingPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGoogleLandingPage extends GoogleLandingPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGoogleLandingPage extends GoogleLandingPage {

}
