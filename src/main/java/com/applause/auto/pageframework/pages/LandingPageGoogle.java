package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.NoSuchElementException;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;

public abstract class LandingPageGoogle extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	// @Override
	// protected void waitUntilVisible() {
	// dismissPopup();
	// syncHelper.waitForElementToAppear(getDestinationTextBox());
	// }

	@Override
	protected void waitUntilVisible() {
		logoGoogle();
		syncHelper.waitForElementToAppear(getGoogleSearchTextBox());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the
	 * dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public void enterDestinationAndConfirm(String destinationName) {
		LOGGER.info(String.format("Entering destination %s into search field", destinationName));
		getDestinationTextBox().setText(destinationName);
		syncHelper.waitForElementToAppear(getDropdownItem());
		getDropdownItem().click();
	}

	public void enterWordAndConfirm(String wordSeach) {
		LOGGER.info(String.format("Entering destination %s into search field", wordSeach));
		getGoogleSearchTextBox().setText(wordSeach);
		syncHelper.waitForElementToAppear(getDropdownItem());
		getDropdownItem().click();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	public SearchResultsPage tapSearchButton() {
		getSearchButton().click();
		LOGGER.info("Tap on Search Button");
		return PageFactory.create(SearchResultsPage.class);
	}

	public SearchResultsPageGoogle tapSearchButtonGoogle() {
		getSearchButtonGoogle().click();
		LOGGER.info("Tap on Search Button");
		return PageFactory.create(SearchResultsPageGoogle.class);
	}

	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "#ajhoteles")
	protected EditField getDestinationTextBox() {
		return new EditField(this, getLocator(this, "getDestinationTextBox"));
	}

	@WebElementLocator(webDesktop = ".room")
	protected EditField getNumberOfRoomsTextBox() {
		return new EditField(this, getLocator(this, "getNumberOfRoomsTextBox"));
	}

	@WebElementLocator(webDesktop = "#ui-active-menuitem")
	protected Link getDropdownItem() {
		return new Link(this, getLocator(this, "getDropdownItem"));
	}

	@WebElementLocator(webDesktop = "#btnSubmitHotels")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}

	/// Google
	@WebElementLocator(webDesktop = ".gLFyf gsfi")
	protected Button getSearchButtonGoogle() {
		return new Button(this, getLocator(this, "getSearchButtonGoogle"));
	}

	@WebElementLocator(webDesktop = "#account-lightbox")
	protected Text getPopupWelcomeText() {
		return new Text(this, getLocator(this, "getPopupWelcomeText"));
	}

	@WebElementLocator(webDesktop = "#d-icon-header-login-close")
	protected Button getDismissPopupButton() {
		return new Button(this, getLocator(this, "getDismissPopupButton"));
	}

	@WebElementLocator(webDesktop = ".RNNXgb")
	protected EditField getGoogleSearchTextBox() {
		return new EditField(this, getLocator(this, "getGoogleSearchTextBox"));
	}

	/*
	 * Private Helpers
	 */

	private void logoGoogle() {
		try {
			LOGGER.info("Attempt to show Logo");
			syncHelper.waitForElementToAppear(getGoogleSearchTextBox());
		} catch (NoSuchElementException e) {
			LOGGER.info("SearchBox not found");
		}

	}

}