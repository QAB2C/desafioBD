package com.applause.auto.pageframework.Chunks;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.pageframework.pages.ActivityProductMainPage;

@WebDesktopImplementation(ActivityProductLoginChunck.class)
@WebTabletImplementation(ActivityProductLoginChunck.class)
@WebPhoneImplementation(ActivityProductLoginChunck.class)

public class ActivityProductLoginChunck extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getUserTextBox());
	}

	/*
	 * Public Actions
	 */
	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public void Login(String user, String password) {
		LOGGER.info(String.format("Entering user %s into user field", user));
		getUserTextBox().setText(user);
		LOGGER.info(String.format("Entering password %s into password field", ""));
		getPasswordTextBox().setText(password);
		LOGGER.info(String.format("Click button", ""));
	}

	public String GetURL() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */

	public ActivityProductMainPage tapLoginButton() {
		getSubmitButton().click();
		LOGGER.info("Tap on Login Button");
		return PageFactory.create(ActivityProductMainPage.class);
	}
	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#UserName")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	@WebElementLocator(webDesktop = "#Password")
	protected EditField getPasswordTextBox() {
		return new EditField(this, getLocator(this, "getPasswordTextBox"));
	}

	@WebElementLocator(webDesktop = "//button[@class='btn waves-effect waves-light col s12 azul-marinobd']")
	protected Button getSubmitButton() {
		return new Button(this, getLocator(this, "getSubmitButton"));
	}
	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopActivityProductLoginChunck extends ActivityProductLoginChunck {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletActivityProductLoginChunck extends ActivityProductLoginChunck {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneActivityProductLoginChunck extends ActivityProductLoginChunck {

}
