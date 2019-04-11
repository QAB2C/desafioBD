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
		getDropdownItem().click();
	}
	
	public void Buscar() {
		getBusquedaTextBox().click();
		getBusquedaTextBox().setText("Perro");
		
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

	@WebElementLocator(webDesktop = ".gLFyf gsfi")
	protected EditField getBusquedaTextBox() {
		return new EditField(this, getLocator(this, "getBusqueda"));
	}
	
	@WebElementLocator(webDesktop = ".btnK")
	protected Button getWaitingPage() {
		return new Button(this, getLocator(this, "getWaitingPage"));
	}

	@WebElementLocator(webDesktop = "#ui-active-menuitem")
	protected Link getDropdownItem() {
		return new Link(this, getLocator(this, "getDropdownItem"));
	}

	
	@WebElementLocator(webDesktop = "#d-icon-header-login-close")
	protected Button getDismissPopupButton() {
		return new Button(this, getLocator(this, "getDismissPopupButton"));
	}
	
	

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