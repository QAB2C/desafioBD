package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopLandingPage.class)
@WebTabletImplementation(TabletLandingPage.class)
@WebPhoneImplementation(PhoneLandingPage.class)
public abstract class ListPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
		syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#EtDestinyHtl")
	protected EditField getDestinationTextBox() {
		return new EditField(this, getLocator(this, "getDestinationTextBox"));
	}

	/*
	 * Private Helpers
	 */
	// private void dismissPopup() {
	// try {
	// LOGGER.info("Attempting to dismiss popup");
	// syncHelper.waitForElementToAppear(getPopupWelcomeText());
	// getDismissPopupButton().click();
	// } catch (NoSuchElementException e) {
	// LOGGER.info("Popup not found, moving on");
	// }
	//
	// }
}
