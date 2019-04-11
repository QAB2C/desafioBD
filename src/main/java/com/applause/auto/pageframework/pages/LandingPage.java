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

@WebDesktopImplementation(DesktopLandingPage.class)
@WebTabletImplementation(TabletLandingPage.class)
@WebPhoneImplementation(PhoneLandingPage.class)
public abstract class LandingPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {

		syncHelper.waitForElementToAppear(getSearchedWordTextBox());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the
	 * dropdown once it appears
	 * 
	 * @param searched text
	 * @return a SearchResultsPage
	 */
	public SearchResultsPage searchText(String text) {

		getSearchedWordTextBox().setText(text);
		getAjaxResult().click();
		LOGGER.info("Tap on Search Button");
		return PageFactory.create(SearchResultsPage.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "[name=q]")
	protected EditField getSearchedWordTextBox() {

		return new EditField(this, getLocator(this, "getSearchedWordTextBox"));
	}

	@WebElementLocator(webDesktop = "[jsname='erkvQe']")
	protected Link getAjaxResult() {

		return new Link(this, getLocator(this, "getAjaxResult"));
	}


	@WebElementLocator(webDesktop = "#tsf input[type=text]")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}


	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopLandingPage extends LandingPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingPage extends LandingPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingPage extends LandingPage {

}