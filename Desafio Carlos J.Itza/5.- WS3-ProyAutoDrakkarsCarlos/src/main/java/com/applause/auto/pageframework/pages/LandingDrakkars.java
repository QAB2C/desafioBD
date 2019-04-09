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

@WebDesktopImplementation(DesktopLandingPageD.class)
@WebTabletImplementation(TabletLandingPageD.class)
@WebPhoneImplementation(PhoneLandingPageD.class)
public abstract class LandingDrakkars extends AbstractPage {

	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		// dismissPopup();
		// syncHelper.waitForElementToAppear(getDestinationTextBox());
	}

	/*
	 * Public Actions
	 */

	/**
	 * Enter a string destination city and then select the first result fron the dropdown once it appears
	 * 
	 * @param destinationName
	 */
	public void enterUser(String User) {
		LOGGER.info(String.format("Entering user", User));
		getUserTextBox().setText(User);
		syncHelper.waitForElementToAppear(getUserTextBox());
	}
	

	public void enterPass(String Pass) {
		LOGGER.info(String.format("Entering Paswword", Pass));
		getPassTextBox().setText(Pass);
		syncHelper.waitForElementToAppear(getPassTextBox());
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
//	public void SearhcDestinys(String destinationName) {
	// LOGGER.info(String.format("Entering destination %s into search field", destinationName));
	// getUserTextBox().setText(destinationName);
	// syncHelper.waitForElementToAppear(getDropdownItem2());
//		System.out.println(getDropdownItem2().getWebElement().getText());

//	}

	public void tapNextButton() {
		getNextButton().click();
		LOGGER.info("Tap on Next Button");
		}

	/*
	 * Protected Getters
	 */

    //Edita el campo de Usuario
	@WebElementLocator(webDesktop = "#i0116")
	protected EditField getUserTextBox() {
		return new EditField(this, getLocator(this, "getUserTextBox"));
	}

	// Oprime Boton Next
	@WebElementLocator(webDesktop = "#idSIButton9")
	protected Button getNextButton() {
		return new Button(this, getLocator(this, "getNextButton"));
	}
	// Oprime Boton Menu Dasborad
		@WebElementLocator(webDesktop = "#idSIButton9")
		protected Button getNextButton() {
			return new Button(this, getLocator(this, "getNextButton"));
		}
	
	//Edita campo de Contraseña
	@WebElementLocator(webDesktop = "#i0118")
	protected EditField getPassTextBox() {
		return new EditField(this, getLocator(this, "getPassTextBox"));
	}

 
	// Oprime Boton SignIn
		@WebElementLocator(webDesktop = "#idSIButton9")
		protected Button getSignInButton() {
			return new Button(this, getLocator(this, "getSignInButton"));
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
class DesktopLandingPageD extends LandingDrakkars {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletLandingPageD extends LandingDrakkars {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneLandingPageD extends LandingDrakkars {

}