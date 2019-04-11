package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.Keys;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.EditField;

@WebDesktopImplementation(DesktopGoogleSearchPage.class)
@WebTabletImplementation(TabletGoogleSearchPage.class)
@WebPhoneImplementation(PhoneGoogleSearchPage.class)

public class GoogleSearchPage extends AbstractPage {

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

	public GoogleResultsPage gotoGoogleResultsPage() {
		return PageFactory.create(GoogleResultsPage.class);
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
class DesktopGoogleSearchPage extends GoogleSearchPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletGoogleSearchPage extends GoogleSearchPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneGoogleSearchPage extends GoogleSearchPage {
}
