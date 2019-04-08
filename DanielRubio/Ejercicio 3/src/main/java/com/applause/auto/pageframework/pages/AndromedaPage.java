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
import com.applause.auto.framework.pageframework.webcontrols.Dropdown;
import com.applause.auto.framework.pageframework.webcontrols.EditField;
import com.applause.auto.framework.pageframework.webcontrols.Link;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopAndromedaPage.class)
@WebTabletImplementation(TabletAndromedaPage.class)
@WebPhoneImplementation(PhoneAndromedaPage.class)
public abstract class AndromedaPage extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		dismissPopup();
		syncHelper.waitForElementToAppear(getDestinationTextBox());
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
		System.out.print(getDropdownItem().getWebElement().getText());
		//getDropdownItem().click();
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

	@WebElementLocator(webDesktop = ".ui-autocomplete")
	protected Dropdown getDropdownItem() {
		return new Dropdown(this, getLocator(this, "getDropdownItem"));
	}

	@WebElementLocator(webDesktop = "#btnSubmitHotels")
	protected Button getSearchButton() {
		return new Button(this, getLocator(this, "getSearchButton"));
	}

	@WebElementLocator(webDesktop = "#account-lightbox")
	protected Text getPopupWelcomeText() {
		return new Text(this, getLocator(this, "getPopupWelcomeText"));
	}

	@WebElementLocator(webDesktop = "#d-icon-header-login-close")
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

/**
 * Desktop Implementation for LandingPage
 */
class DesktopAndromedaPage extends AndromedaPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletAndromedaPage extends AndromedaPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneAndromedaPage extends AndromedaPage {

}